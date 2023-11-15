package ksmart.ks48team02.user.controller.donation;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.donation.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller("userDonationController")
@RequestMapping("/user/donation")
public class DonationController {
    private final DonationService donationService;
    public DonationController(DonationService donationService){
        this.donationService = donationService;
    }

    @GetMapping(value = {"", "/"})
    public String mainPage(Model model){
        List<AllDonationInfo> allDonationInfo = donationService.getAllDonationInfo();
        model.addAttribute("allDonationInfo", allDonationInfo);

        return "user/donation/main";
    }

    @GetMapping("/detail")
    public String detailMainPage(@RequestParam(name = "donationCode") String donationCode,
                                 Model model){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);
      
        return "user/donation/detail/main";
    }

    @GetMapping("/detail/condition")
    public String detailConditionPage(Model model,
                                      @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        String conditionContents = donationService.getCondition(donationCode);
        model.addAttribute("conditionContents", conditionContents);

        return "user/donation/detail/condition";
    }

    @GetMapping("/detail/comment")
    public String detailCommentPage(Model model,
                                    @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        // getcomment 만들어서 댓글 가져오기.
        List<DonationCommentList> donationCommentList = donationService.getCommentList(donationCode);
        model.addAttribute("donationCommentList", donationCommentList);

        return "user/donation/detail/comment";
    }

    @PostMapping("/detail/comment")
    public String commentAdd(HttpSession session, Model model,
                             @RequestParam(name = "donationCode") String donationCode,
                             @RequestParam(name = "commentContent") String commentContent){
        String memberId = (String)session.getAttribute("SID");
        CommentMember commentMember = donationService.getMember(memberId);
        model.addAttribute("commentMember", commentMember);

        donationService.CommentAdd(memberId, donationCode, commentMember.getMemberName(), commentContent);

        return "redirect:/user/donation/detail/comment?donationCode=" + donationCode;
    }

    @PostMapping("/detail/reply")
    public String replyAdd(HttpSession session, Model model,
                             @RequestParam(name = "reply") String reply,
                           @RequestParam(name = "donationCode") String donationCode,
                             @RequestParam(name = "parentCommentCode") String parentCommentCode){
        String memberId = (String)session.getAttribute("SID");
        CommentMember commentMember = donationService.getMember(memberId);
        model.addAttribute("commentMember", commentMember);

        donationService.replyAdd(reply, donationCode, parentCommentCode, memberId, commentMember.getMemberName());
        System.out.println("@@@@@@@@@@@@@@@@@@@== " + parentCommentCode);


        return "redirect:/user/donation/detail/comment?donationCode=" + donationCode;
    }

    @GetMapping("/order")
    public String orderMainPage(){
        return "user/donation/order/main";
    }

    @GetMapping("/payment")
    public String paymentMainPage(){
        return "user/donation/payment/main";
    }

    @GetMapping("/payment/confirm")
    public String paymentConfirmPage(){
        return "user/donation/payment/confirm";
    }

    @GetMapping("/detail/news")
    public String newsPage(Model model,
            @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);

        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);

        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        List<NewsList> newsList = donationService.getNewsList(donationCode);
        model.addAttribute("newsList", newsList);


        return "user/donation/detail/news/main";
    }

    @GetMapping("/detail/news/newsDetail")
    public String newsDetailPage(@RequestParam(name = "newCode") String newsCode,
                                 @RequestParam(name = "donationCode") String donationCode, Model model){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        NewsList newsList = donationService.getDetailNews(newsCode);
        model.addAttribute("newsList", newsList);

        return "user/donation/detail/news/news_detail";
    }


}