package ksmart.ks48team02.admin.mapper.coupon;

import ksmart.ks48team02.admin.dto.coupon.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCouponMapper {
    List<Coupon> getCouponList();
}
