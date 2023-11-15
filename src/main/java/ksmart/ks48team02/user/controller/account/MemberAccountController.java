package ksmart.ks48team02.user.controller.account;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/account")
public class MemberAccountController {

    private final AccountService accountService;

    public MemberAccountController(AccountService accountService){
        this.accountService = accountService;
    }

    // 회원가입 메인 페이지
    @GetMapping(value={"","/"})
    public String joinPage() {

        return "user/account/main";
    }

    // 회원 가입 처리 후 이동
    @PostMapping(value="/join")
    public String joinMember(Member member){
        accountService.addMember(member);

        return "user/account/join";
    }

    // 회원 가입 처리 후가 아니면 메인 페이지로
    @GetMapping("/join")
    public String viewJoinPage(){
        return "user/account/main";
    }


    // 아이디 중복체크
    @PostMapping(value="/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestParam(name="memberId") String memberId ) {
        boolean duplicationStatus = accountService.idCheck(memberId);

        return duplicationStatus;
    }

    // 회원 탈퇴 페이지
    @GetMapping("/drop")
    public String dropPage(HttpSession session, Model model){
        String loginId =  (String) session.getAttribute("SID");
        model.addAttribute("loginId", loginId);

        if(loginId == null) return "user/account/main"; else return "user/account/drop";
    }

    // 회원 탈퇴 전 비밀번호 일치 확인
    @PostMapping( "/pwCheck")
    @ResponseBody
    public boolean pwCheck(@RequestParam(name="memberPw") String memberPw
                          ,HttpSession session
                          ,Model model){
        String loginId = (String) session.getAttribute("SID");


        boolean comparePwResult = accountService.pwCheck(loginId, memberPw);

        return comparePwResult;
    }
    @PostMapping("/inactivate")
    public String inactivate(HttpSession session, Model model){
        String loginId = (String) session.getAttribute("SID");
        model.addAttribute("loginId",loginId);
        accountService.inactivateMember(loginId);

        return "user/account/inactivate";
    }




}
