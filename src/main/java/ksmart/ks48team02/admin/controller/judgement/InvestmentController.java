package ksmart.ks48team02.admin.controller.judgement;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.ks48team02.admin.dto.investment.AdminLawSatistifyReason;
import ksmart.ks48team02.admin.service.investment.InvestmentService;
import ksmart.ks48team02.admin.dto.investment.AdminIncongruitySectors;
import ksmart.ks48team02.admin.dto.investment.AdminCorporateValueEvaluation;
import ksmart.ks48team02.admin.dto.investment.AdminInvestmentRequestJudge;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("judgementInvestmentController")
@RequestMapping("/admin/investment")
public class InvestmentController {

    // DI(의존성 주입)
    private final InvestmentService investmentService;

    //생성자메소드를 통한 DI
    public InvestmentController(InvestmentService investmentService){

        this.investmentService = investmentService;
    }

    @GetMapping("/judge-main")
    public String getInvestJudgeMain(Model model){

        model.addAttribute("title", "투자 심사 관리");
        model.addAttribute("contentsTitle","투자 심사 관리");


        return "admin/judgement/investment/invest_judge_main";
    }

    @GetMapping("/search/judge")
    public String getInvestmentJudgeList(Model model
                                        ,@RequestParam(name = "searchKey", required = false) String searchKey
                                        ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                        ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                        ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate) {

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = null;
        if(searchKey != null) {
            investmentRequestJudgeList = investmentService.getInvestmentRequestJudgeList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);
        }else {
            investmentRequestJudgeList = investmentService.getInvestmentRequestJudgeList();
        }

        model.addAttribute("title", "관리자 : 투자 펀딩 심사 요청");
        model.addAttribute("contentsTitle","투자 펀딩 심사 요청");
        model.addAttribute("contentsSubTitle","투자 펀딩 심사 요청을 관리합니다");
        model.addAttribute("investmentRequestJudgeList", investmentRequestJudgeList);

