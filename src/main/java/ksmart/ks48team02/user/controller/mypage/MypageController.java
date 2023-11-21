package ksmart.ks48team02.user.controller.mypage;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.user.service.mypage.MypageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import java.util.Map;

@Controller
@RequestMapping("/user/mypage")
@AllArgsConstructor
public class MypageController {

    private final MypageService mypageService;

    @GetMapping(value={"","/"})
    public String dropPage(Model model, HttpSession httpSession,
                           @RequestParam(name="selectFund", required = false, defaultValue = "viewAll") String selectFund){
                    String memberId = (String) httpSession.getAttribute("SID");
        List<OrderTotal> mypageOrderList = mypageService.mypageOrderList(memberId);
        model.addAttribute("mypageOrderList",mypageOrderList);
        model.addAttribute("selectFund",selectFund);
        return "user/mypage/mypage";
    }

    @GetMapping("profile")
    public String profilePage(){
        return "user/mypage/profile";
    }




}
