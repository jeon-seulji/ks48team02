package ksmart.ks48team02.user.mapper.reward;


import ksmart.ks48team02.user.dto.reward.RewardCustomerRank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RewardMapper {


    //회원 등급 별 적립률, 할인율 조회
    public RewardCustomerRank getRankById(String memberId);



}
