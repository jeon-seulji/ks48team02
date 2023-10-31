package ksmart.ks48team02.seller.controller.reward;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/reward")
public class RewardController {

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

        return "user/reward/detail/news";
    }

    //리워드 상세 페이지 환불 정책
    @GetMapping("/detail/refundPolicy")
    public String refundPolicy(Model mode){

        return "user/reward/detail/refundPolicy";
    }

    //리워드 주문 페이지
    @GetMapping("/order")
    public String orderPage(Model model) {

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















}
