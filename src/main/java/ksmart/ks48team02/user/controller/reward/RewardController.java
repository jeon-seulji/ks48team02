package ksmart.ks48team02.user.controller.reward;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.service.coupon.AdminCouponService;
import ksmart.ks48team02.common.dto.DeliveryMessage;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.user.controller.PojectRegistrationContoller;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.service.reward.RewardService;
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
public class RewardController {

    private static final Logger log = LoggerFactory.getLogger(PojectRegistrationContoller.class);
    private static final Logger Log = LoggerFactory.getLogger(RewardController.class);
    private final RewardService rewardService;
    private final AdminCouponService adminCouponService;

    public RewardController (RewardService rewardService, AdminCouponService adminCouponService){
        this.adminCouponService = adminCouponService;
        this.rewardService = rewardService;
    }

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
    public String commentPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        return "user/reward/detail/comment";
    }

    //리워드 상세 페이지 새소식
    @GetMapping("/detail/news")
    public String newsPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        return "user/reward/detail/news/main";
    }

    //리워드 새소식 상세 페이지
    @GetMapping("/detail/news/detail")
    public String newsDetailPage(){

        return "user/reward/detail/news/detail";
    }


    //리워드 주문 페이지
    @GetMapping("/order")
    public String orderPage(Model model, HttpSession session,
                            @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                            @RequestParam(name = "rewardOptionCode", required = false) String rewardOptionCode) {

        String memberId = (String) session.getAttribute("SID");

        if(memberId == null) {
            return "user/account/login";
        }


        RewardProject rewardOrderInfo = rewardService.rewardProjectDetail(rewardProjectCode);
        Member orderMemberInfo = rewardService.getOrderMemberInfo(memberId);
        List<Coupon> memberHaveCouponList = adminCouponService.MemberHaveCouponById(memberId);
        List<DeliveryMessage> deliveryMessageList = rewardService.deliveryMessage();

        model.addAttribute("deliveryMessageList",deliveryMessageList);
        model.addAttribute("rewardOrderInfo", rewardOrderInfo);
        model.addAttribute("rewardOptionCode", rewardOptionCode);
        model.addAttribute("orderMemberInfo", orderMemberInfo);
        model.addAttribute("memberHaveCouponList", memberHaveCouponList);

        return "user/reward/order/main";
    }

    //리워드 결제 페이지
    @PostMapping("/payment")
    @ResponseBody
    public String paymentPage(@RequestBody PaymentResult paymentResult) throws IOException, InterruptedException {

        log.info("paymentResult: {}", paymentResult);

        String payResult = "{\"paymentKey\":\""+paymentResult.getPaymentKey()+"\", "
                            +"\"orderId\":\""+paymentResult.getOrderId()+"\", "
                            +"\"amount\":\""+paymentResult.getAmount()+"\"}";

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

        //프로젝트 등록 service
        rewardService.rewardProjectPay(paymentResult);

        return "/user";
    }

//    @PostMapping("/payment")
//    @ResponseBody
//    public String paymentPage(){
//
//    }

    //리워드 결제 확인 페이지
    @GetMapping("/payment/confirm")
    public String paymentConfirmPage(Model model) {

        return "user/reward/payment/confirm";
    }

    //리워드 환불 정책 페이지
    @GetMapping("/detail/refundPolicy")
    public String refundPolicyPage(){

        return"user/reward/detail/refundPolicy";
    }
















}
