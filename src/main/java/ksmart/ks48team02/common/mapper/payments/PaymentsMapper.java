package ksmart.ks48team02.common.mapper.payments;

import ksmart.ks48team02.common.dto.payments.RewardPayments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentsMapper {

    // 리워드 결제 정보 목록 조회
    public List<RewardPayments> getRewardPayments();

    // 특정 리워드 결제 정보 목록 조회
    public RewardPayments getRewardPaymentsById(String orderCode);


}
