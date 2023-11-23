package ksmart.ks48team02.user.service.mypage;


import ksmart.ks48team02.user.dto.MypageReward;
import ksmart.ks48team02.user.mapper.mypage.MypageRewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MypageRewardService {

    private final MypageRewardMapper mypageRewardMapper;
    //리워드 주문, 결제 정보 조회.
    public MypageReward rewardOrderInfo (String orderCode){
        MypageReward mypageReward = mypageRewardMapper.rewardOrderInfo(orderCode);

        return mypageReward;
    }

    public void orderCancel (MypageReward orderInfo){
        // 주문 테이블 업데이트
        mypageRewardMapper.orderCancel(orderInfo);
        // 환불 테이블 인서트
        mypageRewardMapper.refundInsert(orderInfo);
        //결제 테이블 업데이트
        mypageRewardMapper.paymentUpdate(orderInfo);
    }
}
