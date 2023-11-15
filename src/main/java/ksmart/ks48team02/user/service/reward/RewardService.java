package ksmart.ks48team02.user.service.reward;


import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.RewardOption;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.mapper.reward.RewardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class RewardService {

    //DI 의존성 추가
    private final RewardMapper rewardMapper;

    public RewardService(RewardMapper rewardMapper){
        this.rewardMapper =rewardMapper;
    }

    //주문 회원 정보 조회
    public Member getOrderMemberInfo (String memberId){
        Member orderMemberInfo = rewardMapper.getOrderMemberInfo(memberId);

        return orderMemberInfo;
    }

    //리워드 등록 하기
    public int addRewardProject (RewardProject rewardProject){
        int addReward = rewardMapper.addRewardProject(rewardProject);
        String rewardProjectCode = rewardProject.getRewardProjectCode();
        List<RewardOption> optionList = rewardProject.getRewardOptionList();

        optionList.forEach(option -> {

            option.setRewardProjectCode(rewardProjectCode);
            rewardMapper.rewardOptionAdd(option);
        });
        //insert 작업
        return addReward;
    }


    //리워드프로젝트 전체 조회.
    public List<RewardProject> rewardProjectList (){
        List<RewardProject> projectList = rewardMapper.rewardProjectList();

        return projectList;
    }

    //리워드 프로젝트 상세 페이지
     public RewardProject rewardProjectDetail(String rewardProjectCode){

        RewardProject rewardProject =rewardMapper.rewardProjectDetail(rewardProjectCode);

        return rewardProject;
     }

     //주문번호, 주문상세번호, 결제번호 생성
    public OrderTotal getOrderAndPaymentCode(){
        OrderTotal orderAndPaymentCode = rewardMapper.getOrderAndPaymentCode();

        return orderAndPaymentCode;
    }

    //주문 진행
    public void rewardProjectPay(PaymentResult paymentResult){
        String orderCode = paymentResult.getOrderCode();
        List<RewardOption> rewardOptionList = paymentResult.getRewardOptionList();

        //통합 주문 테이블 인서트
        rewardMapper.orderTableInsert(paymentResult);
        System.out.println("통합주문테이블 등록 완료");

        //리워드 주문 상세 테이블 인서트
        rewardOptionList.forEach(option ->{
            option.setOrderCode(orderCode);
            rewardMapper.rewardOrderDetailInsert(option);
        });

        System.out.println("주문상세테이블 등록 완료");
        //결제 테이블 인서트
        rewardMapper.rewardPaymentsInsert(paymentResult);
        System.out.println("결제테이블 등록 완료");

        if( paymentResult.getUsePoint() > 0) {
            //포인트 사용 내역 인서트
            rewardMapper.usePointLogInsert(paymentResult);
            //포인트 사용 시 포인트 차감.
            rewardMapper.customerUsePoint(paymentResult);
            System.out.println("포인트사용 로그 등록 완료");
        }

        if(paymentResult.getUseCouponCode() != null) {

            // 쿠폰 사용 내역 인서트
            rewardMapper.useCouponLogInsert(paymentResult);
            System.out.println("쿠폰등록 완료");

            //쿠폰 사용 시 보유 쿠폰 사용했음으로 업데이트.
            rewardMapper.usedCouponUpdate(paymentResult);
            System.out.println("쿠폰사용 로그 등록 완료");
        }

    }
}
