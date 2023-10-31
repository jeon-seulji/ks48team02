package ksmart.ks48team02.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/projectRegistration")
public class PojectRegistrationContoller {

    //프로젝트 등록 메인 페이지
    @GetMapping(value = {"" , "/"})
    public String mainPage(Model model) {

        return "user/projectRegistration/main";
    }

    //리워드 프로젝트 등록 페이지
    @GetMapping(value = {"/reward"})
    public String rewardRegistrationPage(Model model) {

        return "user/projectRegistration/reward/reward_insert";
    }
    //투자 프로젝트 등록 페이지

    //기부 프로젝트 등록 페이지
    @GetMapping(value = {"/donation"})
    public String donationRegistrationPage(Model model) {

        return "user/projectRegistration/donation/donation_insert";
    }


}