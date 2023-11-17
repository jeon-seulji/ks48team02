package ksmart.ks48team02.user.mapper.account;

import ksmart.ks48team02.user.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    // 회원가입
    public int addMember(Member member);

    // 회원아이디 중복체크
     public boolean idCheck(String memberId);
}
