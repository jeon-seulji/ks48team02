package ksmart.ks48team02.user.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/account")
public class AccountController {

    @GetMapping(value={"","/"})
    public String mainPage(){ // 회원가입 페이지

        return "user/account/main";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "user/account/login";
    }

    @GetMapping("/drop")
    public String dropPage(){

        return "user/account/drop";
    }


}


