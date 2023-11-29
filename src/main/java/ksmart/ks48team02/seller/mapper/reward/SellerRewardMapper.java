package ksmart.ks48team02.seller.mapper.reward;

import ksmart.ks48team02.user.dto.RewardProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SellerRewardMapper {

    //로그인 한 회원 아이디 별 프로젝트 조회
    public List<RewardProject> projectListBySellerID(Map<String,Object> inquirMap);

    //프로젝트 전체 행의 갯수
    public int projectPageCnt(Map<String,Object> inquirMap);

    //로그인 한 회원 아이디 별 새소식 조회
    public List<RewardProject> getNewsListBySellerId (String sellerId);

    //프로젝트 시작하기.
    public void startProject(String rewardProjectCode);

    /**
     * get project info by project code
     * @param projectCode
     * @return
     */
    public RewardProject getRwdPrjInfoByCode(String projectCode);

}
