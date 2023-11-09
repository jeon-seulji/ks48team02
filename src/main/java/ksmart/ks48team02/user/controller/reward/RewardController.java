package ksmart.ks48team02.user.controller.reward;


import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.coupon.Coupon;
import ksmart.ks48team02.admin.service.coupon.AdminCouponService;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.service.reward.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("userRewardController")
@RequestMapping("/user/reward")
public class RewardController {

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

        return "user/reward/main";
    }

    //리워드 상세 페이지
    @GetMapping("/detail")
    public String detailPage(Model model) {

        return "user/reward/detail/main";
    }

    //리워드 상세 페이지 댓글
    @GetMapping("/detail/comment")
    public String commentPage(Model model) {

        return "user/reward/detail/comment";
    }

    //리워드 상세 페이지 새소식
    @GetMapping("/detail/news")
    public String newsPage(Model model) {

        return "user/reward/detail/news/main";
    }

    //리워드 새소식 상세 페이지
    @GetMapping("/detail/news/detail")
    public String newsDetailPage(){

        return "user/reward/detail/news/detail";
    }


    //리워드 주문 페이지
    @GetMapping("/order")
    public String orderPage(Model model, HttpSession session) {

        String memberId = (String) session.getAttribute("SID");
        Member orderMemberInfo = rewardService.getOrderMemberInfo(memberId);
        List<Coupon> memberHaveCouponList = adminCouponService.MemberHaveCouponById(memberId);


        model.addAttribute("orderMemberInfo", orderMemberInfo);
        model.addAttribute("memberHaveCouponList",memberHaveCouponList);

        return "user/reward/order/main";
    }

    //리워드 결제 페이지
    @GetMapping("/payment")
    public String paymentPage(Model model) {

        return "user/reward/payment/main";
    }

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
