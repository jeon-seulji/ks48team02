package ksmart.ks48team02.user.controller.storePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("storePageController")
@RequestMapping("/user/storePage")
public class StorePageController {
    @GetMapping(value = {"","/"})
    public String storePage(){
        return "/user/storePage/main";
    }

    @GetMapping(value = {"/main"})
    public String mainPage(){
        return "/user/storePage/store_page";
    }

    @GetMapping(value = {"/ajax"})
    @ResponseBody
    public String storeePage(){
        return "tab1";
    }


}
