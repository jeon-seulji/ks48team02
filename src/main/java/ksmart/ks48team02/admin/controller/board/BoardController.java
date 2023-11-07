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
    @GetMapping("/modify")
    public String modifyNotice(){

        return "admin/board/modifyNotice";
    }
    // 공지사항 등록
    @GetMapping("/boardAdd")
    public String boardAdd(){

        return "admin/board/boardAdd";
    }


    // 이벤트 관리
    @GetMapping("/event")
    public String eventPage(){

        return "admin/board/event";
    }

    // 이벤트 수정 페이지
    @GetMapping("/eventModify")
    public String eventPageNotice(){

        return "admin/board/eventModify";
    }

    // 이벤트 등록 페이지
    @GetMapping("/eventAdd")
    public String eventAddPage(){

        return "admin/board/eventAdd";
    }


    // 쿠폰 관리
    @GetMapping("/coupon")
    public String couponPage(){

        return "admin/board/coupon";
    }

    // 쿠폰 등록
    @GetMapping("/couponAdd")
    public String couponAddPage(){

        return "admin/board/couponAdd";
    }
}
