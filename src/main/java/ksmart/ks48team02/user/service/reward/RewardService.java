package ksmart.ks48team02.user.service.reward;


import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.RewardOption;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.mapper.reward.RewardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class RewardService {

    //DI 의존성 추가
    private final RewardMapper rewardMapper;

    public RewardService(RewardMapper rewardMapper){
        this.rewardMapper =rewardMapper;
    }

    //주문 회원 정보 조회
    public Member getOrderMemberInfo (String memberId){
        Member orderMemberInfo = rewardMapper.getOrderMemberInfo(memberId);

        return orderMemberInfo;
    }

    //리워드 등록 하기
    public int addRewardProject (RewardProject rewardProject){
        int addReward = rewardMapper.addRewardProject(rewardProject);
        String rewardProjectCode = rewardProject.getRewardProjectCode();
        List<RewardOption> optionList = rewardProject.getRewardOptionList();

        optionList.forEach(option -> {

            option.setRewardProjectCode(rewardProjectCode);
            rewardMapper.rewardOptionAdd(option);
        });
        //insert 작업
        return addReward;
    }




}
