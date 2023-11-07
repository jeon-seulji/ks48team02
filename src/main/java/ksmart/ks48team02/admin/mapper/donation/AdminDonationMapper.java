package ksmart.ks48team02.admin.mapper.donation;

import ksmart.ks48team02.admin.dto.donation.Donation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDonationMapper {

    public List<Donation> getDonationList();

}
