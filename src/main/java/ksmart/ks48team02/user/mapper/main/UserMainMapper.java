package ksmart.ks48team02.user.mapper.main;

import ksmart.ks48team02.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMainMapper {

    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory);

    /**
     * get reward list for main
     * @return rewardPrjList
     */
    public List<RewardProject> getRewardPrjList();

    /**
     * get donation list for main
     * @return donationPrjList
     */
    public List<DonationRegistration> getDonationPrjList();

    /**
     * get investment list for main
     * @return investPrjList
     */
    public List<InvestmentInfo> getInvestPrjList();

    public List<StoreProject> getStorePrjList();
}
