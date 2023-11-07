package ksmart.ks48team02.user.controller;

import ksmart.ks48team02.user.dto.donation.DonationRegistration;
import ksmart.ks48team02.user.service.donation.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/projectRegistration")
public class PojectRegistrationContoller {

    private final DonationService donationService;

    public PojectRegistrationContoller(DonationService donationService){
        this.donationService = donationService;
    }

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


    @PostMapping("/donation")
    public String donationRegistrationPage(DonationRegistration donationRegistration){
        donationService.addDonation(donationRegistration);
        return "redirect:/user/projectRegistration/donation/success";
    }
    @GetMapping("/donation/success")
    public String donationRegistrationSuccessPage(){
        return "user/projectRegistration/donation/donation_insert_success";
    }

    //기부 프로젝트 등록 폼
    @GetMapping("/donation")
    public String donationRegistrationPage(Model model) {
        return "user/projectRegistration/donation/donation_insert";
    }


}