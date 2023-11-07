package ksmart.ks48team02.admin.service.donation;

import ksmart.ks48team02.admin.dto.donation.Donation;
import ksmart.ks48team02.admin.mapper.donation.AdminDonationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminDonationService {

    private final AdminDonationMapper adminDonationMapper;

    public AdminDonationService(AdminDonationMapper adminDonationMapper){
        this.adminDonationMapper = adminDonationMapper;
    }

    public List<Donation> getDonationList(){
        List<Donation> donationList = adminDonationMapper.getDonationList();

        return donationList;
    }

}
