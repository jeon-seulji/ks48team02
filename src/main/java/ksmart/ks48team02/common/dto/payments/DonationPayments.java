package ksmart.ks48team02.common.dto.payments;

public class DonationPayments {
    private String donationOrderCode;
    private String orderCode;
    private int donationGoods;
    private int donationPrice;
    private String donationName;
    private String securityNumber;

    @Override
    public String toString() {
        return "DonationPayments{" +
                "donationOrderCode='" + donationOrderCode + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", donationGoods=" + donationGoods +
                ", donationPrice=" + donationPrice +
                ", donationName='" + donationName + '\'' +
                ", securityNumber='" + securityNumber + '\'' +
                '}';
    }

    public String getDonationOrderCode() {
        return donationOrderCode;
    }

    public void setDonationOrderCode(String donationOrderCode) {
        this.donationOrderCode = donationOrderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getDonationGoods() {
        return donationGoods;
    }

    public void setDonationGoods(int donationGoods) {
        this.donationGoods = donationGoods;
    }

    public int getDonationPrice() {
        return donationPrice;
    }

    public void setDonationPrice(int donationPrice) {
        this.donationPrice = donationPrice;
    }

    public String getDonationName() {
        return donationName;
    }

    public void setDonationName(String donationName) {
        this.donationName = donationName;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }
}
