package ksmart.ks48team02.user.controller.mypage;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.MypageReward;
import ksmart.ks48team02.user.service.mypage.MypageRewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("mypageRewardController")
@RequestMapping("/user/mypage/reward")
@AllArgsConstructor
public class MypageRewardController {

    private final MypageRewardService mypageRewardService;

    //환불 페이지
    @GetMapping(value={"","/"})
    public String refundMainPage(){

        return"user/mypage/reward/refund/main";
    }

    //취소 페이지
    @GetMapping("/cancel")
    public String cancelMainPage(Model model,
                                 HttpSession httpSession,
                                 @RequestParam(name="orderCode") String orderCode){

        String memberName = (String) httpSession.getAttribute("SNAME");
        MypageReward orderInfo = mypageRewardService.rewardOrderInfo(orderCode);
        model.addAttribute("memberName",memberName);
        model.addAttribute("orderInfo",orderInfo);


        return"user/mypage/reward/cancel/main";
    }

    //취소 진행
    @PostMapping("/cancel")
    @ResponseBody
    public String orderCancel(@RequestBody MypageReward orderInfo){

        System.out.println(orderInfo);
        mypageRewardService.orderCancel(orderInfo);

        return"/user/mypage";
    }

    //구매 확정 진행
    @GetMapping("/orderConfirm")
    public String OrderConfirm (@RequestParam(name="orderCode", required = true) String orderCode) {

        return "redirect:/user/mypage";
    }

    //결제, 환불, 취소 내역 페이지
    @GetMapping("/detailInfo")
    public String detailPage(@RequestParam(name="orderCode", required = true) String orderCode) {


        return "user/mypage/reward/detailInfo";
    }


}
