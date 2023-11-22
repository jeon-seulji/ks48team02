package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class InvestmentContent {
    private String investmentContentCode;
    private String memberId;
    private String investmentCode;
    private String memberIdAdmin;
    private String projectIntroduction;
    private String marketAnalysis;
    private String majorFinancialInformation;
    private String risk;
    private String majorManpower;
    private String patentAwardDetails;
    private String etcInvestContent;
    private String registrationDate;

    private List<InvestmentInfo> investmentInfo;

}
