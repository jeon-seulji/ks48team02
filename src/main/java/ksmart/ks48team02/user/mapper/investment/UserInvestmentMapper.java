package ksmart.ks48team02.user.mapper.investment;

import ksmart.ks48team02.user.dto.InvestmentContent;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import ksmart.ks48team02.user.dto.InvestmentJudge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInvestmentMapper {


    public int addInvestment(InvestmentInfo investmentInfo);

    public List<InvestmentInfo> getInvestmentInfo();

    public List<InvestmentContent> getInvestmentContent();

    public List<InvestmentInfo> getSortedList(String orderBy);

    public int addInvestmentJudge(InvestmentJudge investmentJudge);

}