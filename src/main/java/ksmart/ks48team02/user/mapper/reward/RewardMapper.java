package ksmart.ks48team02.user.mapper.reward;


import ksmart.ks48team02.common.dto.OrderTotal;
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

    //리워드 옵션 등록
    public int rewardOptionAdd (RewardOption rewardOption);

    //리워드프로젝트 전체 조회.
    public List<RewardProject> rewardProjectList();

    //리워드 프로젝트 상세 페이지
    public RewardProject rewardProjectDetail(String rewardProjectCode);

    //주문번호, 주문상세번호, 결제번호 생성.
    public OrderTotal getOrderAndPaymentCode();



}
