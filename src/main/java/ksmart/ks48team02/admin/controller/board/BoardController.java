package ksmart.ks48team02.admin.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminBoardController")
@RequestMapping("/admin/board")
public class BoardController {

    // 공지사항 관리
    @GetMapping("/main")
    public String mainPage(){

        return "admin/board/main";
    }
    // 공지사항 수정 페이지
    @GetMapping("/modify1")
    public String modifyNotice1(){

        return "admin/board/modifyNotice1";
    }
    @GetMapping("/modify2")
    public String modifyNotice2(){

        return "admin/board/modifyNotice2";
    }
    @GetMapping("/modify3")
    public String modifyNotice3(){

        return "admin/board/modifyNotice3";
    }


    // 이벤트 관리
    @GetMapping("/event")
    public String eventPage(){

        return "admin/board/event";
    }

    // 이벤트 수정 페이지
    @GetMapping("/eventModify1")
    public String eventPageNotice1(){

        return "admin/board/eventModify1";
    }


    // 쿠폰 관리
    @GetMapping("/coupon")
    public String couponPage(){

        return "admin/board/coupon";
    }
}
