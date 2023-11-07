package ksmart.ks48team02.user.mapper.donation;

import ksmart.ks48team02.user.dto.donation.DonationRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationRegistrationMapper {

    public int addDonation(DonationRegistration donationRegistration);

}
