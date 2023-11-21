package ksmart.ks48team02.admin.service.inquiry;

import ksmart.ks48team02.admin.dto.Inquiry;
import ksmart.ks48team02.admin.mapper.inquiry.InquiryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class InquiryService {

    public InquiryService(InquiryMapper inquiryMapper){
        this.inquiryMapper = inquiryMapper;
    }

    @Autowired
    private InquiryMapper inquiryMapper;

    // 문의 관리 목록 조회
    public List<Inquiry> getInquiryList(){

        return inquiryMapper.getInquiryList();
    }

}
