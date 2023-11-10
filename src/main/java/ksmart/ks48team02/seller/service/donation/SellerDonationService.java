package ksmart.ks48team02.seller.service.donation;

import ksmart.ks48team02.admin.dto.donation.Donation;
import ksmart.ks48team02.seller.dto.donation.DonationList;
import ksmart.ks48team02.seller.mapper.donation.SellerDonationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SellerDonationService {
    SellerDonationMapper sellerDonationMapper;

    // 판매자 자기 자신의 프로젝트 목록을 가져오는 함수
    public List<DonationList> getDonationProjectList(String memberId){
        List<DonationList> donationList = sellerDonationMapper.getDonationProjectList();
        List<DonationList> getCurIdList = new ArrayList<DonationList>();
        for (DonationList dl : donationList){
            if(dl.getMemberId().equals(memberId)){
                getCurIdList.add(dl);
            }
        }
        return getCurIdList;
    }

    public void startProject(String donationCode){
        sellerDonationMapper.startProject(donationCode);
    }

}
