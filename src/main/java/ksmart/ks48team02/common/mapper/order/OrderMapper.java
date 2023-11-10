package ksmart.ks48team02.common.mapper.order;


import ksmart.ks48team02.common.dto.OrderTotal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 주문 목록 조회
    public List<OrderTotal> getOrderList(String orderby);

    // 특정 주문 조회
    public OrderTotal getOrderInfoById(String orderCode);

}
