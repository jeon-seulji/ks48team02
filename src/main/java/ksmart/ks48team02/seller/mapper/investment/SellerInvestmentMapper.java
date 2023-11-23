package ksmart.ks48team02.seller.mapper.investment;

import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.SellerInvestmentContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerInvestmentMapper {
    
    // 판매자 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentList(String memberIdSeller, int startRowNum, int rowPerPage);

    // 판매자 투자펀딩 공고 전체 행의 갯수
    public int getInvestment(String memberIdSeller);

    // 판매자 검색조건에 따른 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentListBySearch(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 판매자 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String memberIdSeller, String investmentCode);

    // 판매자 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList(String memberIdSeller, int startRowNum, int rowPerPage);

    // 판매자 투자펀딩 심사요청 전체 행의 갯수
    public int getInvestmentRequestJudgeCnt();

    // 판매자 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListBySearch(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 판매자 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String memberIdSeller, String investmentRequestJudgeCode);

    // 판매자 투자후 기업정보 공개 조회


    // 판매자 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList();

    // 판매자 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList();

    // 판매자 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode);

    // 판매자 투자펀딩 공고 수정
    public int modifyInvestment(AdminInvestment adminInvestment);

    // 판매자 투자펀딩 공고 상세 수정
    public int modifyInvestmentContent(SellerInvestmentContent sellerInvestmentContent);

    // 판매자 투자펀딩 심사요청 수정
    public int modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge);

    // 판매자 투자펀딩 공고 삭제
    public int removeInvestment(String investmentCode);

    // 판매자 투자펀딩 공고 상세 삭제
    public int removeInvestmentContent(String investmentContentCode);

    // 판매자 투자펀딩 심사요청 삭제
    public int removeInvestmentRequestJudge(String investmentRequestJudgeCode);
}
