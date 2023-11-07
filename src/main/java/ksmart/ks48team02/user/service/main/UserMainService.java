package ksmart.ks48team02.user.service.main;

import ksmart.ks48team02.user.dto.main.OrderRank;
import ksmart.ks48team02.user.mapper.main.UserMainMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserMainService {

    // DI (의존성 주입)
    private final UserMainMapper userMainMapper;

    public UserMainService(UserMainMapper userMainMapper){
        this.userMainMapper = userMainMapper;
    }

    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory){
        List<OrderRank> rankList = null;
        rankList = userMainMapper.getRankList(rankCategory);
        return rankList;
    }
}
