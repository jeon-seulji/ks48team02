package ksmart.ks48team02.common.service.delivery;

import ksmart.ks48team02.common.mapper.delivery.DeliveryMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeliveryService {
    // DI 의존성 주입
    private final DeliveryMapper deliveryMapper;

    public DeliveryService(DeliveryMapper deliveryMapper){
        this.deliveryMapper = deliveryMapper;
    }
    // 배송 목록 조회
    public Map<String, Object> getDeliveryList(Map<String, Object> paramMap){
        Map<String, Object> resultMap = null;

//        if(paramMap != null){
//
//        }

        return null;


    }
}
