package ksmart.ks48team02.user.controller.donation;

import ksmart.ks48team02.admin.dto.donation.DonationInfo;
import ksmart.ks48team02.user.service.donation.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("userDonationController")
@RequestMapping("/user/donation")
public class DonationController {
    private final DonationService donationService;
    public DonationController(DonationService donationService){
        this.donationService = donationService;
    }

    @GetMapping(value = {"", "/"})
    public String mainPage(){
        return "user/donation/main";
    }

    @GetMapping("/detail")
    public String detailMainPage(@RequestParam(name = "donationCode") String donationCode,
                                 Model model){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);

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