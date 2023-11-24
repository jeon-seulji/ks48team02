package ksmart.ks48team02.user.service.investment;

import ksmart.ks48team02.user.dto.*;
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

    // 투자 프로젝트 등록
    public void addInvestment(InvestmentInfo investmentInfo){

        int addInvestment = userInvestmentMapper.addInvestment(investmentInfo);
        String investmentCode = investmentInfo.getInvestmentCode();

//        List<InvestmentContent> contentList = investmentInfo.getInvestmentContent();
//
//        contentList.forEach(option -> {
//
//            option.setInvestmentCode(investmentCode);
//            userInvestmentMapper.addInvestmentContent(option);
//        });
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

    public List<UserCompanyBusinessType> getUserCompanyBusinessType(){
        List<UserCompanyBusinessType> userCompanyBusinessType = userInvestmentMapper.getUserCompanyBusinessType();
        return userCompanyBusinessType;
    }

    public List<UserLawSatistifyReason> getUserLawSatistifyReason(){
        List<UserLawSatistifyReason> userLawSatistifyReason = userInvestmentMapper.getUserLawSatistifyReason();
        return userLawSatistifyReason;
    }






}