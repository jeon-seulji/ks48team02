package ksmart.ks48team02.user.service.main;

import ksmart.ks48team02.user.dto.DonationRegistration;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import ksmart.ks48team02.user.dto.OrderRank;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.mapper.main.UserMainMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMainService {

    // DI (의존성 주입)
    private final UserMainMapper userMainMapper;

    public UserMainService(UserMainMapper userMainMapper){
        this.userMainMapper = userMainMapper;
    }

    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory){
        List<OrderRank> rankList = userMainMapper.getRankList(rankCategory);
        return rankList;
    }


    /**
     * get reward list for main
     * @return rewardPrjList
     */
    public List<RewardProject> getRewardPrjList(){
        List<RewardProject> rewardPrjList = userMainMapper.getRewardPrjList();
        return rewardPrjList;
    }

    /**
     * get donation list for main
     * @return donationPrjList
     */
    public List<DonationRegistration> getDonationPrjList(){
      List<DonationRegistration> donationPrjList= userMainMapper.getDonationPrjList();
      return donationPrjList;
    };

    /**
     * get investment list for main
     * @return investPrjList
     */
    public List<InvestmentInfo> getInvestPrjList(){
        List<InvestmentInfo> investPrjList = userMainMapper.getInvestPrjList();
        return investPrjList;
    }

}
