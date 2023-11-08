package ksmart.ks48team02.admin.controller.orderManagement;

import ksmart.ks48team02.user.controller.MainController;
import ksmart.ks48team02.user.dto.order.Order;
import ksmart.ks48team02.user.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("adminOrderManagement")
@RequestMapping("/admin/order")
public class OrderManagementController {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private final OrderService orderService;

    public OrderManagementController(OrderService orderService){
        this.orderService = orderService;
    }

    // 주문 대시보드
    @GetMapping(value = {"","/"})
    public String adminOrderDashBoard(Model model){
        model.addAttribute("title","관리자 : 주문 대시보드");
        model.addAttribute("contentsTitle","주문 대시보드");
        model.addAttribute("contentsSubTitle","관리자 주문 대시보드");
        return "";
    }
    // 주문 목록
    @GetMapping( "/list")
    public String adminOrderList(Model model){
        model.addAttribute("title","관리자 : 주문 목록");
        model.addAttribute("contentsTitle","주문 목록");
        model.addAttribute("contentsSubTitle","관리자 주문 전체 목록");

        List<Order> OrderList = orderService.getOrderList();
        log.info("주문 목록 : {}", OrderList);

        model.addAttribute("OrderList", OrderList);

        return "admin/order/list";
    }
    // 주문 목록
    @GetMapping( "/detail")
    public String adminOrderDetail(Model model){
        model.addAttribute("title","관리자 : 주문 상세");
        model.addAttribute("contentsTitle","주문 상세");
        model.addAttribute("contentsSubTitle","관리자 주문 상세");
        return "admin/order/orderDetailInfo";
    }
    // 배송 관리
    @GetMapping( "/delivery")
    public String adminOrderDelivery(Model model){
        model.addAttribute("title","관리자 : 배송 관리");
        model.addAttribute("contentsTitle","배송 관리");
        model.addAttribute("contentsSubTitle","관리자 배송 관리");
        return "admin/order/delivery";
    }
    // 배송 정보
    @GetMapping( "/delivery/detail")
    public String adminOrderDeliveryInfo(Model model){
        model.addAttribute("title","관리자 : 배송 정보");
        model.addAttribute("contentsTitle","배송 정보");
        model.addAttribute("contentsSubTitle","관리자 배송 정보");
        return "admin/order/deliveryDetailInfo";
    }
    // 교환 환불 신청 관리
    @GetMapping( "/refundSwapping")
    public String adminOrderRefundSwapping(Model model){
        model.addAttribute("title","관리자 : 교환 환불 관리");
        model.addAttribute("contentsTitle","교환/환불 관리");
        model.addAttribute("contentsSubTitle","관리자 교환/환불 관리");
        return "admin/order/refundSwapping";
    }

    // 주문 확정 목록 조회
    @GetMapping( "/completedList")
    public String adminOrderCompletedList(Model model){
        model.addAttribute("title","관리자 : 주문 확정 목록");
        model.addAttribute("contentsTitle","주문 확정 목록");
        model.addAttribute("contentsSubTitle","관리자 주문 확정 목록");
        return "admin/order/orderCompletedList";
    }
}
