package ksmart.ks48team02.user.service.investment;

import ksmart.ks48team02.user.dto.investment.InvestmentRegistration;
import ksmart.ks48team02.user.mapper.investment.InvestmentRegistrationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInvestmentService {

    private final InvestmentRegistrationMapper investmentRegistrationMapper;
    public UserInvestmentService(InvestmentRegistrationMapper investmentRegistrationMapper) {
        this.investmentRegistrationMapper = investmentRegistrationMapper;
    }

    public void addInvesetment(InvestmentRegistration investmentRegistration){
        investmentRegistrationMapper.addInvestment(investmentRegistration);
    }
}
