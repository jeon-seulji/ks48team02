package ksmart.ks48team02.user.mapper.mypage;

import ksmart.ks48team02.user.dto.MypageReward;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageRewardMapper {

    //리워드 주문, 결제 정보 조회.
    public MypageReward rewardOrderInfo (String orderCode);

    //리워드 주문 취소,환불,교환 시 주문 테이블 업데이트
    public int orderCancel(MypageReward orderInfo);

    //리워드 주문 취소,환불 시 환불 테이블 인서트
    public int refundInsert(MypageReward orderInfo);

    //리워드 주문 취소,환불,교환 시 결제 테이블 업데이트
    public int paymentUpdate(MypageReward orderInfo);

}
