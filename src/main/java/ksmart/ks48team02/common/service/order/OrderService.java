package ksmart.ks48team02.common.service.order;

import ksmart.ks48team02.admin.controller.orderManagement.OrderManagementController;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.RefundApplication;
import ksmart.ks48team02.common.dto.RewardOrderDetail;
import ksmart.ks48team02.common.dto.SwappingApplication;
import ksmart.ks48team02.common.mapper.order.OrderMapper;
import ksmart.ks48team02.user.dto.RewardOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(OrderManagementController.class);

    // DI 의존성 추가
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    /**
     * 주문 목록 조회
     * currentPage - limit 행 수
     * rowPerPage - 조회하고자 하는 페이지 수
     * */
    public Map<String, Object> getOrderList(Map<String, Object> paramMap){

        Map<String, Object> resultMap = null;

        if(paramMap != null){
            String orderby = (String) paramMap.get("orderby");
            Object currentPageObj = paramMap.get("currentPage");
            Object rowPerPageObj = paramMap.get("rowPerPage");

            int currentPage = 0;
            int rowPerPage = 0;

            if (currentPageObj != null) {
                try {
                    double currentPageDouble = Double.parseDouble(currentPageObj.toString());
                    currentPage = (int) currentPageDouble;
                    double rowPerPageDouble = Double.parseDouble(rowPerPageObj.toString());
                    rowPerPage = (int) rowPerPageDouble;
                } catch (NumberFormatException e) {
                    // currentPageObj가 숫자로 변환될 수 없는 경우의 예외 처리
                    System.out.println(e);
                }
            }


            // 행의 시작점
            int startRowNum = (currentPage - 1) * rowPerPage; // (1 - 1) * 15 = 0

            // 전체 행의 갯수
            double rowCnt = orderMapper.getOrderCnt(paramMap);

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

    // 특정 주문 조회
    public OrderTotal getOrderInfoById(String orderCode){
        OrderTotal OrderInfoById = null;
        OrderInfoById = orderMapper.getOrderInfoById(orderCode);
        return OrderInfoById;
    }

    // 주문 코드에 따른 주문 상세 조회
    public List<RewardOrderDetail> getRewardOptionByOrderCode(String orderCode){
        List<RewardOrderDetail> getRewardOptionByOrderCode = null;
        getRewardOptionByOrderCode = orderMapper.getRewardOptionByOrderCode(orderCode);
        return getRewardOptionByOrderCode;
    }

    /**
     * 환불 목록 조회
     * @param paramMap
     * @return
     */
    public Map<String, Object> getApplicationList(Map<String, Object> paramMap){
        Map<String, Object> resultMap = null;

        if(paramMap != null){
            String orderby = (String) paramMap.get("orderby");
            Object currentPageObj = paramMap.get("currentPage");
            Object rowPerPageObj = paramMap.get("rowPerPage");

            int currentPage = 0;
            int rowPerPage = 0;

            if (currentPageObj != null) {
                try {
                    double currentPageDouble = Double.parseDouble(currentPageObj.toString());
                    currentPage = (int) currentPageDouble;
                    double rowPerPageDouble = Double.parseDouble(rowPerPageObj.toString());
                    rowPerPage = (int) rowPerPageDouble;
                } catch (NumberFormatException e) {
                    // currentPageObj가 숫자로 변환될 수 없는 경우의 예외 처리
                    System.out.println(e);
                }
            }

            // 행의 시작점
            int startRowNum = (currentPage - 1) * rowPerPage; // (1 - 1) * 15 = 0

            // 전체 행의 갯수
            double rowCnt = orderMapper.getRfndCnt(paramMap);

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


            String pageValue = (String) paramMap.get("pageValue");
            log.info("pageValue {}", pageValue);



            if(pageValue.equals("refund")){

                List<RefundApplication> list = null;
                list = orderMapper.getRefundApplicationList(paramMap);
                resultMap.put("list", list); // 조회 객체

            } else if(pageValue.equals("swapping")){

                List<SwappingApplication> list = null;
                list = orderMapper.getSwapApplicationList(paramMap);
                log.info("list {}", list);
                resultMap.put("list", list); // 조회 객체

            }

            resultMap.put("lastPage", lastPage); // 마지막 페이지
            resultMap.put("startPageNum", startPageNum); // 시작 페이지
            resultMap.put("currentPage", currentPage); // 현재 페이지
            resultMap.put("endPageNum", endPageNum); // 끝 페이지
        }

        log.info("resultMap {}", resultMap);
        return resultMap;

    }


}
