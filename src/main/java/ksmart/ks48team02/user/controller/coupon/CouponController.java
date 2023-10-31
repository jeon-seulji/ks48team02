package ksmart.ks48team02.user.controller.coupon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userCouponController")
@RequestMapping("/user/coupon")
public class CouponController {

    @GetMapping(value = {"","/"})
    public String userCouponMainPage(){

        return "user/coupon/main";
    }
}
