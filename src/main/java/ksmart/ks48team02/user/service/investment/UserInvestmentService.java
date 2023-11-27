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

    // 투자 심사요청 등록
    public void addInvestmentJudge(InvestmentJudge investmentJudge){

        System.out.println(investmentJudge);
        int addInvestmentJudge = userInvestmentMapper.addInvestmentJudge(investmentJudge);
        if (addInvestmentJudge <= 0) {
            System.out.println("투자 심사요청 등록에 실패했습니다.");
        }

    }

    // 투자 프로젝트 등록
    public void addInvestment(InvestmentInfo investmentInfo){

        System.out.println(investmentInfo);
        int addInvestment = userInvestmentMapper.addInvestment(investmentInfo);
        if (addInvestment <= 0) {
            System.out.println("투자 프로젝트 등록에 실패했습니다.");
        }

    }

    // 투자 프로젝트 상세 등록
    public void addInvestmentContent(InvestmentContent investmentContent){

        System.out.println(investmentContent);
        int addInvestmentContent = userInvestmentMapper.addInvestmentContent(investmentContent);
        if (addInvestmentContent <= 0) {
            System.out.println("투자 프로젝트 상세 등록에 실패했습니다.");
        }
    }

    public List<InvestmentJudge> getInvestmentJudge(){
        List<InvestmentJudge> investmentJudge = userInvestmentMapper.getInvestmentJudge();
        return investmentJudge;
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