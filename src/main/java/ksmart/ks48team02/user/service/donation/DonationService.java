package ksmart.ks48team02.user.service.donation;

import ksmart.ks48team02.user.dto.donation.DonationRegistration;
import ksmart.ks48team02.user.mapper.donation.DonationRegistrationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DonationService{
    private final DonationRegistrationMapper donationRegistrationMapper;
    public DonationService(DonationRegistrationMapper donationRegistrationMapper){
        this.donationRegistrationMapper = donationRegistrationMapper;
    }

    public void addDonation(DonationRegistration donationRegistration){
        int result = donationRegistrationMapper.addDonation(donationRegistration);
    }


}
