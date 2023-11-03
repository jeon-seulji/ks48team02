package ksmart.ks48team02.user.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mypageRefundController")
@RequestMapping("/user/mypage/refund")
public class MypageRefundController {

    @GetMapping(value={"","/"})
    public String refundMain(){

        return"user/mypage/refund/main";
    }
}
