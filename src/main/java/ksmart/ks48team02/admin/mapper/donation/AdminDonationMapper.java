package ksmart.ks48team02.admin.mapper.donation;

import ksmart.ks48team02.admin.dto.donation.Donation;
import ksmart.ks48team02.admin.dto.donation.DonationJudgementReason;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDonationMapper {

    public List<Donation> getDonationList();

    public void judgementApprove(String donationCode);
    public void judgementReject(String donationCode , String judgeRejectReason, String judgeRejectReasonDetail, String adminId);
    public List<DonationJudgementReason> judgementReason();
}
