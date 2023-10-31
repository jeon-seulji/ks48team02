package ksmart.ks48team02.seller.mapper.investment;

import ksmart.ks48team02.seller.dto.investment.SellerLawSatistifyReason;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerInvestmentMapper {

    // 자본시장법 범위충족기준 목록
    public List<SellerLawSatistifyReason> getLawSatistify();

}
