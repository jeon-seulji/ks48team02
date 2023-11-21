package ksmart.ks48team02.user.controller.reward;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.admin.service.coupon.AdminCouponService;
import ksmart.ks48team02.common.dto.DeliveryMessage;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.controller.PojectRegistrationContoller;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.donation.DonationService;
import ksmart.ks48team02.user.service.reward.RewardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Controller("userRewardController")
@RequestMapping("/user/reward")
@AllArgsConstructor
public class RewardController {

    private static final Logger log = LoggerFactory.getLogger(PojectRegistrationContoller.class);
    private static final Logger Log = LoggerFactory.getLogger(RewardController.class);
    private final RewardService rewardService;
    private final AdminCouponService adminCouponService;
    private final DonationService donationService;


    //리워드 메인 페이지
    @GetMapping(value = {"" , "/"})
    public String mainPage(Model model) {


        List<RewardProject> rewardProjectList = rewardService.rewardProjectList();
        model.addAttribute("rewardProjectList",rewardProjectList);

        return "user/reward/main";
    }

    //리워드 상세 페이지
    @GetMapping("/detail")
    public String detailPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);

        model.addAttribute("rewardProject",rewardProject);
        log.info("프로젝트 상세페이지 정보 : {}",rewardProject);

        return "user/reward/detail/main";
    }

    //리워드 상세 페이지 댓글
    @GetMapping("/detail/comment")
    public String commentPage(HttpSession session, Model model,
                              @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        //접속 회원 아이디
        String memberId = (String)session.getAttribute("SID");
        //프로젝트 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //댓글 리스트 조회
        List<RewardComment> rewardCommentList = rewardService.getCommentList(rewardProjectCode);

        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("memberId", memberId);
        model.addAttribute("rewardCommentList", rewardCommentList);


        return "user/reward/detail/comment";
    }

    //댓글 등록
    @PostMapping("/detail/comment")
    public String commentAdd(HttpSession session, Model model,
                             @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                             @RequestParam(name = "commentContent") String commentContent){


        String memberId = (String)session.getAttribute("SID");
        String memberName = (String) session.getAttribute("SNAME");



        rewardService.addRewardComment(memberId, rewardProjectCode, memberName, commentContent);

        return "redirect:/user/reward/detail/comment?rewardProjectCode=" + rewardProjectCode;
    }

    //댓글 삭제
    @GetMapping("/detail/commentDelete")
    public String commentDelete(Model model,
                                HttpSession session,
                                @RequestParam(name= "rewardCommentCode") String rewardCommentCode,
                                @RequestParam(name = "rewardProjectCode") String rewardProjectCode){

        //접속 회원 아이디
        String memberId = (String)session.getAttribute("SID");
        //프로젝트 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //댓글 리스트 조회
        List<RewardComment> rewardCommentList = rewardService.getCommentList(rewardProjectCode);

        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("memberId", memberId);
        model.addAttribute("rewardCommentList", rewardCommentList);

        rewardService.commentDelete(rewardCommentCode);

        return "redirect:/user/reward/detail/comment?rewardProjectCode=" + rewardProjectCode;
    }

    //대댓글 등록
    @PostMapping("/detail/reply")
    public String replyAdd(HttpSession session, Model model,
                           @RequestParam(name = "reply") String reply,
                           @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                           @RequestParam(name = "parentCommentCode") String parentCommentCode){


        String memberId = (String)session.getAttribute("SID");
        String memberName = (String) session.getAttribute("SNAME");



        rewardService.addReplyComment(reply, rewardProjectCode, parentCommentCode, memberId, memberName);


        return "redirect:/user/reward/detail/comment?rewardProjectCode=" + rewardProjectCode;
    }



    //리워드 상세 페이지 새소식
    @GetMapping("/detail/news")
    public String newsPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        List<NewsList> newsList = donationService.getNewsList(rewardProjectCode);

        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("newsList",newsList);

        return "user/reward/detail/news/main";
    }

    //리워드 새소식 상세 페이지
    @GetMapping("/detail/news/detail")
    public String newsDetailPage(Model model,
                                 @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                                 @RequestParam(name = "newCode") String newsCode){

        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        NewsList newsList = donationService.getDetailNews(newsCode);

        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("newsList", newsList);

        return "user/reward/detail/news/detail";
    }


    //리워드 주문 페이지
    @GetMapping("/order")
    public String orderPage(Model model, HttpSession session,
                            @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                            @RequestParam(name = "rewardOptionCode", required = false) String rewardOptionCode) {
        //로그인 한 아이디 불러오기
        String memberId = (String) session.getAttribute("SID");

        //로그인 하지 않았다면 로그인 화면으로 이동.
        if(memberId == null) {
            return "user/account/login";
        }

        //프로젝트 상세 정보 가져오기
        RewardProject rewardOrderInfo = rewardService.rewardProjectDetail(rewardProjectCode);
        //로그인 한 회원 정보 가져오기
        Member orderMemberInfo = rewardService.getOrderMemberInfo(memberId);
        //로그인 한 회원 보유 쿠폰 리스트 가져오기
        List<Coupon> memberHaveCouponList = adminCouponService.MemberHaveCouponById(memberId);
        //배송 메세지 리스트 가져오기
        List<DeliveryMessage> deliveryMessageList = rewardService.deliveryMessage();

        model.addAttribute("deliveryMessageList",deliveryMessageList);
        model.addAttribute("rewardOrderInfo", rewardOrderInfo);
        model.addAttribute("orderMemberInfo", orderMemberInfo);
        model.addAttribute("memberHaveCouponList", memberHaveCouponList);

        return "user/reward/order/main";
    }

    //리워드 결제 페이지
    @PostMapping("/payment")
    @ResponseBody
    public String paymentPage(@RequestBody PaymentResult paymentResult) throws IOException, InterruptedException {

        //결제 DB작업에 필요한 데이터 잘 받았는지 log4j로 출력
        log.info("paymentResult: {}", paymentResult);

        String payResult = "{\"paymentKey\":\""+paymentResult.getPaymentKey()+"\", "
                            +"\"orderId\":\""+paymentResult.getOrderId()+"\", "
                            +"\"amount\":\""+paymentResult.getAmount()+"\"}";

        //토스 API에 결제 완료 후, 결제에 사용된 데이터 요청.
        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
                                        .header("Authorization","Basic dGVzdF9za19EbnlScFFXR3JOV0Q5WHBMemdaZzhLd3YxTTlFOg==")
                                        .header("Content-Type","application/json")
                                        .header("Idempotency-Key","a6a498c4-6f61-4183-a2ff-80176e69a067")
                                        .method("POST", HttpRequest.BodyPublishers.ofString(payResult))
                                        .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(response.body(), Map.class);


        //주문코드, 결제코드 생성
        OrderTotal orderAndPaymentCode = rewardService.getOrderAndPaymentCode();

        //paymentResult 객체에 주문코드 할당
        String orderCode = orderAndPaymentCode.getOrderCode();
        paymentResult.setOrderCode(orderCode);

        //paymentResult 객체에 결제코드 할당
        String paymentCode = orderAndPaymentCode.getRewardPaymentCode();
        paymentResult.setPaymentCode(paymentCode);

        //프로젝트 결제 서비스 진행
        rewardService.rewardProjectPay(paymentResult);

        return "/user/reward/order/paymentConfirm";
    }

    //리워드 결제 확인 페이지
    @GetMapping("/order/paymentConfirm")
    public String paymentConfirmPage(Model model) {

        return "user/reward/order/paymentConfirm";
    }

    //리워드 환불 정책 페이지
    @GetMapping("/detail/refundPolicy")
    public String refundPolicyPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode){

        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);

        model.addAttribute("rewardProject",rewardProject);
        log.info("프로젝트 상세페이지 정보 : {}",rewardProject);

        return"user/reward/detail/refundPolicy";
    }
















}
