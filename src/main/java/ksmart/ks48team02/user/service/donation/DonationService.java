package ksmart.ks48team02.user.service.donation;

import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.mapper.donation.DonationUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class DonationService{
    private final DonationUserMapper donationUserMapper;
    public DonationService(DonationUserMapper donationUserMapper){
        this.donationUserMapper = donationUserMapper;
    }

    public void addDonation(DonationRegistration donationRegistration){
        System.out.println(donationRegistration);
        int result = donationUserMapper.addDonation(donationRegistration);
    }
    public DonationInfo getDonationInfo(String donationCode){
        return donationUserMapper.getDonationInfo(donationCode);
    }

    public CategoryAndCompany getCateAndCompany(String donationCode){
        CategoryAndCompany cateAndCompany = donationUserMapper.getCateAndCompany(donationCode);
        return cateAndCompany;
    }

    public List<AllDonationInfo> getAllDonationInfo(){
        List<AllDonationInfo> allDonationInfo = donationUserMapper.getAllDonationInfo();
        return allDonationInfo;
    }

    public String getCondition(String donationCode){
        return donationUserMapper.getCondition(donationCode);
    }

    public List<NewsList> getNewsList(String donationCode){
        return donationUserMapper.getNewsList(donationCode);
    }

    public NewsList getDetailNews(String newsCode){
        return donationUserMapper.getDetailNews(newsCode);
    }

    public CommentMember getMember(String memberId){
        return donationUserMapper.getMember(memberId);
    }

    public void CommentAdd(String memberId, String donationCode,String memberName,String commentContent){
        donationUserMapper.CommentAdd(memberId, donationCode, memberName, commentContent);
    }

    public List<DonationCommentList> getCommentList(String donationCode){
        return donationUserMapper.getCommentList(donationCode);
    }

    public void replyAdd(String reply, String donationCode, String parentCommentCode, String memberId, String memberName){
        donationUserMapper.replyAdd(reply, donationCode, parentCommentCode, memberId, memberName);
    }


}
