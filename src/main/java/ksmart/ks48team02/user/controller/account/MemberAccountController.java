package ksmart.ks48team02.user.controller.account;

import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // 회원 가입 처리
    @PostMapping(value="/join")
    public String joinMember(Member member){
        accountService.addMember(member);

        return "redirect:/user/account/join";
    }

    // 아이디 중복체크
    @PostMapping(value="/idCheck")
    public boolean idCheck(@RequestParam(name="memberId") String memberId ) {
        boolean duplicationStatus = accountService.idCheck(memberId);

        return duplicationStatus;
    }


}
