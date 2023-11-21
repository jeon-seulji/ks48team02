package ksmart.ks48team02.seller.mapper.investment;

import ksmart.ks48team02.admin.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerInvestmentMapper {
    
    // 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentList(String memberIdSeller);

    // 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String investmentCode);

    // 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList(String memberIdSeller, int startRowNum, int rowPerPage);

    // 투자펀딩 심사요청 전체 행의 갯수
    public int getInvestmentRequestJudgeCnt();

    // 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListBySearch(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String investmentRequestJudgeCode);

    // 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList();

    // 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList();

    // 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode);

    // 투자펀딩 심사요청 수정
    public int modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge);

    // 투자펀딩 심사요청 삭제
    public int removeInvestmentRequestJudge(String investmentRequestJudgeCode);
}
