package ksmart.ks48team02.admin.mapper.inquiry;
import ksmart.ks48team02.admin.dto.Inquiry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {

    // 문의 관리 목록 조회
    public List<Inquiry> getInquiryList();

}
