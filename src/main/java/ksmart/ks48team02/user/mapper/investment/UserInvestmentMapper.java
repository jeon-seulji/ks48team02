package ksmart.ks48team02.user.mapper.investment;

import ksmart.ks48team02.user.dto.InvestmentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInvestmentMapper {


    public int addInvestment(InvestmentInfo investmentInfo);

    public List<InvestmentInfo> getInvestmentInfo();

    List<InvestmentInfo> getSortedList(String orderBy);

}