package ksmart.ks48team02.admin.mapper.coupon;

import ksmart.ks48team02.admin.dto.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCouponMapper {

    //전체 쿠폰 조회
    public List<Coupon> getCouponList();

    //회원 아이디 별 보유 쿠폰목록 조회
    public List<Coupon> MemberHaveCouponById(String memberId);

    // 특정 쿠폰 조회
    public List<Coupon> getCouponCodeById(String couponCode);

}
