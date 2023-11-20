package ksmart.ks48team02.user.service.mypage;


import ksmart.ks48team02.user.dto.MypageDto;
import ksmart.ks48team02.user.mapper.mypage.MypageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MypageService {
    private final MypageMapper mypageMapper;

    public MypageService(MypageMapper mypageMapper) {
        this.mypageMapper = mypageMapper;
    }

    public Map<String, Object> getMemberInfoById(String memberId){
        Map<String, Object> resultMap = new HashMap<>();
        MypageDto memberInfo = mypageMapper.getMemberInfoById(memberId);
        if(memberInfo != null){
            resultMap.put("memberEmail",memberInfo.getMemberEmail());
            resultMap.put("memberContactInfo", memberInfo.getMemberContactInfo());
        }
        return resultMap;
    }
}
