package ksmart.ks48team02.user.mapper.reward;


import ksmart.ks48team02.user.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RewardMapper {


    //주문 회원 정보 조회
    public Member getOrderMemberInfo(String memberId);



}
