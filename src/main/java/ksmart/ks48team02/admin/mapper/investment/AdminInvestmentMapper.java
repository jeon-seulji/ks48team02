package ksmart.ks48team02.admin.mapper.investment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.ks48team02.admin.dto.AdminInvestmentRequestJudge;
import ksmart.ks48team02.admin.dto.AdminLawSatistifyReason;
import ksmart.ks48team02.admin.dto.AdminIncongruitySectors;
import ksmart.ks48team02.admin.dto.AdminCorporateValueEvaluation;

@Mapper
public interface AdminInvestmentMapper {

    // 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList();

    // 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate);

    // 코드에 따른 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String investmentRequestJudgeCode);

    // 심사결과에 따른 특정 투자펀딩 심사요청 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeByResult(String rejectCnt);

    // 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList();

    // 검색조건에 따른 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate);

    // 특정 자본시장 범위충족기준 조회
    public AdminLawSatistifyReason getLawSatistifyByCode(String lawSatistifyCode);

    // 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList();

    // 검색조건에 따른 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate);

    // 특정 부적합 업종 조회
    public AdminIncongruitySectors getIncogruitySectorsByCode(String incongruitySectorsCode);

    // 기업가치 평과결가 목록 조회
    public List<AdminCorporateValueEvaluation> getCorporateValueEvaluationList();

    // 검색조건에 따른 기업가치 평과결가 목록 조회

    public List<AdminCorporateValueEvaluation> getCorporateValueEvaluationListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate);

    // 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode);

    // 자본시장 범위충족기준 등록
    public int addLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason);

    // 투자펀딩 심사요청 수정
    public int modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge);

    // 자본시장 범위충족기준 수정
    public int modifyLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason);

    // 부적합 업종 수정
    public int modifyIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors);

    // 투자펀딩 심사요청 삭제
    public int removeInvestmentRequestJudge(String investmentRequestJudgeCode);
}