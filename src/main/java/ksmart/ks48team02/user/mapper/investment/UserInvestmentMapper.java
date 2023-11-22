package ksmart.ks48team02.user.mapper.investment;

import ksmart.ks48team02.user.dto.InvestmentContent;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import ksmart.ks48team02.user.dto.InvestmentJudge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInvestmentMapper {

    // 투자 프로젝트 등록
    public int addInvestment(InvestmentInfo investmentInfo);

    // 투자 프로젝트 조회
    public List<InvestmentInfo> getInvestmentInfo();

    // 투자 프로젝트 상세 조회
    public List<InvestmentContent> getInvestmentContent();

    // 추천순, 최신순, 인기순, 모집금액순, 마감임박순 정렬
    public List<InvestmentInfo> getSortedList(String orderBy);

    // 투자 심사요청 등록
    public int addInvestmentJudge(InvestmentJudge investmentJudge);

}