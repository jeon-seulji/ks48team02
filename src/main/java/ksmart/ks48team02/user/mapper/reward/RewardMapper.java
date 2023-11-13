package ksmart.ks48team02.user.mapper.reward;


import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.RewardOption;
import ksmart.ks48team02.user.dto.RewardProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RewardMapper {


    //주문 회원 정보 조회
    public Member getOrderMemberInfo(String memberId);

    //프로젝트 등록
    public int addRewardProject (RewardProject rewardProject);

    public int rewardOptionAdd (RewardOption rewardOption);




}
