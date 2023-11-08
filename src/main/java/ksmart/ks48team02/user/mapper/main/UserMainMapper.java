package ksmart.ks48team02.user.mapper.main;

import ksmart.ks48team02.user.dto.main.OrderRank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMainMapper {

    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory);



}
