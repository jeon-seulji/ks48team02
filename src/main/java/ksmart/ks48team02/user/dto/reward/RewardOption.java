package ksmart.ks48team02.user.dto.reward;

public class RewardOption {

    private String rewardOptionCode;
    private String rewardProjectCode;
    private String optionContents;
    private int optionPrice;
    private int optionLimitQuantity;
    private String optionName;

    @Override
    public String toString() {
        return "RewardOption{" +
                "rewardOptionCode='" + rewardOptionCode + '\'' +
                ", rewardProjectCode='" + rewardProjectCode + '\'' +
                ", optionContents='" + optionContents + '\'' +
                ", optionPrice=" + optionPrice +
                ", optionLimitQuantity=" + optionLimitQuantity +
                ", optionName='" + optionName + '\'' +
                '}';
    }

    public String getRewardOptionCode() {
        return rewardOptionCode;
    }

    public void setRewardOptionCode(String rewardOptionCode) {
        this.rewardOptionCode = rewardOptionCode;
    }

    public String getRewardProjectCode() {
        return rewardProjectCode;
    }

    public void setRewardProjectCode(String rewardProjectCode) {
        this.rewardProjectCode = rewardProjectCode;
    }

    public String getOptionContents() {
        return optionContents;
    }

    public void setOptionContents(String optionContents) {
        this.optionContents = optionContents;
    }

    public int getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(int optionPrice) {
        this.optionPrice = optionPrice;
    }

    public int getOptionLimitQuantity() {
        return optionLimitQuantity;
    }

    public void setOptionLimitQuantity(int optionLimitQuantity) {
        this.optionLimitQuantity = optionLimitQuantity;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