        return "admin/judgement/investment/list/invest_jduge_list";
    }

    @GetMapping("/search/law-satistify")
    public String getLawSatistifyList(Model model
                                     ,@RequestParam(name = "searchKey", required = false) String searchKey
                                     ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String  searchValue
                                     ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                     ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate){

        List<AdminLawSatistifyReason> lawSatistifyReasonList = null;
        if(searchKey != null) {
            lawSatistifyReasonList = investmentService.getLawSatistifyList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);
        }else {
            lawSatistifyReasonList = investmentService.getLawSatistifyList();
        }

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준");
        model.addAttribute("contentsSubTitle","자본시장법 범위충족기준을 관리합니다");
        model.addAttribute("lawSatistifyReasonList", lawSatistifyReasonList);

        return "admin/judgement/investment/list/law_satistify_list";
    }

    @GetMapping("/search/incongruity-sectors")
    public String getIncongruitySectorsList(Model model
                                           ,@RequestParam(name = "searchKey", required = false) String searchKey
                                           ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String  searchValue
                                           ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                           ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate){

        List<AdminIncongruitySectors> incongruitySectorsList = null;
        if(searchKey != null) {
            incongruitySectorsList = investmentService.getIncogruitySectorsList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);
        }else {
            incongruitySectorsList = investmentService.getIncogruitySectorsList();
        }

        model.addAttribute("title", "관리자 : 부적합 업종");
        model.addAttribute("contentsTitle","부적합 업종");
        model.addAttribute("contentsSubTitle","부적합 업종을 관리합니다");
        model.addAttribute("incongruitySectorsList", incongruitySectorsList);

        return "admin/judgement/investment/list/incongruity_sectors_list";
    }

    @GetMapping("/search/corporate-value")
    public String getCorporateValueEvaluationList(Model model
                                                 ,@RequestParam(name = "searchKey", required = false) String searchKey
                                                 ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String  searchValue
                                                 ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                                 ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate){

        List<AdminCorporateValueEvaluation> corporateValueEvaluationList = null;
        if(searchKey != null) {
            corporateValueEvaluationList = investmentService.getCorporateValueEvaluationList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);
        }else {
            corporateValueEvaluationList = investmentService.getCorporateValueEvaluationList();
        }

        model.addAttribute("title", "관리자 : 기업가치 평가");
        model.addAttribute("contentsTitle","기업가치 평가");
        model.addAttribute("contentsSubTitle","기업가치 평가를 관리합니다");
        model.addAttribute("corporateValueEvaluationList", corporateValueEvaluationList);

        return "admin/judgement/investment/list/corporate_value_evaluation_list";
    }
    @GetMapping("/view/judge")
    public String getInvestmentJudge(@RequestParam(name = "investmentRequestJudgeCode") String investmentRequestJudgeCode,Model model){

        AdminInvestmentRequestJudge investmentRequestJudgeInfo = investmentService.getInvestmentRequestJudgeByCode(investmentRequestJudgeCode);

        model.addAttribute("title", "관리자 : 투자 펀딩 심사 요청 상세");
        model.addAttribute("contentsTitle","투자 펀딩 심사 요청 상세");
        model.addAttribute("contentsSubTitle","투자 펀딩 심사 요청 상세 내용을 확인 및 관리합니다");
        model.addAttribute("investmentRequestJudgeInfo", investmentRequestJudgeInfo);

        return "admin/judgement/investment/view/invest_jduge_view";
    }

    @GetMapping("/view/law-satistify")
    public String getLawSatistify(@RequestParam(name = "lawSatistifyCode") String lawSatistifyCode, Model model){

        AdminLawSatistifyReason lawSatistifyInfo = investmentService.getLawSatistifyByCode(lawSatistifyCode);

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 상세");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준 상세");
        model.addAttribute("contentsSubTitle","자본시장법 범위충족기준 상세 내용을 확인 및 관리합니다");
        model.addAttribute("lawSatistifyInfo", lawSatistifyInfo);

        return "admin/judgement/investment/view/law_satistify_view";
    }

    @GetMapping("/view/incongruity-sectors")
    public String getIncongruitySectors(@RequestParam(name = "incongruitySectorsCode") String incongruitySectorsCode, Model model){

        AdminIncongruitySectors incongruitySectorsInfo = investmentService.getIncogruitySectorsByCode(incongruitySectorsCode);

        model.addAttribute("title", "관리자 : 부적합 업종 상세");
        model.addAttribute("contentsTitle","부적합 업종 상세");
        model.addAttribute("contentsSubTitle","부적합 업종 상세 내용을 확인 및 관리합니다");
        model.addAttribute("incongruitySectorsInfo", incongruitySectorsInfo);

        return "admin/judgement/investment/view/incongruity_sectors_view";
    }

    @GetMapping("/view/corporate-value")
    public String getCorporateValueEvaluation(@RequestParam(name = "corporateValueEvaluationCode")String corporateValueEvaluationCode, Model model){

        AdminCorporateValueEvaluation corporateValueEvaluationInfo = investmentService.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 상세");
        model.addAttribute("contentsTitle","기업가치 평가 결과 상세");
        model.addAttribute("contentsSubTitle","기업가치 평가 결과 상세 내용을 확인 및 관리합니다");
        model.addAttribute("corporateValueEvaluationInfo", corporateValueEvaluationInfo);

        return "admin/judgement/investment/view/corporate_value_evaluation_view";
    }

    @GetMapping("/insert/law-satistify")
    public String addLawSatistify(Model model) {

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 등록");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준 등록");

        return "admin/judgement/investment/insert/law_satistify_insert";
    }

    @PostMapping("/insert/law-satistify")
    public String addLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {

        investmentService.addLawSatistify(adminLawSatistifyReason);
        return "redirect:/admin/investment/search/law-satistify";
    }

    @GetMapping("/insert/incongruity-sectors")
    public String addIncongruitySectors(Model model){

        model.addAttribute("title", "관리자 : 부적합 업종 등록");
        model.addAttribute("contentsTitle","부적합 업종 등록");

        return "admin/judgement/investment/insert/incongruity_sectors_insert";
    }

    @GetMapping("/insert/corporate-value")
    public String addCorporateValueEvaluation(Model model){

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 등록");
        model.addAttribute("contentsTitle","기업가치 평가 결과 등록");

        return "admin/judgement/investment/insert/corporate_value_evaluation_insert";
    }

    @GetMapping("/update/judge")
    public String modifyInvestmentJudge(Model model){

        model.addAttribute("title", "관리자 : 투자펀딩 심사요청 수정");
        model.addAttribute("contentsTitle","투자펀딩 심사요청 수정");

        return "admin/judgement/investment/update/invest_jduge_update";
    }

    @GetMapping("/update/law-satistify")
    public String modifyLawSatistify(@RequestParam(name = "lawSatistifyCode") String lawSatistifyCode, Model model){

        AdminLawSatistifyReason lawSatistifyInfo = investmentService.getLawSatistifyByCode(lawSatistifyCode);

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 수정");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준 수정");
        model.addAttribute("lawSatistifyInfo", lawSatistifyInfo);

        return "admin/judgement/investment/update/law_satistify_update";
    }

    @PostMapping("/update/law-satistify")
    public String modifyLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {

        investmentService.modifyLawSatistify(adminLawSatistifyReason);
        return "redirect:/admin/investment/search/law-satistify";
    }

    @GetMapping("/update/incongruity-sectors")
    public String modifyIncongruitySectors(@RequestParam(name = "incongruitySectorsCode") String incongruitySectorsCode ,Model model){

        AdminIncongruitySectors incongruitySectorsInfo = investmentService.getIncogruitySectorsByCode(incongruitySectorsCode);

        model.addAttribute("title", "관리자 : 부적합 업종 수정");
        model.addAttribute("contentsTitle","부적합 업종 수정");
        model.addAttribute("incongruitySectorsInfo", incongruitySectorsInfo);

        return "admin/judgement/investment/update/incongruity_sectors_update";
    }

    @PostMapping("/update/incongruity-sectors")
    public String modifyIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors) {

        investmentService.modifyIncongruitySectors(adminIncongruitySectors);
        return "redirect:/admin/investment/search/incongruity-sectors";
    }

    @GetMapping("/update/corporate-value")
    public String modifyCorporateValueEvaluation(Model model) {

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 수정");
        model.addAttribute("contentsTitle","기업가치 평가 결과 수정");

        return "admin/judgement/investment/update/corporate_value_evaluation_update";
    }

    @GetMapping("delete/judge")
    public String reomveInvestmentJudge(Model model) {

        model.addAttribute("title", "관리자 : 투자펀딩 심사요청 삭제");
        model.addAttribute("contentsTitle","투자펀딩 심사요청 삭제");

        return "admin/judgement/investment/delete/invest_jduge_delete";
    }

    @GetMapping("delete/law-satistify")
    public String removeLawSatistify(Model model) {

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 삭제");
        model.addAttribute("contentsTitle", "자본시장법 범위충족기준 삭제");

        return "admin/judgement/investment/delete/law_satistify_delete";
    }

    @GetMapping("delete/incongruity-sectors")
    public String removeIncongruitySectors(Model model) {

        model.addAttribute("title", "관리자 : 부적합 업종 삭제");
        model.addAttribute("contentsTitle","부적합 업종 삭제");

        return "admin/judgement/investment/delete/incongruity_sectors_delete";
    }

    @GetMapping("delete/corporate-value")
    public String removeCorporateValueEvaluation(Model model) {

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 삭제");
        model.addAttribute("contentsTitle","기업가치 평가 결과 삭제");

        return "admin/judgement/investment/delete/corporate_value_evaluation_delete";
    }

}