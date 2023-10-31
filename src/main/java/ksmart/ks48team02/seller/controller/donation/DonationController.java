package ksmart.ks48team02.seller.controller.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerDonationController")
@RequestMapping("/seller/donation")
public class DonationController {

    @GetMapping("/products")
    public String mainPage(Model model){
        model.addAttribute("title","판매자 : 기부 프로젝트 목록");
        model.addAttribute("contentsTitle","기부 프로젝트 목록");
        return "seller/donation/products/main";
    }

    @GetMapping("/products/searchTagModify")
    public String searchTagModifyPage(Model model){
        model.addAttribute("title","판매자 : 기부 태그 관리");
        model.addAttribute("contentsTitle","기부 태그 관리");
        return "seller/donation/products/search_tag_modify";
    }

    @GetMapping("/projectRegistration")
    public String projectRegistrationPage(){
        return "seller/donation/projectRegistration/donation_insert";
    }

/*    @GetMapping("/orderManagement")
    public String orderManagementMainPage(){
        return "seller/donation/orderManagement/main";
    }*/

    @GetMapping("/condition")
    public String conditionMainPage(Model model){
        model.addAttribute("title","판매자 : 기부 진행현황 관리");
        model.addAttribute("contentsTitle","기부 진행현황 관리");
        return "seller/donation/condition/main";
    }

    @GetMapping("/condition/add")
    public String conditionAddPage(){
        return "seller/donation/condition/add";
    }

    @GetMapping("/condition/modify")
    public String conditionModifyPage(){
        return "seller/donation/condition/modify";
    }

    @GetMapping("/calculate")
    public String calculateMainPage(){
        return "seller/donation/calculate/main";
    }

    @GetMapping("/comments")
    public String commentsManagementPage(Model model){
        model.addAttribute("title","판매자 : 기부 댓글 관리");
        model.addAttribute("contentsTitle","기부 댓글 관리");
        return "seller/donation/comments/main";
    }



}
