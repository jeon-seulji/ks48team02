package ksmart.ks48team02.seller.mapper.reward;

import ksmart.ks48team02.user.dto.RewardProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerRewardMapper {

    public List<RewardProject> projectListBySellerID(String sellerId);

    public List<RewardProject> getNewsListBySellerId (String sellerId);
}
