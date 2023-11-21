package ksmart.ks48team02.user.service.mypage;


import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.RewardOrderDetail;
import ksmart.ks48team02.common.mapper.order.OrderMapper;
import ksmart.ks48team02.common.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MypageService {

    private final OrderMapper orderMapper;

    // 마이페이지 내 주문 내역 조회
    public List<OrderTotal> mypageOrderList (String memberId) {
        List<OrderTotal> mypageOrderList = orderMapper.mypageOrderList(memberId);

        //프로젝트가 리워드 이면 주문 상세 같이 조회
        mypageOrderList.forEach((option)->{
            String orderCode = option.getOrderCode();
            String projectCode = option.getGoodsCode();
            if(projectCode.contains("rwd") || projectCode.contains("RWD")) {
                List<RewardOrderDetail> rewardOrderDetailList = orderMapper.mypageOrderDetailList(orderCode);
                option.setRewardOrderDetailList(rewardOrderDetailList);
            }
        });


        return mypageOrderList;
    }

}
