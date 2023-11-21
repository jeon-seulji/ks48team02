package ksmart.ks48team02.user.controller.donation;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.donation.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                                 Model model,
                                 HttpSession session){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);
        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }
      
        return "user/donation/detail/main";
    }

    @GetMapping("/detail/condition")
    public String detailConditionPage(Model model, HttpSession session,
                                      @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        String conditionContents = donationService.getCondition(donationCode);
        model.addAttribute("conditionContents", conditionContents);
        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        return "user/donation/detail/condition";
    }

    @GetMapping("/detail/comment")
    public String detailCommentPage(HttpSession session, Model model,
                                    @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);
        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        // getcomment 만들어서 댓글 가져오기.
        List<DonationCommentList> donationCommentList = donationService.getCommentList(donationCode);
        model.addAttribute("donationCommentList", donationCommentList);
        // 리뷰 개수 계산
        int viewCount = 0;
        for (int i = 0; i < donationCommentList.size(); i++) {
            if(donationCommentList.get(i).getCommentClass().equals("comment")){
                viewCount++;
            }
        }
        model.addAttribute("viewCount", viewCount);

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

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        donationService.replyAdd(reply, donationCode, parentCommentCode, memberId, commentMember.getMemberName());


        return "redirect:/user/donation/detail/comment?donationCode=" + donationCode;
    }

    @GetMapping("/order")
    public String orderMainPage(@RequestParam(name = "donationCode") String donationCode,
            HttpSession session, Model model){
        String SID = (String)session.getAttribute("SID");
        model.addAttribute("SID", SID);
        int myFlover = donationService.getFlover(SID);
        model.addAttribute("myFlover", myFlover);
        model.addAttribute("donationCode", donationCode);

        return "user/donation/order/main";
    }

    @PostMapping("/payment")
    public String paymentMainPage(@RequestParam(name = "floverCount") int floverCount,
                                  @RequestParam(name = "donationCode") String donationCode,
                                  HttpSession session,
                                  Model model){
        String SID = (String)session.getAttribute("SID");
        int dbflover = donationService.getFlover(SID);
        int resultFlover = dbflover - floverCount;
        if (resultFlover < 0){

        }else{
            Map<String, Object> deductData = new HashMap<String,Object>();
            deductData.put("SID", SID);
            deductData.put("resultFlover", resultFlover);
            donationService.deductFlover(deductData);
            model.addAttribute("floverCount", floverCount);
            List<AllDonationInfo> donationInfoList = donationService.getAllDonationInfo();
            for (int i = 0; i < donationInfoList.size(); i++) {
                if(donationInfoList.get(i).getDonationCode().equals(donationCode)){
                    model.addAttribute("donationSubject" , donationInfoList.get(i).getDonationSubject());
                    model.addAttribute("storeName", donationInfoList.get(i).getStoreName());
                }
            }

            int floverToMoney = floverCount * 100;
            donationService.addOrderTable(SID, donationCode, Integer.toString(floverToMoney));
            donationService.addDonationPayemnt(donationCode, Integer.toString(floverCount), Integer.toString(floverToMoney));
        }


        return "user/donation/payment/confirm";
    }

    @GetMapping("/payment/confirm")
    public String paymentConfirmPage(){
        return "user/donation/payment/confirm";
    }

    @GetMapping("/detail/news")
    public String newsPage(Model model, HttpSession session,
            @RequestParam(name = "donationCode") String donationCode){
        model.addAttribute("donationCode", donationCode);

        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);

        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        List<NewsList> newsList = donationService.getNewsList(donationCode);
        model.addAttribute("newsList", newsList);

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }


        return "user/donation/detail/news/main";
    }

    @GetMapping("/detail/news/newsDetail")
    public String newsDetailPage(@RequestParam(name = "newCode") String newsCode,
                                 @RequestParam(name = "donationCode") String donationCode,
                                 Model model, HttpSession session){
        model.addAttribute("donationCode", donationCode);
        DonationInfo donationInfo = donationService.getDonationInfo(donationCode);
        model.addAttribute("donationInfo", donationInfo);
        CategoryAndCompany cateAndCompany = donationService.getCateAndCompany(donationCode);
        model.addAttribute("cateAndCompany", cateAndCompany);

        NewsList newsList = donationService.getDetailNews(newsCode);
        model.addAttribute("newsList", newsList);

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }


        return "user/donation/detail/news/news_detail";
    }


}