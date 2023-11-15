package ksmart.ks48team02.user.mapper.reward;


import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.RewardOption;
import ksmart.ks48team02.user.dto.RewardProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RewardMapper {


    //주문 회원 정보 조회
    public Member getOrderMemberInfo(String memberId);

    //프로젝트 등록
    public int addRewardProject (RewardProject rewardProject);

    //리워드 옵션 등록
    public int rewardOptionAdd (RewardOption rewardOption);

    //리워드프로젝트 전체 조회.
    public List<RewardProject> rewardProjectList();

    //리워드 프로젝트 상세 페이지
    public RewardProject rewardProjectDetail(String rewardProjectCode);

    //주문번호, 주문상세번호, 결제번호 생성.
    public OrderTotal getOrderAndPaymentCode();

    //통합 주문 테이블 인서트
    public int orderTableInsert(PaymentResult paymentResult);

    //리워드 주문 상세 테이블 인서트
    public int rewardOrderDetailInsert(RewardOption rewardOption);

    //리워드 결제 관리 테이블 인서트
    public int rewardPaymentsInsert(PaymentResult paymentResult);

    //프로젝트 달성 금액, 달성률 업데이트
    public int projectAchievementMoney(String rewardProjectCode);

    //포인트 사용 내역 인서트.
    public int usePointLogInsert(PaymentResult paymentResult);

    //포인트 적립 내역 인서트
    public int savePointLogInsert(PaymentResult paymentResult);

    //포인트 사용 시 보유 포인트에서 차감
    public int customerUsePoint(PaymentResult paymentResult);

    //쿠폰 사용 내역 인서트
    public int useCouponLogInsert (PaymentResult paymentResult);

    //사용한 쿠폰 사용했음으로 업데이트
    public int usedCouponUpdate (String couponIssueCode);


}
