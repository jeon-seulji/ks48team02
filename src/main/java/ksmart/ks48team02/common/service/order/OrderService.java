package ksmart.ks48team02.common.service.order;

import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.mapper.order.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    // DI 의존성 추가
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    public Map<String, Object> getOrderList(Map<String, Object> paramMap){

        Map<String, Object> resultMap = null;

        if(paramMap != null){
            String orderby = (String) paramMap.get("orderbyValue");
//            int currentPage = (paramMap.get("currentPage") instanceof String)? Integer.parseInt((String) paramMap.get("currentPage"))
//                                                                             : (int) paramMap.get("currentPage");
//            int rowPerPage = (paramMap.get("rowPerPage") instanceof String)? Integer.parseInt((String) paramMap.get("rowPerPage"))
//                                                                           : (int) paramMap.get("rowPerPage");

            int currentPage =  (Integer) paramMap.get("currentPage");
            int rowPerPage =  (Integer) paramMap.get("rowPerPage");

            // 행의 시작점
            int startRowNum = (currentPage - 1) * rowPerPage; // (1 - 1) * 15 = 0

            // 전체 행의 갯수
            double rowCnt = orderMapper.getOrderCnt(orderby);

            // 마지막 페이지 수
            int lastPage = (int) Math.ceil(rowCnt / rowPerPage); // 25 / 15;

            // 보여줄 페이지 번호 초깃값
            int startPageNum = 1;

            // 마지막 페이지 번호
            int endPageNum = (lastPage < 10)? lastPage : lastPage * currentPage;

            paramMap.put("startRowNum", startRowNum);
            paramMap.put("rowCnt", rowCnt);
            paramMap.put("lastPage", lastPage);
            paramMap.put("startPageNum", startPageNum);
            paramMap.put("endPageNum", endPageNum);

            resultMap = new HashMap<String, Object>();

            List<OrderTotal> orderList = null;
            orderList = orderMapper.getOrderList(paramMap);

            resultMap.put("orderList", orderList); // 조회 객체
            resultMap.put("lastPage", lastPage); // 마지막 페이지
            resultMap.put("startPageNum", startPageNum); // 시작 페이지
            resultMap.put("currentPage", currentPage); // 현재 페이지
            resultMap.put("endPageNum", endPageNum); // 끝 페이지
        }


        return resultMap;
    }
    /*
    * currentPage - limit 행 수
    * rowPerPage - 조회하고자 하는 페이지 수
    * */
    // 주문 목록 조회
//    public Map<String, Object> getOrderList(String orderby, int currentPage, int rowPerPage){
//
//        // 행의 시작점
//        int startRowNum = (currentPage - 1) * rowPerPage; // (1 - 1) * 15 = 0
//
//        // 전체 행의 갯수
//        double rowCnt = orderMapper.getOrderCnt(orderby);
//
//        // 마지막 페이지 수
//        int lastPage = (int) Math.ceil(rowCnt / rowPerPage); // 25 / 15;
//
//        // 보여줄 페이지 번호 초깃값
//        int startPageNum = 1;
//
//        // 마지막 페이지 번호
//        int endPageNum = (lastPage < 10)? lastPage : lastPage * currentPage;
//
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//
//        List<OrderTotal> orderList = null;
//        orderList = orderMapper.getOrderList(searchForm);
//
//        resultMap.put("orderList", orderList); // 조회 객체
//        resultMap.put("lastPage", lastPage); // 마지막 페이지
//        resultMap.put("startPageNum", startPageNum); // 시작 페이지
//        resultMap.put("currentPage", currentPage); // 현재 페이지
//        resultMap.put("endPageNum", endPageNum); // 끝 페이지
//
//        return resultMap;
//    }

    // 특정 주문 조회
    public OrderTotal getOrderInfoById(String orderCode){
        OrderTotal OrderInfoById = null;
        OrderInfoById = orderMapper.getOrderInfoById(orderCode);
        return OrderInfoById;
    }

    // 주문 검색
    public List<OrderTotal> adminOrderSearchAjax(Map<String, Object> searchForm){
        List<OrderTotal> orderList = null;
        orderList = orderMapper.adminOrderSearchAjax(searchForm);
        return orderList;
    }

}
