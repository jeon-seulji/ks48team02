package ksmart.ks48team02.admin.service.investment;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.ks48team02.admin.mapper.investment.AdminInvestmentMapper;
import ksmart.ks48team02.admin.dto.AdminInvestmentRequestJudge;
import ksmart.ks48team02.admin.dto.AdminLawSatistifyReason;
import ksmart.ks48team02.admin.dto.AdminIncongruitySectors;
import ksmart.ks48team02.admin.dto.AdminCorporateValueEvaluation;

@Service("adminInvestmemtService")
@Transactional
public class InvestmentService {

    // DI(의존성 주입)
    private final AdminInvestmentMapper adminInvestmentMapper;

    // 생성자메소드를 통한 DI
    public InvestmentService(AdminInvestmentMapper adminInvestmentMapper){

        this.adminInvestmentMapper = adminInvestmentMapper;
    }

    // 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList() {
        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = adminInvestmentMapper.getInvestmentRequestJudgeList();

        return investmentRequestJudgeList;
    }

    // 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate) {
        switch (searchKey) {
            case "investmentRequestJudgeCode":
                searchKey = "i.investment_request_judge_code";
                break;
            case "investmentRequestSubject":
                searchKey = "i.investment_request_subject";
                break;
            case "memberIdSeller":
                searchKey = "i.member_id_seller";
                break;
            case "storeName":
                searchKey = "s.store_name";
                break;
            case "investmentCompany":
                searchKey = "i.investment_company";
                break;
            case "representativeName":
                searchKey = "s.representative_name";
                break;
        }
        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = adminInvestmentMapper.getInvestmentRequestJudgeListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);

        return investmentRequestJudgeList;
    }

    // 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String investmentRequestJudgeCode) {
        AdminInvestmentRequestJudge investmentRequestJudgeInfo = adminInvestmentMapper.getInvestmentRequestJudgeByCode(investmentRequestJudgeCode);

        return investmentRequestJudgeInfo;
    }

    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeByResult(String rejectCnt) {
        List<AdminInvestmentRequestJudge> investmentRequestJudgeInfoByResult = adminInvestmentMapper.getInvestmentRequestJudgeByResult(rejectCnt);

        return investmentRequestJudgeInfoByResult;
    }

    // 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList() {
        List<AdminLawSatistifyReason> lawSatistifyReasonList = adminInvestmentMapper.getLawSatistifyList();

        return lawSatistifyReasonList;
    }

    // 검색조건에 따른 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate) {
        switch (searchKey) {
            case "lawSatistifyCode":
                searchKey = "l.law_satistify_code";
                break;
            case "lawSatistifyReason":
                searchKey = "l.law_satistify_reason";
                break;
            case "memberId":
                searchKey = "l.member_id";
                break;
        }
        List<AdminLawSatistifyReason> lawSatistifyReasonList = adminInvestmentMapper.getLawSatistifyListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);

        return lawSatistifyReasonList;
    }

    // 특정 자본시장법 범위충족기준 조회
    public AdminLawSatistifyReason getLawSatistifyByCode(String lawSatistifyCode) {
        AdminLawSatistifyReason lawSatistifyInfo = adminInvestmentMapper.getLawSatistifyByCode(lawSatistifyCode);

        return lawSatistifyInfo;
    }

    // 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList() {
        List<AdminIncongruitySectors> incongruitySectorsList = adminInvestmentMapper.getIncogruitySectorsList();

        return incongruitySectorsList;
    }

    // 검색조건에 따른 부적합 업종 목록
    public List<AdminIncongruitySectors> getIncogruitySectorsList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate) {
        switch (searchKey) {
            case "incongruitySectorsCode":
                searchKey = "i.incongruity_sectors_code";
                break;
            case "incongruitySectorsBusiness":
                searchKey = "i.incongruity_sectors_business";
                break;
            case "memberId":
                searchKey = "i.member_id";
                break;
        }
        List<AdminIncongruitySectors> incongruitySectorsList = adminInvestmentMapper.getIncogruitySectorsListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);

        return incongruitySectorsList;
    }

    // 특정 부적합 업종 조회
    public AdminIncongruitySectors getIncogruitySectorsByCode(String incongruitySectorsCode) {
        AdminIncongruitySectors incongruitySectorsInfo = adminInvestmentMapper.getIncogruitySectorsByCode(incongruitySectorsCode);

        return incongruitySectorsInfo;
    }

    // 기업가치 평가결과 목록 조회
    public List<AdminCorporateValueEvaluation> getCorporateValueEvaluationList() {
        List<AdminCorporateValueEvaluation> corporateValueEvaluationList = adminInvestmentMapper.getCorporateValueEvaluationList();

        return corporateValueEvaluationList;
    }

    // 검색조건에 따른 기업가치 평가결과 목록 조회
    public List<AdminCorporateValueEvaluation> getCorporateValueEvaluationList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate) {
        switch (searchKey) {
            case "investmentRequestJudgeCode":
                searchKey = "i.investment_request_judge_code";
                break;
            case "investmentRequestSubject":
                searchKey = "i.investment_request_subject";
                break;
            case "memberIdSeller":
                searchKey = "i.member_id_seller";
                break;
            case "corporateValueEvaluationCode":
                searchKey = "c.corporate_value_evaluation_code";
                break;
            case "memberId":
                searchKey = "c.member_id";
                break;
            case "corpValueFulfill":
                searchKey = "c.corp_value_fulfill";
                break;
        }
        List<AdminCorporateValueEvaluation> corporateValueEvaluationList = adminInvestmentMapper.getCorporateValueEvaluationListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate);

        return corporateValueEvaluationList;
    }

    // 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode) {
        AdminCorporateValueEvaluation corporateValueEvaluationInfo = adminInvestmentMapper.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        return  corporateValueEvaluationInfo;
    }

    // 자본시장법 범위충족기준 등록
    public void addLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {
        adminInvestmentMapper.addLawSatistify(adminLawSatistifyReason);
    }

    // 투자펀딩 심사요청 수정
    public void modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        adminInvestmentMapper.modifyInvestmentRequestJudge(adminInvestmentRequestJudge);
    }

    // 자본시장법 범위충족기준 수정
    public void modifyLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {
        adminInvestmentMapper.modifyLawSatistify(adminLawSatistifyReason);
    }

    // 부적합 업종 수정
    public void modifyIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors) {
        adminInvestmentMapper.modifyIncongruitySectors(adminIncongruitySectors);
    }

    // 기업가치 평가 수정
    public void modifyCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation) {
        adminInvestmentMapper.modifyCorporateValueEvaluation(adminCorporateValueEvaluation);
    }

    public void reomveInvestmentJudge(String investmentRequestJudgeCode) {
        adminInvestmentMapper.removeInvestmentRequestJudge(investmentRequestJudgeCode);
    }
}