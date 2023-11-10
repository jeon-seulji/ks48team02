package ksmart.ks48team02.user.service.donation;

import ksmart.ks48team02.admin.dto.donation.DonationInfo;
import ksmart.ks48team02.user.dto.donation.CategoryAndCompany;
import ksmart.ks48team02.user.dto.donation.DonationRegistration;
import ksmart.ks48team02.user.mapper.donation.DonationUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
