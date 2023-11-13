package ksmart.ks48team02.user.dto;


import lombok.Data;

@Data
public class RewardOption {

    private String rewardOptionCode;
    private String rewardProjectCode;
    private String optionContents;
    private int optionPrice;
    private int optionLimitQuantity;
    private String optionName;
    private int optionDeliveryPrice;
    private String optionEstimatedDeliveryDate;


}
