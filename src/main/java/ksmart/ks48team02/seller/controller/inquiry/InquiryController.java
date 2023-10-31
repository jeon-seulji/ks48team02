package ksmart.ks48team02.seller.controller.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerInquiryController")
@RequestMapping("/seller/inquriy")
public class InquiryController {

    @GetMapping(value = {"","/"})
    public String inquiryMainPage(){
        
        return "seller/inquiry/main";
    }
}
