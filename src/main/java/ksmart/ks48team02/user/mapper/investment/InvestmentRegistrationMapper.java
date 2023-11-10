package ksmart.ks48team02.user.mapper.investment;

import ksmart.ks48team02.user.dto.InvestmentRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvestmentRegistrationMapper {


    public int addInvestment(InvestmentRegistration investmentRegistration);
}
