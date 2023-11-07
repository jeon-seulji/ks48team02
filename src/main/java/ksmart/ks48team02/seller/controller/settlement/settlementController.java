package ksmart.ks48team02.seller.controller.settlement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerSettlementController")
@RequestMapping("/seller/settlement")
public class settlementController {
    @GetMapping(value = {"","/"})
    public String sellerSettlementPage(Model model){

        model.addAttribute("title","판매자 : 정산 대시보드");
        model.addAttribute("contentsTitle","정산 대시보드");
        model.addAttribute("contentsSubTitle","정산 신청 전체 항목");
        return "seller/settlement/main";
    }
    @GetMapping("/addSettlement")
    public String sellerInfoRemove(Model model){
        model.addAttribute("title","판매자 : 정산 신청");
        model.addAttribute("contentsTitle","정산 신청");
        model.addAttribute("contentsSubTitle","펀딩 성공한 프로젝트만 정산 신청할 수 있습니다");
        return "seller/settlement/addSettlement";
    }
    // 정산 신청 정보 수정
    @GetMapping("/applicationRemove")
    public String sellerSettlementApplecationRemove(Model model){
        model.addAttribute("title","판매자 : 정산 신청 정보 수정");
        model.addAttribute("contentsTitle","정산 신청 정보 수정");
        model.addAttribute("contentsSubTitle","처리중 상태의 정산 신청은 정산 정보를 수정할 수 없습니다");
        return "seller/settlement/remove_settlement_object";
    }
    // 정산 신청 정보 입력
    @GetMapping("/addSettlement/info")
    public String sellerSettlementAdd(Model model){
        model.addAttribute("title","판매자 : 정산 신청 정보 입력");
        model.addAttribute("contentsTitle","정산 신청 정보 입력");
        model.addAttribute("contentsSubTitle","입력한 정산 정보 수정은 신청 정보 수정 페이지에서 수정 가능합니다");
        return "seller/settlement/addSettlementDetail";
    }
}
