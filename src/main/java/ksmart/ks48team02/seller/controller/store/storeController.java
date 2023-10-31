package ksmart.ks48team02.seller.controller.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("sellerStoreController")
@RequestMapping("/seller/store")
public class storeController {

    //소속된 스토어 정보 조회 페이지(스토어 정보, 등록된 직원 목록...)
    @GetMapping(value = {"", "/"})
    public String storePage(Model model) {

        return "seller/store/main";
    }
    //대표자 스토어 등록 페이지
    @GetMapping(value = "/register")
    public String storeRegisterPage(Model model) {

        return "seller/store/register";
    }
    //대표자 직원 등록 페이지
    @GetMapping(value = "/staffAdd")
    public String staffAddPage(Model model) {

        return "seller/store/staff_add";
    }

}
