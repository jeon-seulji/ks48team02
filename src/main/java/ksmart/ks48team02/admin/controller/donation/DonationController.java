package ksmart.ks48team02.admin.controller.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("admimDonationController")
@RequestMapping("/admin/donation")
public class DonationController {

    @GetMapping(value = {"", "/"})
    public String mainPage(){
        return "admin/donation/products/main";
    }

    @GetMapping("/products/modify")
    public String productModifyPage(){
        return "admin/donation/products/modify";
    }

    @GetMapping("/products/search_tag_modify")
    public String searchTagModifyPage(){
        return "admin/donation/products/search_tag_modify";
    }

    @GetMapping("/judgement")
    public String judgementMainPage(Model model){
        model.addAttribute("title", "기부 심사 관리");
        model.addAttribute("contentsTitle", "기부 심사 관리");
        return "admin/donation/judgement/main";
    }

    @GetMapping("/judgement/reject")
    public String judgementRejectPage(){
        return "admin/donation/judgement/reject";
    }

    @GetMapping("/category")
    public String categoryMainPage(){
        return "admin/donation/category/main";
    }

    @GetMapping("/category/modify")
    public String categoryModifyPage(){
        return "admin/donation/category/modify";
    }

    @GetMapping("/calculate")
    public String calculateMainPage(){
        return "admin/donation/calculate/main";
    }

}
