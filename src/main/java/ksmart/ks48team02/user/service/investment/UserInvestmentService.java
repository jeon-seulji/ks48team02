package ksmart.ks48team02.user.service.investment;

import ksmart.ks48team02.user.dto.InvestmentContent;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import ksmart.ks48team02.user.dto.InvestmentJudge;
import ksmart.ks48team02.user.mapper.investment.UserInvestmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInvestmentService {

    private final UserInvestmentMapper userInvestmentMapper;
    public UserInvestmentService(UserInvestmentMapper userInvestmentMapper) {
        this.userInvestmentMapper = userInvestmentMapper;
    }

    public List<InvestmentInfo> getInvestmentInfo(){
        List<InvestmentInfo> investmentInfo = userInvestmentMapper.getInvestmentInfo();
        return investmentInfo;
    }

    public List<InvestmentContent> getInvestmentContent(){
        List<InvestmentContent> investmentContent = userInvestmentMapper.getInvestmentContent();
        return investmentContent;
    }


    public List<InvestmentInfo> getSortedList(String orderBy) {
        return userInvestmentMapper.getSortedList(orderBy);
    }






}