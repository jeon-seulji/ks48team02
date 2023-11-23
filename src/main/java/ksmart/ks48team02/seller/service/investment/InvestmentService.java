package ksmart.ks48team02.seller.service.investment;

import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.SellerInvestmentContent;
import ksmart.ks48team02.seller.mapper.investment.SellerInvestmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ksmart.ks48team02.seller.dto.SellerLawSatistifyReason;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sellerInvestmemtService")
@Transactional
public class InvestmentService {

    // DI(의존성 주입)
    private final SellerInvestmentMapper sellerInvestmentMapper;

    // 생성자메소드를 통한 DI
    public InvestmentService(SellerInvestmentMapper sellerInvestmentMapper){

        this.sellerInvestmentMapper = sellerInvestmentMapper;
    }

    // 판매자 투자펀딩 공고 조회 페이징
    public Map<String, Object> getInvestmentList(String memberIdSeller, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestment> investmentList = sellerInvestmentMapper.getInvestmentList(memberIdSeller, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentList", investmentList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 검색조건에 따른 투자펀딩 공고 조회
    public Map<String, Object> getInvestmentList(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {

        switch (searchKey) {
            case "investmentCode":
                searchKey = "i.investment_code";
                break;
            case "investmentRequestJudgeCode":
                searchKey = "i.investment_request_judge_code";
                break;
            case "memberIdSeller":
                searchKey = "i.member_id_seller";
                break;
            case "investmentSubject":
                searchKey = "i.investment_subject";
                break;
            case "investmentCompany":
                searchKey = "i.investment_company";
                break;
            case "securitiesClassification":
                searchKey = "i.securities_classification";
                break;
            case "investJudgeSituation":
                searchKey = "i.invest_judge_situation";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestment> investmentList = sellerInvestmentMapper.getInvestmentListBySearch(memberIdSeller, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentList", investmentList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String memberIdSeller, String investmentCode) {
        AdminInvestment investmentInfo = sellerInvestmentMapper.getInvestementByCode(memberIdSeller, investmentCode);

        return investmentInfo;
    }

    // 판매자 투자펀딩 심사요청 목록 조회
    public Map<String, Object> getInvestmentRequestJudgeList(String memberIdSeller, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = sellerInvestmentMapper.getInvestmentRequestJudgeList(memberIdSeller, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentRequestJudgeList", investmentRequestJudgeList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;

    }

    // 판매자 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public Map<String, Object> getInvestmentRequestJudgeList(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {

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
            case "investJudgeResult":
                searchKey = "i.invest_judge_result";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = sellerInvestmentMapper.getInvestmentRequestJudgeListBySearch(memberIdSeller, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentRequestJudgeList", investmentRequestJudgeList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String memberIdSeller, String investmentRequestJudgeCode) {
        AdminInvestmentRequestJudge investmentRequestJudgeInfo = sellerInvestmentMapper.getInvestmentRequestJudgeByCode(memberIdSeller, investmentRequestJudgeCode);

        return investmentRequestJudgeInfo;
    }

    // 판매자 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList() {
        List<AdminLawSatistifyReason> lawSatistifyReasonList = sellerInvestmentMapper.getLawSatistifyList();

        return lawSatistifyReasonList;
    }

    // 판매자 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList() {
        List<AdminIncongruitySectors> incongruitySectorsList = sellerInvestmentMapper.getIncogruitySectorsList();

        return incongruitySectorsList;
    }

    // 판매자 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode) {
        AdminCorporateValueEvaluation corporateValueEvaluationInfo = sellerInvestmentMapper.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        return  corporateValueEvaluationInfo;
    }

    // 판매자 투자펀딩 공고 수정
    public void modifyInvestment(AdminInvestment adminInvestment) {
        sellerInvestmentMapper.modifyInvestment(adminInvestment);
    }

    // 판매자 투자펀딩 공고 상세 수정
    public void modifyInvestmentContent(SellerInvestmentContent sellerInvestmentContent) {
        sellerInvestmentMapper.modifyInvestmentContent(sellerInvestmentContent);
    }

    // 판매자 투자펀딩 심사요청 수정
    public void modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        sellerInvestmentMapper.modifyInvestmentRequestJudge(adminInvestmentRequestJudge);
    }

    // 판매자 투자펀딩 공고 삭제
    public void removeInvestment(String investmentCode, String investmentContentCode) {

        sellerInvestmentMapper.removeInvestmentContent(investmentContentCode);
        sellerInvestmentMapper.removeInvestment(investmentCode);
    }

    // 판매자 투자펀딩 심사요청 삭제
    public void reomveInvestmentJudge(String investmentRequestJudgeCode) {
        sellerInvestmentMapper.removeInvestmentRequestJudge(investmentRequestJudgeCode);
    }

    // 페이징 처리
    private Map<String, Integer> calculatePagingInfo(int currentPage, double rowCnt, int rowPerpage) {

        // 보여줄 행의 시작점
        int startRowNum = (currentPage - 1) * rowPerpage;

        // 마지막페이지: (전체 행의 갯수/보여줄 행의 갯수) 올림처리
        int lastPage = (int) Math.ceil(rowCnt / rowPerpage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10(10 미만일경우 마지막페이지만큼)
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if (currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if (endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }

        Map<String, Integer> pagingInfo = new HashMap<>();
        pagingInfo.put("startRowNum", startRowNum);
        pagingInfo.put("lastPage", lastPage);
        pagingInfo.put("startPageNum", startPageNum);
        pagingInfo.put("endPageNum", endPageNum);

        return pagingInfo;
    }
}
