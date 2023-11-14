package ksmart.ks48team02.user.controller.account;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.service.member.UserMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/user/account")
public class AccountController {

    private final UserMemberService userMemberService;

    public AccountController (UserMemberService userMemberService) {
        this.userMemberService = userMemberService;
    }



    //로그인 페이지
    @GetMapping("/login")
    public String login(Model model, @RequestParam(name="msg", required = false) String msg) {

        if(msg != null) model.addAttribute("msg", msg);

        return "user/account/login";
    }

    //로그인 기능
    @PostMapping("/login")
    public String login(@RequestParam(name="memberId") String memberId
            , @RequestParam(name="memberPw") String memberPw
            , HttpSession session
            , RedirectAttributes reAttr) {
        Map<String, Object> resultMap = userMemberService.checkMemberInfo(memberId, memberPw);
        boolean isChecked = (boolean) resultMap.get("isChecked");
        if(isChecked) {
            // 로그인 처리
            String memberTypeCode = (String) resultMap.get("memberTypeCode");
            String memberName = (String) resultMap.get("memberName");

            session.setAttribute("SID", memberId);
            session.setAttribute("SNAME", memberName);
            session.setAttribute("STYPECODE", memberTypeCode);

            // 로그인 처리 후에는 메인화면으로 전환
            return "redirect:/user";
        }
        reAttr.addFlashAttribute("msg", "일치하는 회원의 정보가 없습니다.");
        return "redirect:/user/account/login";
    }

    //로그아웃  기능
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user";
    }



    @GetMapping("/drop")
    public String dropPage(){

        return "user/account/drop";
    }


}


