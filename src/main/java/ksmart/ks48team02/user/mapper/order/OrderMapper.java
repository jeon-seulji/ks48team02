package ksmart.ks48team02.user.mapper.order;


import ksmart.ks48team02.user.dto.order.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 주문 목록 조회
    public List<Order> getOrderList();
}
