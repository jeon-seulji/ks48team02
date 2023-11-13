package ksmart.ks48team02.user.service.account;

import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.mapper.account.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
    // DI(의존성 주입)
    private final AccountMapper accountMapper;

    // 생성자메소드를 통한 DI
    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    /**
     * 회원가입
     * @param member (회원정보)
     * @return
     */
    public void addMember(Member member) {
        accountMapper.addMember(member);
    }

    /**
     * 아이디 중복체크
     * @param memberId (회원아이디)
     * @return 중복: true, 중복x: false (boolean)
     */
    public boolean idCheck(String memberId) {
        boolean isDuplicate = accountMapper.idCheck(memberId);
        return isDuplicate;
    }


}
