package ksmart.ks48team02.user.controller.mypage;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.MypageReward;
import ksmart.ks48team02.user.service.mypage.MypageRewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("mypageRefundController")
@RequestMapping("/user/mypage/refund")
@AllArgsConstructor
public class MypageRefundController {

    private final MypageRewardService mypageRewardService;

    //환불 페이지
    @GetMapping(value={"","/"})
    public String refundMainPage(){

        return"user/mypage/refund/main";
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


        return"user/mypage/cancel/main";
    }

    //취소 진행
    @PostMapping("/cancel")
    @ResponseBody
    public String orderCancel(@RequestBody MypageReward orderInfo){

        System.out.println("ajax");
        System.out.println(orderInfo);

        mypageRewardService.orderCancel(orderInfo);

        return"redirect:/user/mypage";
    }
}
