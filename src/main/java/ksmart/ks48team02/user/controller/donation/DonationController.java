package ksmart.ks48team02.user.controller.donation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userDonationController")
@RequestMapping("/user/donation")
public class DonationController {

    @GetMapping(value = {"", "/"})
    public String mainPage(){
        return "user/donation/main";
    }

    @GetMapping("/detail")
    public String detailMainPage(){
        return "user/donation/detail/main";
    }

    @GetMapping("/detail/condition")
    public String detailConditionPage(){
        return "user/donation/detail/condition";
    }

    @GetMapping("/detail/comment")
    public String detailCommentPage(){
        return "user/donation/detail/comment";
    }

    @GetMapping("/order")
    public String orderMainPage(){
        return "user/donation/order/main";
    }

    @GetMapping("/payment")
    public String paymentMainPage(){
        return "user/donation/payment/main";
    }

    @GetMapping("/payment/confirm")
    public String paymentConfirmPage(){
        return "user/donation/payment/confirm";
    }

    @GetMapping("/detail/news")
    public String newsPage(){
        return "user/donation/detail/news/main";
    }

    @GetMapping("/detail/news/newsDetail")
    public String newsDetailPage(){
        return "user/donation/detail/news/news_detail";
    }

    // test용 경로 매핑
    @GetMapping("/test")
    public String paymentConfirmtestPage(){
        return "user/donation/index";
    }


}