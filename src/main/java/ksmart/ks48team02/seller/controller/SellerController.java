package ksmart.ks48team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerMainController")
@RequestMapping("/seller")
public class SellerController {
    @GetMapping(value = {"", "/"})
    public String sellerMainPage(Model model){

        return "seller/index";
    }

}
