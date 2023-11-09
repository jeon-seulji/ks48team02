package ksmart.ks48team02.user.dto.order;

public class OrderTotal {
    private String orderCode;
    private String memberId;
    private String orderCategoryCode;
    private String orderName;
    private String orderFundingName;
    private int orderTotalPrice;
    private String orderCategoryDetail;
    private String goodsCode;
    private String orderApplicationDate;
    private String orderConfirmDate;
    private String orderCancellDate;

    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", orderCategoryCode='" + orderCategoryCode + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderFundingName='" + orderFundingName + '\'' +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderCategoryDetail='" + orderCategoryDetail + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", orderApplicationDate='" + orderApplicationDate + '\'' +
                ", orderConfirmDate='" + orderConfirmDate + '\'' +
                ", orderCancellDate='" + orderCancellDate + '\'' +
                '}';
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
