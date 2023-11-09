package ksmart.ks48team02.user.service.order;

import ksmart.ks48team02.user.dto.order.OrderTotal;
import ksmart.ks48team02.user.mapper.order.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    // DI 의존성 추가
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    // 주문 목록 조회
    public List<OrderTotal> getOrderList(){
        List<OrderTotal> orderList = null;
        orderList = orderMapper.getOrderList();
        return orderList;
    }


}
