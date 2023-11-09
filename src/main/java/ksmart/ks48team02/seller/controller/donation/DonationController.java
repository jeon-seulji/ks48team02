package ksmart.ks48team02.seller.controller.donation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import ksmart.ks48team02.admin.dto.donation.Donation;
import ksmart.ks48team02.seller.dto.donation.DonationList;
import ksmart.ks48team02.seller.service.donation.SellerDonationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("sellerDonationController")
@RequestMapping("/seller/donation")
@AllArgsConstructor
public class DonationController {
    SellerDonationService sellerDonationService;

    @GetMapping("/products")
    public String mainPage(Model model,
                           HttpServletRequest request,
                           @RequestParam(name = "donationCode", required = false) String donationCode){
        HttpSession session = request.getSession();
        model.addAttribute("title","판매자 : 기부 프로젝트 목록");
        model.addAttribute("contentsTitle","기부 프로젝트 목록");
        String memberId = (String) session.getAttribute("SID");
        List<DonationList> donationList = sellerDonationService.getDonationProjectList(memberId);
        model.addAttribute("donationList", donationList);

        if(donationCode != null){
            sellerDonationService.startProject(donationCode);
            return "redirect:/seller/donation/products";
        }

        return "seller/donation/products/main";
    }

    @GetMapping("/products/searchTagModify")
    public String searchTagModifyPage(Model model){
        model.addAttribute("title","판매자 : 기부 태그 관리");
        model.addAttribute("contentsTitle","기부 태그 관리");
        return "seller/donation/products/search_tag_modify";
    }

    @GetMapping("/products/modify")
    public String productModifyPage(){
        return "seller/donation/products/modify";
    }

    @GetMapping("/projectRegistration")
    public String projectRegistrationPage(){
        return "seller/donation/projectRegistration/donation_insert";
    }

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

    @GetMapping("/news")
    public String newsManagementPage(Model model){
        model.addAttribute("title","판매자 : 새소식 관리");
        model.addAttribute("contentsTitle","새소식 관리");
        return "seller/donation/news/main";
    }

    @GetMapping("/news/add")
    public String newsAddPage(){
        return "seller/donation/news/add";
    }

    @GetMapping("/news/modify")
    public String newsModifyPage(){
        return "seller/donation/news/modify";
    }




}
