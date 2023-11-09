package ksmart.ks48team02.user.mapper.order;


import ksmart.ks48team02.user.dto.order.OrderTotal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 주문 목록 조회
    public List<OrderTotal> getOrderList();

    // 특정 주문 조회
    public OrderTotal getOrderInfoById(String orderCode);

}
