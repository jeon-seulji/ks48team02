package ksmart.ks48team02.user.controller.storePage;

import ksmart.ks48team02.user.dto.StorePageDto;
import ksmart.ks48team02.user.service.storePage.StorePageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller("storePageController")
@RequestMapping("/user/storePage")
public class StorePageController {

    private final StorePageService storePageService;

    public StorePageController(StorePageService storePageServiceImpl){
        this.storePageService = storePageServiceImpl;
    }

    @GetMapping(value = {"","/"})
    public String storePage(Model model){
        List<StorePageDto> storeNewsList = storePageService.storePageNewsList();
        model.addAttribute("newsList", storeNewsList);

        return "user/storePage/main";
    }

}
