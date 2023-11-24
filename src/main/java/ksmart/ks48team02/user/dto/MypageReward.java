package ksmart.ks48team02.user.dto;

import ksmart.ks48team02.common.dto.RewardOrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class MypageReward {
    private String paymentCode;
    private String orderCode;
    private String memberId;
    private String rewardRefundCode;
    private String switchingCode;
    private int orderPrice;
    private int deliveryPrice;
    private int orderTotalPrice;
    private int useReservePrice;
    private String useReserveCode;
    private int discountRankPrice;
    private String discountCouponPrice;
    private int paymentScheduledPrice;
    private String paymentMethod;
    private String depositName;
    private String depositAccount;
    private String refundAccount;
    private int depositPrice;
    private String paymentState;
    private String paymentDeadlineDate;
    private String paymentCompletedDate;
    private String projectThumbnailImage;
    private String rewardProjectCode;
    private String projectSubject;
    private String refundSubejct;
    private String refundTitle;
    private String refundComments;
    private String changeCategory;
    private String refundCode;
    private String storeCode;
    private int savingPoint;
    private String couponIssueCode;


    private List<RewardOrderDetail> rewardOrderDetailList;


}
