package ksmart.ks48team02.user.controller;

import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import ksmart.ks48team02.admin.dto.TotalCategory;
import ksmart.ks48team02.admin.mapper.TotalCategoryMapper;
import ksmart.ks48team02.admin.service.TotalCategoryService;
import ksmart.ks48team02.user.dto.donation.DonationRegistration;
import ksmart.ks48team02.user.service.donation.DonationService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user/projectRegistration")
public class PojectRegistrationContoller {

    private final DonationService donationService;
    private final TotalCategoryService totalCategoryService;

    public PojectRegistrationContoller(DonationService donationService, TotalCategoryService totalCategoryService){
        this.donationService = donationService;
        this.totalCategoryService = totalCategoryService;
    }

    //프로젝트 등록 메인 페이지
    @GetMapping(value = {"" , "/"})
    public String mainPage(Model model) {

        return "user/projectRegistration/main";
    }

    //리워드 프로젝트 등록 페이지
    @GetMapping(value = {"/reward"})
    public String rewardRegistrationPage(Model model) {

        List<TotalCategory> categoryList = totalCategoryService.categoryByPatition("reward");

        model.addAttribute("categoryList",categoryList);


        return "user/projectRegistration/reward/reward_insert";
    }
    //투자 프로젝트 등록 페이지


    // 기부 프로젝트 완료 포스트맵핑으로 받기
    @PostMapping("/donation")
    public String donationRegistrationPage(DonationRegistration donationRegistration){
        donationService.addDonation(donationRegistration);
        return "redirect:/user/projectRegistration/donation/success";
    }
    // 기부 프로젝트 완료 페이지
    @GetMapping("/donation/success")
    public String donationRegistrationSuccessPage(){
        return "user/projectRegistration/donation/donation_insert_success";
    }
    // 기부 프로젝트 등록 폼
    @GetMapping("/donation")
    public String donationRegistrationPage(Model model) {
        List<TotalCategory> categoryList = totalCategoryService.categoryByPatition("donation");
        model.addAttribute("categoryList",categoryList);

        return "user/projectRegistration/donation/donation_insert";
    }
    @PostMapping(value = "/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile,
                                                HttpServletRequest request) {
        JsonObject jsonObject = new JsonObject();

        String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명

        File targetFile = new File(fileRoot + savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }

        return jsonObject;
    }


}