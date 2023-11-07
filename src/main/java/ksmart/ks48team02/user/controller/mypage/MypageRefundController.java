package ksmart.ks48team02.user.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mypageRefundController")
@RequestMapping("/user/mypage/refund")
public class MypageRefundController {

    //환불 페이지
    @GetMapping(value={"","/"})
    public String refundMainPage(){

        return"user/mypage/refund/main";
    }

    //취소 페이지
    @GetMapping("cancel")
    public String cancelMainPage(){

        return"user/mypage/cancel/main";
    }
}
