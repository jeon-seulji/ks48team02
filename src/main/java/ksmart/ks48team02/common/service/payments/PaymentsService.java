package ksmart.ks48team02.common.service.payments;

import ksmart.ks48team02.common.dto.payments.RewardPayments;
import ksmart.ks48team02.common.mapper.payments.PaymentsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {
    // DI 의존성 추가
    public final PaymentsMapper paymentsMapper;

    public PaymentsService(PaymentsMapper paymentsMapper){
        this.paymentsMapper = paymentsMapper;
    }

    // 리워드 결제 정보 목록 조회
    public List<RewardPayments> getRewardPayments(){
        List<RewardPayments> rewardPayments = null;
        rewardPayments = paymentsMapper.getRewardPayments();
        return rewardPayments;
    };

    // 특정 리워드 결제 정보 조회
    public RewardPayments getRewardPaymentsById(String orderCode){
        RewardPayments RewardPaymentsById = null;
        RewardPaymentsById = paymentsMapper.getRewardPaymentsById(orderCode);
        return RewardPaymentsById;
    }
}
