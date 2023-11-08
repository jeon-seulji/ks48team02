package ksmart.ks48team02.admin.service.coupon;

import ksmart.ks48team02.admin.dto.coupon.Coupon;
import ksmart.ks48team02.admin.mapper.coupon.AdminCouponMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminCouponService {
    // DI
    private final AdminCouponMapper adminCouponMapper;

    // 생성자 메소드를 통한 DI
    public AdminCouponService(AdminCouponMapper adminCouponMapper){
        this.adminCouponMapper = adminCouponMapper;
    }

    public List<Coupon> getCouponList(){
        List<Coupon> couponList = adminCouponMapper.getCouponList();

        return couponList;
    }
}
