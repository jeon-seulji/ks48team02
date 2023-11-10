package ksmart.ks48team02.seller.mapper.donation;

import ksmart.ks48team02.seller.dto.donation.DonationList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerDonationMapper {
    public List<DonationList> getDonationProjectList();
    public void startProject(String donationCode);

}
