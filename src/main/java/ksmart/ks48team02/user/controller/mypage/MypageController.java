package ksmart.ks48team02.user.controller.mypage;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.service.account.AccountService;
import ksmart.ks48team02.user.service.mypage.MypageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {
    private static final Logger Log = LoggerFactory.getLogger(MypageService.class);

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

    @GetMapping("/profile")
    public String profilePage(){
        return "user/mypage/profile";
    }

    @PostMapping("/pwCheck")
    @ResponseBody
    public boolean pwCheck(@RequestParam(name="memberPw") String memberPw, HttpSession session){
        String loginId = (String) session.getAttribute("SID");

        return mypageService.pwCheck(loginId, memberPw);
    }

    @PostMapping("/pwModify")
    @ResponseBody
    public Map<String, Object> pwModify(@RequestParam(name="memberPw") String memberPw, HttpSession session){
        String loginId = (String) session.getAttribute("SID");
        int result = mypageService.pwModify(loginId, memberPw);
        Log.info("비밀번호 업데이트 결과 {}", result); // 1

        Map<String, Object> modifyResponse = new HashMap<>();
        modifyResponse.put("result", result);

        return modifyResponse;
    }

    /*============================================================================================*/


}
