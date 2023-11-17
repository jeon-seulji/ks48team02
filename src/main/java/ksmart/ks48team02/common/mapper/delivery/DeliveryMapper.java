package ksmart.ks48team02.common.mapper.delivery;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface DeliveryMapper {

    // 배송 목록 조회
    public Map<String, Object> getDeliveryList(Map<String, Object> paramMap);
}
