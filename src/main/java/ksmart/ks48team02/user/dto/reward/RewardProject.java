package ksmart.ks48team02.user.dto.reward;

import java.util.List;

public class RewardProject {

    private String rewardProjectCode;
    private String rewardCategoryCode;
    private String projectJudgementReasonCode;
    private String RegMemberId;
    private String adminMemberId;
    private String storeCode;
    private String projectSubject;
    private String projectContents;
    private int rewardLike;
    private String projectThumbnailImage;
    private int projectAchievementMoney;
    private int projectGoalMoney;
    private int projectAchievementPercent;
    private String RegCompany;
    private String projectRegDate;
    private int searchCount;
    private int deliveryPrice;
    private String projectJudgmentReason;
    private String getProjectJudgementDate;
    private String projectStartDate;
    private String projectEndDate;
    private int projectCondition;

    private List<RewardOption> rewardOptionList;

    public List<RewardOption> getRewardOptionList() {
        return rewardOptionList;
    }

    public void setRewardOptionList(List<RewardOption> rewardOptionList) {
        this.rewardOptionList = rewardOptionList;
    }

    @Override
    public String toString() {
        return "RewardProject{" +
                "rewardProjectCode='" + rewardProjectCode + '\'' +
                ", rewardCategoryCode='" + rewardCategoryCode + '\'' +
                ", projectJudgementReasonCode='" + projectJudgementReasonCode + '\'' +
                ", RegMemberId='" + RegMemberId + '\'' +
                ", adminMemberId='" + adminMemberId + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", projectSubject='" + projectSubject + '\'' +
                ", projectContents='" + projectContents + '\'' +
                ", rewardLike=" + rewardLike +
                ", projectThumbnailImage='" + projectThumbnailImage + '\'' +
                ", projectAchievementMoney=" + projectAchievementMoney +
                ", projectGoalMoney=" + projectGoalMoney +
                ", projectAchievementPercent=" + projectAchievementPercent +
                ", RegCompany='" + RegCompany + '\'' +
                ", projectRegDate='" + projectRegDate + '\'' +
                ", searchCount=" + searchCount +
                ", deliveryPrice=" + deliveryPrice +
                ", projectJudgmentReason='" + projectJudgmentReason + '\'' +
                ", getProjectJudgementDate='" + getProjectJudgementDate + '\'' +
                ", projectStartDate='" + projectStartDate + '\'' +
                ", projectEndDate='" + projectEndDate + '\'' +
                ", projectCondition=" + projectCondition +
                ", rewardOptionList=" + rewardOptionList +
                '}';
    }

    public String getRewardProjectCode() {
        return rewardProjectCode;
    }

    public void setRewardProjectCode(String rewardProjectCode) {
        this.rewardProjectCode = rewardProjectCode;
    }

    public String getRewardCategoryCode() {
        return rewardCategoryCode;
    }

    public void setRewardCategoryCode(String rewardCategoryCode) {
        this.rewardCategoryCode = rewardCategoryCode;
    }

    public String getProjectJudgementReasonCode() {
        return projectJudgementReasonCode;
    }

    public void setProjectJudgementReasonCode(String projectJudgementReasonCode) {
        this.projectJudgementReasonCode = projectJudgementReasonCode;
    }

    public String getRegMemberId() {
        return RegMemberId;
    }

    public void setRegMemberId(String regMemberId) {
        RegMemberId = regMemberId;
    }

    public String getAdminMemberId() {
        return adminMemberId;
    }

    public void setAdminMemberId(String adminMemberId) {
        this.adminMemberId = adminMemberId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getProjectSubject() {
        return projectSubject;
    }

    public void setProjectSubject(String projectSubject) {
        this.projectSubject = projectSubject;
    }

    public String getProjectContents() {
        return projectContents;
    }

    public void setProjectContents(String projectContents) {
        this.projectContents = projectContents;
    }

    public int getRewardLike() {
        return rewardLike;
    }

    public void setRewardLike(int rewardLike) {
        this.rewardLike = rewardLike;
    }

    public String getProjectThumbnailImage() {
        return projectThumbnailImage;
    }

    public void setProjectThumbnailImage(String projectThumbnailImage) {
        this.projectThumbnailImage = projectThumbnailImage;
    }

    public int getProjectAchievementMoney() {
        return projectAchievementMoney;
    }

    public void setProjectAchievementMoney(int projectAchievementMoney) {
        this.projectAchievementMoney = projectAchievementMoney;
    }

    public int getProjectGoalMoney() {
        return projectGoalMoney;
    }

    public void setProjectGoalMoney(int projectGoalMoney) {
        this.projectGoalMoney = projectGoalMoney;
    }

    public int getProjectAchievementPercent() {
        return projectAchievementPercent;
    }

    public void setProjectAchievementPercent(int projectAchievementPercent) {
        this.projectAchievementPercent = projectAchievementPercent;
    }

    public String getRegCompany() {
        return RegCompany;
    }

    public void setRegCompany(String regCompany) {
        RegCompany = regCompany;
    }

    public String getProjectRegDate() {
        return projectRegDate;
    }

    public void setProjectRegDate(String projectRegDate) {
        this.projectRegDate = projectRegDate;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getProjectJudgmentReason() {
        return projectJudgmentReason;
    }

    public void setProjectJudgmentReason(String projectJudgmentReason) {
        this.projectJudgmentReason = projectJudgmentReason;
    }

    public String getGetProjectJudgementDate() {
        return getProjectJudgementDate;
    }

    public void setGetProjectJudgementDate(String getProjectJudgementDate) {
        this.getProjectJudgementDate = getProjectJudgementDate;
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public int getProjectCondition() {
        return projectCondition;
    }

    public void setProjectCondition(int projectCondition) {
        this.projectCondition = projectCondition;
    }
}
