package ksmart.ks48team02.admin.controller.orderManagement;

import ksmart.ks48team02.common.dto.DonationPayments;
import ksmart.ks48team02.common.dto.InvestPayments;
import ksmart.ks48team02.common.dto.RewardPayments;
import ksmart.ks48team02.user.controller.MainController;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.service.order.OrderService;
import ksmart.ks48team02.common.service.payments.PaymentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminOrderManagement")
@RequestMapping("/admin/order")
public class OrderManagementController {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private final OrderService orderService;
    private final PaymentsService paymentsService;

    public OrderManagementController(OrderService orderService,
                                     PaymentsService paymentsService){

        this.orderService = orderService;
        this.paymentsService = paymentsService;
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
    public String adminOrderList(Model model,
                                 @RequestParam(name="orderby",
                                 required = false,
                                 defaultValue = "order_d") String orderby){
        model.addAttribute("title","관리자 : 주문 목록");
        model.addAttribute("contentsTitle","주문 목록");
        model.addAttribute("contentsSubTitle","관리자 주문 전체 목록");

        // 주문 목록 진열
        List<OrderTotal> OrderList = orderService.getOrderList(orderby);
        log.info("주문 목록 : {}", OrderList);
        model.addAttribute("OrderList", OrderList);

        return "admin/order/list";
    }

    // 주문 목록 정렬 ajax
    @PostMapping(value="/ajax/list")
    @ResponseBody
    public List<OrderTotal> getOrderListOrderBy(Model mode,
                                                @RequestParam(name="orderby",
                                                        required = false,
                                                        defaultValue = "order_d") String orderby){
        List<OrderTotal> list = orderService.getOrderList(orderby);
        System.out.println(list);
        return list;
    }
    // 주문 상세
    @GetMapping( "/detail")
    public String adminOrderDetail(Model model,
                                   @RequestParam(name="orderCode") String orderCode,
                                   @RequestParam(name="goodsPartition") String goodsPartition){
        log.info("주문 코드 {}", orderCode);

        // 주문 상세 조회
        OrderTotal OrderInfoById = orderService.getOrderInfoById(orderCode);
        log.info("주문 상세 조회 {}", OrderInfoById);

        model.addAttribute("OrderInfoById", OrderInfoById);

        // 주문 분류 모델 (필요 없으니 나중에 체크)
        String orderPartition = OrderInfoById.getGoodsCode();
        orderPartition = orderPartition.substring(0,3);
        log.info("orderPartition {}", orderPartition);
        model.addAttribute("orderPartition", orderPartition);

        // 특정 결제 정보 조회
        switch(goodsPartition){
            case "rwd":
                RewardPayments getRewardPaymentsById = paymentsService.getRewardPaymentsById(orderCode);
                log.info("paymentsInfo {}", getRewardPaymentsById);
                model.addAttribute("paymentsInfo", getRewardPaymentsById);
                break;
            case "don":
                DonationPayments getDonationPaymentsById = paymentsService.getDonationPaymentsById(orderCode);
                log.info("paymentsInfo {}", getDonationPaymentsById);
                model.addAttribute("paymentsInfo", getDonationPaymentsById);
                break;
            case "inv":
                InvestPayments getInvestPaymentsById = paymentsService.getInvestPaymentsById(orderCode);
                log.info("paymentsInfo {}", getInvestPaymentsById);
                model.addAttribute("paymentsInfo", getInvestPaymentsById);
                break;
        }

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
