package ksmart.ks48team02.admin.controller.site;

import ksmart.ks48team02.admin.dto.Category;
import ksmart.ks48team02.admin.service.category.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller("adminSiteController")
@RequestMapping("/admin/site")
public class SiteController {

    private static final Logger log = LoggerFactory.getLogger(SiteController.class);

    public final CategoryService categoryService;

    public SiteController( CategoryService categoryService){
        this.categoryService = categoryService;
    }
    // 카테고리 목록
    @GetMapping("/category")
    public String categoryPage(Model model){
        List<Category> categoryList = categoryService.getCategoryList("total");

        model.addAttribute("title", "카테고리 목록");
        model.addAttribute("categoryList", categoryList);


        return "admin/site/category";
    }

    // 카테고리 목록 ajax
    @PostMapping("/ajaxCategory")
    @ResponseBody
    public List<Category> categoryAjax(@RequestParam(name = "cateSelect") String cateSelect,
                                       Model model){
        // 객체 소환
        List<Category> list = categoryService.getCategoryList(cateSelect);

        log.info("카테고리 목록 : {}", list);
        return list;
    }

    // 카테고리 등록 ajax
    @PostMapping("/ajaxCategoryAdd")
    @ResponseBody
    public List<Category> categoryAddAjax(@RequestParam(name = "projectPatition") String projectPatition,
                                      Model model){

        List<Category> list = categoryService. getCategoryDepth2(projectPatition);
        log.info("중분류 조회 : {}", list);
        model.addAttribute("title", "카테고리 등록");

        return list;
}


    // 카테고리 등록
    @GetMapping("/categoryAdd")
    public String categoryAddPage(Model model){

        List<Category> categoryAdd = categoryService.getCategoryAdd();

        model.addAttribute("title", "categoryAdd");
        log.info("나오냐 {}", categoryAdd);
        model.addAttribute("categoryAdd", categoryAdd);

        return "admin/site/categoryAdd";

}

    // 알림 관리
    @GetMapping("/notification")
    public String notifiPage(){

        return "admin/site/notification";
    }

    // 알림 등록
    @GetMapping("/notificationAdd")
    public String notifiAddPage(){

        return "admin/site/notificationAdd";
    }
}
