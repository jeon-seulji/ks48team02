package ksmart.ks48team02.seller.service.investment;

import ksmart.ks48team02.seller.mapper.investment.SellerInvestmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ksmart.ks48team02.seller.dto.SellerLawSatistifyReason;
import java.util.List;

@Service("sellerInvestmemtService")
@Transactional
public class InvestmentService {

    // DI(의존성 주입)
    private final SellerInvestmentMapper sellerInvestmentMapper;

    // 생성자메소드를 통한 DI
    public InvestmentService(SellerInvestmentMapper sellerInvestmentMapper){

        this.sellerInvestmentMapper = sellerInvestmentMapper;
    }

    public List<SellerLawSatistifyReason> getLawSatistify() {
        List<SellerLawSatistifyReason> lawSatistifyReasonList = sellerInvestmentMapper.getLawSatistify();

        return  lawSatistifyReasonList;
    }
}
