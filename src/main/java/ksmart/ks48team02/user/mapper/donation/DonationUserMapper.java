package ksmart.ks48team02.user.mapper.donation;

import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DonationUserMapper {
    public int addDonation(DonationRegistration donationRegistration);
    public DonationInfo getDonationInfo(String donationCode);
    public CategoryAndCompany getCateAndCompany(String donationCode);
    public List<AllDonationInfo> getAllDonationInfo();
    public String getCondition(String donationCode);
    public List<NewsList> getNewsList(String donationCode);
    public NewsList getDetailNews(String newsCode);
    public CommentMember getMember(String memberId);
    public void CommentAdd(String memberId, String donationCode,String memberName,String commentContent);
    public List<DonationCommentList> getCommentList(String donationCode);
    public void replyAdd(String reply, String donationCode, String parentCommentCode, String memberId, String memberName);

}
