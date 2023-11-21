package ksmart.ks48team02.user.mapper.mypage;

import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.MypageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {
    public MypageDto getMemberInfoById(String memberId);
}
