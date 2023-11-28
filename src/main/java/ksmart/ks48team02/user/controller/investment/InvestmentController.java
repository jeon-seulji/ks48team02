package ksmart.ks48team02.user.controller.investment;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.InvestmentContent;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import ksmart.ks48team02.user.dto.InvestmentJudge;
import ksmart.ks48team02.user.service.investment.UserInvestmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("userInvestmentController")
@RequestMapping("/user/investment")
public class InvestmentController {

    private final UserInvestmentService userInvestmentService;

    public InvestmentController(UserInvestmentService userInvestmentService) {
        this.userInvestmentService = userInvestmentService;
    }


    @GetMapping(value = {"", "/"})
    public String getMainPage(Model model) {

        List<InvestmentInfo> investmentInfo = userInvestmentService.getInvestmentInfo();
        model.addAttribute("investmentInfo", investmentInfo);

        model.addAttribute("title", "투자 메인 페이지");


        return "user/investment/main";
    }

    @PostMapping("/ajax/sortedList")
    @ResponseBody
    public List<InvestmentInfo> getSortedList(@RequestParam(name = "orderBy") String orderBy) {
        return userInvestmentService.getSortedList(orderBy);
    }


    @GetMapping("/detail/main")
    public String getDetailMainPage(Model model,
                                    @RequestParam(name = "investmentCode") String investmentCode) {

        InvestmentInfo investmentInfo = userInvestmentService.investmentProjectDetail(investmentCode);

        model.addAttribute("investmentInfo", investmentInfo);

        model.addAttribute("title", "투자 상세 페이지");


        return "user/investment/detail/main";
    }

    @GetMapping("/detail/comment")
    public String detailCommentPage(Model model) {

        model.addAttribute("title", "투자 상세 댓글");

        return "user/investment/detail/comment";
    }

    @GetMapping("/detail/investor")
    public String detailInvestorPage(Model model) {

        model.addAttribute("title", "투자 상세 투자자 목록");

        return "user/investment/detail/investor";
    }

    @GetMapping("/detail/news")
    public String detailNewsPage(Model model) {

        model.addAttribute("title", "투자 새소식");

        return "user/investment/detail/news/main";
    }

    @GetMapping("/order")
    public String orderPage(Model model, HttpSession httpSession) {

        model.addAttribute("title", "투자 주문 페이지");

        String memberId = (String) httpSession.getAttribute("SID");

        if(memberId == null) {
            return "user/account/login";
        }



        return "user/investment/order/main";
    }

    @GetMapping("/list/after-process")
    public String getAfterProcessList(Model model) {

        model.addAttribute("title", "투자 펀딩 후 진행정보 목록");
        model.addAttribute("contentsTitle","투자 펀딩 후 진행정보 목록");

        return "user/mypage/investment/list/invest_after_process_list";
    }

    @GetMapping("/list/after-fund-revenue")
    public String getAfterFundRevenueList(Model model) {

        model.addAttribute("title", "투자 후 기업 정보 공개 목록");
        model.addAttribute("contentsTitle","투자 후 기업 정보 공개 목록");

        return "user/mypage/investment/list/after_fund_revenue_list";
    }

    @GetMapping("/list/customer-invest")
    public String getCustomerInvestList(Model model) {

        model.addAttribute("title", "운영 후 투자자 손익 목록");
        model.addAttribute("contentsTitle","운영 후 투자자 손익 목록");

        return "user/mypage/investment/list/customer_invest_list";
    }

    @GetMapping("/list/after-invest-division")
    public String getAfterDivisionList(Model model) {

        model.addAttribute("title", "투자 후 분배 목록");
        model.addAttribute("contentsTitle","투자 후 분배 목록");

        return "user/mypage/investment/list/after_invest_division_list";
    }

    @GetMapping("/view/after-process")
    public String getAfterProcessView(Model model) {

        model.addAttribute("title", "투자 펀딩 후 진행정보");

        return "user/mypage/investment/view/invest_after_process_view";
    }

    @GetMapping("/view/after-fund-revenue")
    public String getAfterFundRevenueView(Model model) {

        model.addAttribute("title", "투자 후 기업 정보 공개");

        return "user/mypage/investment/view/after_fund_revenue_view";
    }

    @GetMapping("/view/customer-invest")
    public String getCustomerInvestView(Model model) {

        model.addAttribute("title", "운영 후 투자자 손익");

        return "user/mypage/investment/view/customer_invest_view";
    }

    @GetMapping("/view/after-invest-division")
    public String getAfterDivisionView(Model model) {

        model.addAttribute("title", "투자 후 분배");

        return "user/mypage/investment/view/after_invest_division_view";
    }

}