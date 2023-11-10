package ksmart.ks48team02.user.mapper.donation;

import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.user.dto.DonationRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationUserMapper {

    public int addDonation(DonationRegistration donationRegistration);
    public DonationInfo getDonationInfo(String donationCode);

}
