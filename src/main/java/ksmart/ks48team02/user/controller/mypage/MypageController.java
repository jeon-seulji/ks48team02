package ksmart.ks48team02.user.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {

    @GetMapping(value={"","/"})
    public String dropPage(){

        return "user/mypage/mypage";
    }

    @GetMapping("profile")
    public String profilePage(){
        return "user/mypage/profile";
    }



}
