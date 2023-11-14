package ksmart.ks48team02.common.mapper.order;


import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.SearchSelectDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 주문 목록 조회
    public List<OrderTotal> getOrderList(@Param("orderby") String orderby,
                                         @Param("startRowNum") int startRowNum,
                                         @Param("rowPerPage") int rowPerPage);

    // 전체 주문 목록 행 조회
    public int getOrderCnt(String orderby);

    // 특정 주문 조회
    public OrderTotal getOrderInfoById(String orderCode);

    public List<OrderTotal> adminOrderSearchAjax(SearchSelectDto searchForm);
}
