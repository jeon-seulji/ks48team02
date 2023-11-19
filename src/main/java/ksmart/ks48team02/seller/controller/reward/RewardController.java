package ksmart.ks48team02.seller.controller.reward;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.seller.service.reward.SellerRewardService;
import ksmart.ks48team02.user.dto.RewardProject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller("sellerRewardController")
@RequestMapping("/seller/reward")
@AllArgsConstructor
public class RewardController {
    SellerRewardService sellerRewardService;

    // 판매자 상품 관리 페이지
    @GetMapping("/products")
    public String productsPage(Model model, HttpSession httpSession) {

        String sellerId = (String) httpSession.getAttribute("SID");
        List<RewardProject> projectList = sellerRewardService.projectListBySellerID(sellerId);
        model.addAttribute("projectList",projectList);

        return "seller/reward/products/main";
    }

    // 판매자 상품 검색태그 수정 패이지
    @GetMapping("/products/preExperienceRecruit")
    public String preExperienceRecruitPage(Model model) {

        return "seller/reward/products/pre_experience_recruit";
    }

    // 판매자 사전체험단 관리 페이지
    @GetMapping("/products/searchTagModify")
    public String serchTagModifyPage(Model model) {

        return "seller/reward/products/search_tag_modify";
    }

    //판매자 리워드 새소식 관리 페이지 (새소식 목록 조회+ 삭제)
    @GetMapping("/news")
    public String newsPage(Model model, HttpSession httpSession) {
        String sellerId = (String) httpSession.getAttribute("SID");

        List<RewardProject> newsListPerProject = sellerRewardService.getNewsListBySellerId(sellerId);
        model.addAttribute("newsListPerProject",newsListPerProject);

        return "seller/reward/news/main";
    }

    //판매자 리워드 새소식 수정 페이지
    @GetMapping("/news/modify")
    public String newsModiftyPage(Model model) {

        return "seller/reward/news/modify";
    }

    //판매자 리워드 새소식 추가 페이지
    @GetMapping("/news/add")
    public String newsAddPage(Model model) {

        return"seller/reward/news/add";
    }

    //판매자 댓글 관리
    @GetMapping("/products/comment")
    public String rewardComment(Model model) {

        return"seller/reward/products/comment";
    }

}
