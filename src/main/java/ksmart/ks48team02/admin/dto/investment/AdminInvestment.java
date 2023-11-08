package ksmart.ks48team02.admin.dto.investment;

public class AdminInvestment {
    private String investmentCode;
    private String memberId;
    private String storeCode;
    private String investmentRequestJudgeCode;
    private String totalCategoryCode;
    private String memberIdSeller;
    private String investmentSubject;
    private String investmentContent;
    private String investmentImage;
    private int investmentLike;
    private long investmentAmount;
    private long investmentAchievementMoney;
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
    private float contractFeeRate;
    private String contractFile;
    private int investJudgeSituation;

    public String getInvestmentCode() {
        return investmentCode;
    }
    public void setInvestmentCode(String investmentCode) {
        this.investmentCode = investmentCode;
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
    public String getInvestmentRequestJudgeCode() {
        return investmentRequestJudgeCode;
    }
    public void setInvestmentRequestJudgeCode(String investmentRequestJudgeCode) {
        this.investmentRequestJudgeCode = investmentRequestJudgeCode;
    }
    public String getTotalCategoryCode() {
        return totalCategoryCode;
    }
    public void setTotalCategoryCode(String totalCategoryCode) {
        this.totalCategoryCode = totalCategoryCode;
    }
    public String getMemberIdSeller() {
        return memberIdSeller;
    }
    public void setMemberIdSeller(String memberIdSeller) {
        this.memberIdSeller = memberIdSeller;
    }
    public String getInvestmentSubject() {
        return investmentSubject;
    }
    public void setInvestmentSubject(String investmentSubject) {
        this.investmentSubject = investmentSubject;
    }
    public String getInvestmentContent() {
        return investmentContent;
    }
    public void setInvestmentContent(String investmentContent) {
        this.investmentContent = investmentContent;
    }
    public String getInvestmentImage() {
        return investmentImage;
    }
    public void setInvestmentImage(String investmentImage) {
        this.investmentImage = investmentImage;
    }
    public int getInvestmentLike() {
        return investmentLike;
    }
    public void setInvestmentLike(int investmentLike) {
        this.investmentLike = investmentLike;
    }
    public long getInvestmentAmount() {
        return investmentAmount;
    }
    public void setInvestmentAmount(long investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
    public long getInvestmentAchievementMoney() {
        return investmentAchievementMoney;
    }
    public void setInvestmentAchievementMoney(long investmentAchievementMoney) {
        this.investmentAchievementMoney = investmentAchievementMoney;
    }
    public int getInvestAchievementPercent() {
        return investAchievementPercent;
    }
    public void setInvestAchievementPercent(int investAchievementPercent) {
        this.investAchievementPercent = investAchievementPercent;
    }
    public String getInvestmentCompany() {
        return investmentCompany;
    }
    public void setInvestmentCompany(String investmentCompany) {
        this.investmentCompany = investmentCompany;
    }
    public int getSearchCount() {
        return searchCount;
    }
    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }
    public int getInvestCount() {
        return investCount;
    }
    public void setInvestCount(int investCount) {
        this.investCount = investCount;
    }
    public String getSecuritiesClassification() {
        return securitiesClassification;
    }
    public void setSecuritiesClassification(String securitiesClassification) {
        this.securitiesClassification = securitiesClassification;
    }
    public String getInvestmentDisplayDate() {
        return investmentDisplayDate;
    }
    public void setInvestmentDisplayDate(String investmentDisplayDate) {
        this.investmentDisplayDate = investmentDisplayDate;
    }
    public String getInvestmentRegDate() {
        return investmentRegDate;
    }
    public void setInvestmentRegDate(String investmentRegDate) {
        this.investmentRegDate = investmentRegDate;
    }
    public String getInvestmentDeadline() {
        return investmentDeadline;
    }
    public void setInvestmentDeadline(String investmentDeadline) {
        this.investmentDeadline = investmentDeadline;
    }
    public String getInvestmentReport() {
        return investmentReport;
    }
    public void setInvestmentReport(String investmentReport) {
        this.investmentReport = investmentReport;
    }
    public int getBasicFee() {
        return basicFee;
    }
    public void setBasicFee(int basicFee) {
        this.basicFee = basicFee;
    }
    public float getContractFeeRate() {
        return contractFeeRate;
    }
    public void setContractFeeRate(float contractFeeRate) {
        this.contractFeeRate = contractFeeRate;
    }
    public String getContractFile() {
        return contractFile;
    }
    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }
    public int getInvestJudgeSituation() {
        return investJudgeSituation;
    }
    public void setInvestJudgeSituation(int investJudgeSituation) {
        this.investJudgeSituation = investJudgeSituation;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AdminInvestment [investmentCode=");
        builder.append(investmentCode);
        builder.append(", memberId=");
        builder.append(memberId);
        builder.append(", storeCode=");
        builder.append(storeCode);
        builder.append(", investmentRequestJudgeCode=");
        builder.append(investmentRequestJudgeCode);
        builder.append(", totalCategoryCode=");
        builder.append(totalCategoryCode);
        builder.append(", memberIdSeller=");
        builder.append(memberIdSeller);
        builder.append(", investmentSubject=");
        builder.append(investmentSubject);
        builder.append(", investmentContent=");
        builder.append(investmentContent);
        builder.append(", investmentImage=");
        builder.append(investmentImage);
        builder.append(", investmentLike=");
        builder.append(investmentLike);
        builder.append(", investmentAmount=");
        builder.append(investmentAmount);
        builder.append(", investmentAchievementMoney=");
        builder.append(investmentAchievementMoney);
        builder.append(", investAchievementPercent=");
        builder.append(investAchievementPercent);
        builder.append(", investmentCompany=");
        builder.append(investmentCompany);
        builder.append(", searchCount=");
        builder.append(searchCount);
        builder.append(", investCount=");
        builder.append(investCount);
        builder.append(", securitiesClassification=");
        builder.append(securitiesClassification);
        builder.append(", investmentDisplayDate=");
        builder.append(investmentDisplayDate);
        builder.append(", investmentRegDate=");
        builder.append(investmentRegDate);
        builder.append(", investmentDeadline=");
        builder.append(investmentDeadline);
        builder.append(", investmentReport=");
        builder.append(investmentReport);
        builder.append(", basicFee=");
        builder.append(basicFee);
        builder.append(", contractFeeRate=");
        builder.append(contractFeeRate);
        builder.append(", contractFile=");
        builder.append(contractFile);
        builder.append(", investJudgeSituation=");
        builder.append(investJudgeSituation);
        builder.append("]");
        return builder.toString();
    }
}