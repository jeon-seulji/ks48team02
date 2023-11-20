package ksmart.ks48team02.user.controller.mypage;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.service.mypage.MypageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {

    final MypageService mypageService;

    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping(value={"","/"})
    public String myPage(HttpSession session, Model model){
    String loginId = (String) session.getAttribute("SID");

     Map<String, Object> resultMap = mypageService.getMemberInfoById(loginId);
     String memberEmail = (String) resultMap.get("memberEmail");
     String memberContactInfo = (String) resultMap.get("memberContactInfo");
        model.addAttribute("memberEmail", memberEmail);
        model.addAttribute("memberContactInfo", memberContactInfo);
        return "user/mypage/mypage";
    }

    @GetMapping("profile")
    public String profilePage(){
        return "user/mypage/profile";
    }




}
