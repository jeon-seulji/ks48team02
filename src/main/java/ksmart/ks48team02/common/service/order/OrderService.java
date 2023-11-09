package ksmart.ks48team02.common.service.order;

import ksmart.ks48team02.common.dto.order.OrderTotal;
import ksmart.ks48team02.common.mapper.order.OrderMapper;
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

    // 특정 주문 조회
    public OrderTotal getOrderInfoById(String orderCode){
        OrderTotal OrderInfoById = null;
        OrderInfoById = orderMapper.getOrderInfoById(orderCode);
        return OrderInfoById;
    }

}
