package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class InvestmentInfo {
    private String investmentCode;
    private String memberId;
    private String storeCode;
    private String investmentRequestJudgeCode;
    private String totalCategoryCode;
    private String memberIdSeller;
    private String investmentSubject;
    private String investmentImage;
    private int investmentLike;
    private int investmentAmount;
    private int investmentAchievementMoney;
    private int investAchievementPercent;
    private String investmentCompany;
    private int searchCount;
    private int investCount;
    private String securitiesClassification;
    private String investmentDisplayDate;

    private String investmentRegDate;
    private String investmentDeadline;
    private String investmentReport;
    private int basicFee;
    private double contractFeeRate;
    private String contractFile;
    private int investJudgeSituation;
    private int investmentDeadlineCnt;



    private String investmentContentCode;
    private String projectIntroduction;
    private String marketAnalysis;
    private String majorFinancialInformation;
    private String risk;
    private String majorManpower;
    private String patentAwardDetails;
    private String etcInvestContent;
    private String companyBusinessTypeCode;
    private int stockNumber;
    private int issueStockNumber;







}
