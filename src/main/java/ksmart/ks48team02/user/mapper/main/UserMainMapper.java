package ksmart.ks48team02.user.mapper.main;

import ksmart.ks48team02.user.dto.OrderRank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMainMapper {

    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory);



}
