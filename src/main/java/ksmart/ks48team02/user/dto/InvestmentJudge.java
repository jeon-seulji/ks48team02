package ksmart.ks48team02.user.dto;

public class InvestmentJudge {
    private String investmentRequestJudgeCode;
    private String memberId;
    private String storeCode;
    private String memberIdAdmin;
    private String projectIntroduction;
    private String investmentIntroductionImage;
    private String marketAnalysis;
    private String marketAnalysisImage;
    private String majorFinancialInformation;
    private String majorFinancialInformationImage;
    private String risk;
    private String riskImage;
    private String majorManpower;
    private String majorManpowerImage;
    private String patentAwardDetails;
    private String patentAwardDetailsImage;
    private String etcInvestContent;
    private String etcInvestContentImage;
    private String registrationDate;

    public String getInvestmentRequestJudgeCode() {
        return investmentRequestJudgeCode;
    }

    public void setInvestmentRequestJudgeCode(String investmentRequestJudgeCode) {
        this.investmentRequestJudgeCode = investmentRequestJudgeCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getMemberIdAdmin() {
        return memberIdAdmin;
    }

    public void setMemberIdAdmin(String memberIdAdmin) {
        this.memberIdAdmin = memberIdAdmin;
    }

    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    public String getInvestmentIntroductionImage() {
        return investmentIntroductionImage;
    }

    public void setInvestmentIntroductionImage(String investmentIntroductionImage) {
        this.investmentIntroductionImage = investmentIntroductionImage;
    }

    public String getMarketAnalysis() {
        return marketAnalysis;
    }

    public void setMarketAnalysis(String marketAnalysis) {
        this.marketAnalysis = marketAnalysis;
    }

    public String getMarketAnalysisImage() {
        return marketAnalysisImage;
    }

    public void setMarketAnalysisImage(String marketAnalysisImage) {
        this.marketAnalysisImage = marketAnalysisImage;
    }

    public String getMajorFinancialInformation() {
        return majorFinancialInformation;
    }

    public void setMajorFinancialInformation(String majorFinancialInformation) {
        this.majorFinancialInformation = majorFinancialInformation;
    }

    public String getMajorFinancialInformationImage() {
        return majorFinancialInformationImage;
    }

    public void setMajorFinancialInformationImage(String majorFinancialInformationImage) {
        this.majorFinancialInformationImage = majorFinancialInformationImage;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRiskImage() {
        return riskImage;
    }

    public void setRiskImage(String riskImage) {
        this.riskImage = riskImage;
    }

    public String getMajorManpower() {
        return majorManpower;
    }

    public void setMajorManpower(String majorManpower) {
        this.majorManpower = majorManpower;
    }

    public String getMajorManpowerImage() {
        return majorManpowerImage;
    }

    public void setMajorManpowerImage(String majorManpowerImage) {
        this.majorManpowerImage = majorManpowerImage;
    }

    public String getPatentAwardDetails() {
        return patentAwardDetails;
    }

    public void setPatentAwardDetails(String patentAwardDetails) {
        this.patentAwardDetails = patentAwardDetails;
    }

    public String getPatentAwardDetailsImage() {
        return patentAwardDetailsImage;
    }

    public void setPatentAwardDetailsImage(String patentAwardDetailsImage) {
        this.patentAwardDetailsImage = patentAwardDetailsImage;
    }

    public String getEtcInvestContent() {
        return etcInvestContent;
    }

    public void setEtcInvestContent(String etcInvestContent) {
        this.etcInvestContent = etcInvestContent;
    }

    public String getEtcInvestContentImage() {
        return etcInvestContentImage;
    }

    public void setEtcInvestContentImage(String etcInvestContentImage) {
        this.etcInvestContentImage = etcInvestContentImage;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvestmentJudge{");
        sb.append("investmentRequestJudgeCode='").append(investmentRequestJudgeCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", storeCode='").append(storeCode).append('\'');
        sb.append(", memberIdAdmin='").append(memberIdAdmin).append('\'');
        sb.append(", projectIntroduction='").append(projectIntroduction).append('\'');
        sb.append(", investmentIntroductionImage='").append(investmentIntroductionImage).append('\'');
        sb.append(", marketAnalysis='").append(marketAnalysis).append('\'');
        sb.append(", marketAnalysisImage='").append(marketAnalysisImage).append('\'');
        sb.append(", majorFinancialInformation='").append(majorFinancialInformation).append('\'');
        sb.append(", majorFinancialInformationImage='").append(majorFinancialInformationImage).append('\'');
        sb.append(", risk='").append(risk).append('\'');
        sb.append(", riskImage='").append(riskImage).append('\'');
        sb.append(", majorManpower='").append(majorManpower).append('\'');
        sb.append(", majorManpowerImage='").append(majorManpowerImage).append('\'');
        sb.append(", patentAwardDetails='").append(patentAwardDetails).append('\'');
        sb.append(", patentAwardDetailsImage='").append(patentAwardDetailsImage).append('\'');
        sb.append(", etcInvestContent='").append(etcInvestContent).append('\'');
        sb.append(", etcInvestContentImage='").append(etcInvestContentImage).append('\'');
        sb.append(", registrationDate='").append(registrationDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
