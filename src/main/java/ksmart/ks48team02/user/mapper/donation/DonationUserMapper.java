package ksmart.ks48team02.user.mapper.donation;

import ksmart.ks48team02.admin.dto.donation.DonationInfo;
import ksmart.ks48team02.user.dto.donation.CategoryAndCompany;
import ksmart.ks48team02.user.dto.donation.DonationRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationUserMapper {

    public int addDonation(DonationRegistration donationRegistration);
    public DonationInfo getDonationInfo(String donationCode);
    public CategoryAndCompany getCateAndCompany(String donationCode);

}
