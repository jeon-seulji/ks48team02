package ksmart.ks48team02.admin.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminSiteController")
@RequestMapping("/admin/site")
public class SiteController {

    // 카테고리 관리
    @GetMapping("/category")
    public String categoryPage(){

        return "admin/site/category";
    }

    // 카테고리 등록 수정
    @GetMapping("/categoryAdd")
    public String categoryAddPage(){

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
