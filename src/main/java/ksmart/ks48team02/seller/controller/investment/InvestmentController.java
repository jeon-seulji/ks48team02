package ksmart.ks48team02.seller.controller.investment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerInvestmentController")
@RequestMapping("/seller/investment")
public class InvestmentController {

    @GetMapping("/invest-main")
    public String getInvestMain(Model model) {

        model.addAttribute("title", "투자 프로젝트 목록");
        model.addAttribute("contentsTitle","투자 프로젝트 목록");

        return "seller/investment/invest_main";
    }

    @GetMapping("/search/judge")
    public String getInvestmentJudgeList(Model model) {

        model.addAttribute("title", "투자펀딩 심사 요청 목록");
        model.addAttribute("contentsTitle","투자펀딩 심사 요청 목록");

        return "seller/investment/list/invest_judge_list";
    }

    @GetMapping("/search/after-process")
    public String getInvestAfterProcessList(Model model) {

        model.addAttribute("title", "투자 펀딩후 진행정보 목록");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보 목록");

        return "seller/investment/list/invest_after_process_list";
    }

    @GetMapping("/search/after-fund-revenue")
    public String getAfterFundRevenueList(Model model) {

        model.addAttribute("title", "투자후 기업정보 공개 목록");
        model.addAttribute("contentsTitle","투자후 기업정보 공개 목록");

        return "seller/investment/list/after_fund_revenue_list";
    }

    @GetMapping("/search/customer-invest")
    public String getCustomerInvestList(Model model) {

        model.addAttribute("title", "운영후 투자자 손익 목록");
        model.addAttribute("contentsTitle", "운영후 투자자 손익 목록");

        return "seller/investment/list/customer_invest_list";
    }

    @GetMapping("/search/after-invest-division")
    public String getAfterInvestDivisionList(Model model) {

        model.addAttribute("title", "투자 후 분배 목록");
        model.addAttribute("contentsTitle", "투자 후 분배 목록");

        return "seller/investment/list/after_invest_division_list";
    }

    @GetMapping("/view/judge")
    public String getInvestmentJudge(Model model) {

        model.addAttribute("title", "투자펀딩 심사 요청");
        model.addAttribute("contentsTitle","투자펀딩 심사 요청");

        return "seller/investment/view/invest_judge_view";
    }

    @GetMapping("/view/after-process")
    public String getInvestAfterProcess(Model model) {

        model.addAttribute("title", "투자 펀딩후 진행정보");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보");

        return "seller/investment/view/invest_after_process_view";
    }

    @GetMapping("/view/after-fund-revenue")
    public String getAfterFundRevenue(Model model) {

        model.addAttribute("title", "투자후 기업정보 공개");
        model.addAttribute("contentsTitle","투자후 기업정보 공개");

        return "seller/investment/view/after_fund_revenue_view";
    }

    @GetMapping("/view/customer-invest")
    public String getCustomerInvest(Model model) {

        model.addAttribute("title", "운영후 투자자 손익");
        model.addAttribute("contentsTitle","운영후 투자자 손익");

        return "seller/investment/view/customer_invest_view";
    }

    @GetMapping("/view/after-invest-division")
    public String getAfterInvestDivision(Model model) {

        model.addAttribute("title", "투자 후 분배");
        model.addAttribute("contentsTitle", "투자 후 분배");

        return "seller/investment/view/after_invest_division_view";
    }


    @GetMapping("/insert/after-process")
    public String addInvestAfterProcess(Model model) {

        model.addAttribute("title", "투자 펀딩후 진행정보 등록");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보 등록");

        return "seller/investment/insert/invest_after_process_insert";
    }

    @GetMapping("/insert/after-fund-revenue")
    public String addAfterFundRevenue(Model model) {

        model.addAttribute("title", "투자후 기업정보 공개 등록");
        model.addAttribute("contentsTitle","투자후 기업정보 공개 등록");

        return "seller/investment/insert/after_fund_revenue_insert";
    }

    @GetMapping("/insert/customer-invest")
    public String addCustomerInvest(Model model) {

        model.addAttribute("title", "운영후 투자자 손익 등록");
        model.addAttribute("contentsTitle","운영후 투자자 손익 등록");

        return "seller/investment/insert/customer_invest_insert";
    }

    @GetMapping("/insert/after-invest-division")
    public  String addAfterInvestDivision(Model model) {

        model.addAttribute("title", "투자후 분배 등록");
        model.addAttribute("contentsTitle","투자후 분배 등록");

        return "seller/investment/insert/after_invest_division_insert";
    }

    @GetMapping("/update/update")
    public String modifyInvestment(Model model) {

        model.addAttribute("title", "투자펀딩 공고 수정");
        model.addAttribute("contentsTitle","투자펀딩 공고 수정");

        return "seller/investment/update/invest_update";
    }

    @GetMapping("/update/judge")
    public String modifyInvestmentJudge(Model model) {

        model.addAttribute("title", "투자펀딩 심사 요청 수정");
        model.addAttribute("contentsTitle","투자펀딩 심사 요청 수정");

        return "seller/investment/update/invest_judge_update";
    }

    @GetMapping("/update/after-process")
    public String modifyInvestAfterProcess(Model model) {

        model.addAttribute("title", "투자 펀딩후 진행정보 수정");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보 수정");

        return "seller/investment/update/invest_after_process_update";
    }

    @GetMapping("/update/after-fund-revenue")
    public String modifyAfterFundRevenue(Model model) {

        model.addAttribute("title", "투자후 기업정보 공개 수정");
        model.addAttribute("contentsTitle","투자후 기업정보 공개 수정");

        return "seller/investment/update/after_fund_revenue_update";
    }

    @GetMapping("/update/customer-invest")
    public String modifyCustomerInvest(Model model) {

        model.addAttribute("title", "운영후 투자자 손익 수정");
        model.addAttribute("contentsTitle","운영후 투자자 손익 수정");

        return "seller/investment/update/customer_invest_update";
    }

    @GetMapping("/update/after-invest-division")
    public String modifyAfterInvestDivision(Model model) {

        model.addAttribute("title", "투자후 분배 수정");
        model.addAttribute("contentsTitle","투자후 분배 수정");

        return "seller/investment/update/after_invest_division_update";
    }

    @GetMapping("/news")
    public String getInvestNews(Model model) {

        model.addAttribute("title", "투자 새소식");
        model.addAttribute("contentsTitle", "투자 새소식");

        return "seller/investment/news/main";
    }

    @GetMapping("/comment")
    public String getInvestComment(Model model) {

        model.addAttribute("title", "투자 댓글관리");
        model.addAttribute("contentsTitle", "투자 댓글관리");

        return "seller/investment/comment/main";
    }

}
