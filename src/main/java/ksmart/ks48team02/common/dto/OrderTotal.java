package ksmart.ks48team02.common.dto;

import java.util.List;

public class OrderTotal {
    private String orderCode;
    private String memberId;
    private String orderCategoryCode;
    private String orderName;
    private String orderFundingName;
    private int orderTotalPrice;
    private String orderCategoryDetail;
    private String goodsCode;
    private String goodsPartition;
    private String orderApplicationDate;
    private String orderConfirmDate;
    private String orderCancellDate;
    private String rewardOrderDetailCode;
    private String rewardPaymentCode;
    private String projectThumbnailImage;
    List<RewardOrderDetail> rewardOrderDetailList;

    public List<RewardOrderDetail> getRewardOrderDetailList() {
        return rewardOrderDetailList;
    }

    public void setRewardOrderDetailList(List<RewardOrderDetail> rewardOrderDetailList) {
        this.rewardOrderDetailList = rewardOrderDetailList;
    }

    public String getProjectThumbnailImage() {
        return projectThumbnailImage;
    }

    public void setProjectThumbnailImage(String projectThumbnailImage) {
        this.projectThumbnailImage = projectThumbnailImage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderTotal{");
        sb.append("orderCode='").append(orderCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", orderCategoryCode='").append(orderCategoryCode).append('\'');
        sb.append(", orderName='").append(orderName).append('\'');
        sb.append(", orderFundingName='").append(orderFundingName).append('\'');
        sb.append(", orderTotalPrice=").append(orderTotalPrice);
        sb.append(", orderCategoryDetail='").append(orderCategoryDetail).append('\'');
        sb.append(", goodsCode='").append(goodsCode).append('\'');
        sb.append(", goodsPartition='").append(goodsPartition).append('\'');
        sb.append(", orderApplicationDate='").append(orderApplicationDate).append('\'');
        sb.append(", orderConfirmDate='").append(orderConfirmDate).append('\'');
        sb.append(", orderCancellDate='").append(orderCancellDate).append('\'');
        sb.append(", rewardOrderDetailCode='").append(rewardOrderDetailCode).append('\'');
        sb.append(", rewardPaymentCode='").append(rewardPaymentCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getRewardOrderDetailCode() {
        return rewardOrderDetailCode;
    }

    public void setRewardOrderDetailCode(String rewardOrderDetailCode) {
        this.rewardOrderDetailCode = rewardOrderDetailCode;
    }

    public String getRewardPaymentCode() {
        return rewardPaymentCode;
    }

    public void setRewardPaymentCode(String rewardPaymentCode) {
        this.rewardPaymentCode = rewardPaymentCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderCategoryCode() {
        return orderCategoryCode;
    }

    public void setOrderCategoryCode(String orderCategoryCode) {
        this.orderCategoryCode = orderCategoryCode;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderFundingName() {
        return orderFundingName;
    }

    public void setOrderFundingName(String orderFundingName) {
        this.orderFundingName = orderFundingName;
    }

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderCategoryDetail() {
        return orderCategoryDetail;
    }

    public void setOrderCategoryDetail(String orderCategoryDetail) {
        this.orderCategoryDetail = orderCategoryDetail;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
    public String getGoodsPartition() {
        return goodsPartition;
    }

    public void setGoodsPartition(String goodsPartition) {
        this.goodsPartition = goodsPartition;
    }

    public String getOrderApplicationDate() {
        return orderApplicationDate;
    }

    public void setOrderApplicationDate(String orderApplicationDate) {
        this.orderApplicationDate = orderApplicationDate;
    }

    public String getOrderConfirmDate() {
        return orderConfirmDate;
    }

    public void setOrderConfirmDate(String orderConfirmDate) {
        this.orderConfirmDate = orderConfirmDate;
    }

    public String getOrderCancellDate() {
        return orderCancellDate;
    }

    public void setOrderCancellDate(String orderCancellDate) {
        this.orderCancellDate = orderCancellDate;
    }

}
