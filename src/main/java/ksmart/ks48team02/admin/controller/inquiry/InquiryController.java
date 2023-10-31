package ksmart.ks48team02.admin.controller.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminInquiryController")
@RequestMapping("/admin/inquiry")
public class InquiryController {

    // 1:1 문의 관리
    @GetMapping("/main")
    public String inquiryMainPage(){

        return "admin/inquiry/main";
    }
    // 1:1 문의 관리 수정페이지
    @GetMapping("/inquiryModify1")
    public String inquiryModi1Page(){

        return "admin/inquiry/inquiryModify1";
    }

    // 신고 관리
    @GetMapping("/report")
    public String reportMainPage(){

        return "admin/inquiry/report";
    }

    // 신고하기 관리 수정페이지
    @GetMapping("/reportModify1")
    public String reportModi1Page(){

        return "admin/inquiry/reportModify1";
    }
}
