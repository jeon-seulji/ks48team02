package ksmart.ks48team02.seller.service.reward;


import ksmart.ks48team02.seller.mapper.reward.SellerRewardMapper;
import ksmart.ks48team02.user.dto.RewardProject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SellerRewardService {

    SellerRewardMapper sellerRewardMapper;

    public List<RewardProject> projectListBySellerID (String sellerId){

        List<RewardProject> projectList = sellerRewardMapper.projectListBySellerID(sellerId);

        return projectList;
    }

    public List<RewardProject> getNewsListBySellerId (String sellerId) {

        List<RewardProject> newsListPerProject = sellerRewardMapper.getNewsListBySellerId(sellerId);
        System.out.println(newsListPerProject);

        return newsListPerProject;
    }
}
