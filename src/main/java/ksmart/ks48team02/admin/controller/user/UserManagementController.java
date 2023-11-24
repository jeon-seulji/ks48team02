package ksmart.ks48team02.admin.controller.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import ksmart.ks48team02.admin.service.user.UserManagementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminUserController")
@RequestMapping("/admin/user")
@Slf4j
@AllArgsConstructor
public class UserManagementController {
    private final UserManagementService userManagementService;
    @GetMapping("/memberList")
    public String memberListPage(Model model){
        model.addAttribute("contentsTitle", "회원 목록");

        return "admin/user/member_list";
    }




    // 로그인 로그 조회
    @PostMapping("/getLoginLog")
    @ResponseBody
    public List<UserManagement> getLoginLog(@RequestParam(name="memberId") String memberId,
                                            @RequestParam(name="startDate") String startDate,
                                            @RequestParam(name="endDate") String endDate){
        List<UserManagement> loginLogs = userManagementService.getLoginLogById(memberId, startDate, endDate);

        log.info("로그인 로그 {}", loginLogs);

        return loginLogs;
    }

    @GetMapping("/loginLog")
    public String memberLoginLog(Model model){
        // 로그인 로그에서 유저 아이디 작성하고 검색 버튼 클릭시 리스트 반환

        model.addAttribute("contentsTitle", "회원 로그인 이력");
        return "/admin/user/login_log";
    }

    @GetMapping("/memberRank")
    public String memberRankPage(Model model){
        model.addAttribute("contentsTitle", "회원 등급 관리");
        return "admin/user/member_rank";
    }


}