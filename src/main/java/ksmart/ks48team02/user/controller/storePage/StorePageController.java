package ksmart.ks48team02.user.controller.storePage;

import ksmart.ks48team02.user.dto.StorePageDto;
import ksmart.ks48team02.user.service.storePage.StorePageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("storePageController")
@RequestMapping("/user/storePage")
public class StorePageController {

    private final StorePageService storePageService;

    public StorePageController(StorePageService storePageServiceImpl){
            this.storePageService = storePageServiceImpl;
        }
    @GetMapping(value = {"","/"})
    public String storePage(Model model){

            List<StorePageDto> storeNewsList = storePageService.storePageNewsList();

            LocalDateTime currentDate = LocalDateTime.now();

            Map<StorePageDto, Long> daysAgoMap = new HashMap<>();

            long daysAgo = 0;
            for(StorePageDto storePageDto : storeNewsList ){
                LocalDateTime createdDatetime = storePageDto.getCreatedDatetime();

                daysAgo = Duration.between(createdDatetime, currentDate).toDays();
                daysAgoMap.put(storePageDto, daysAgo);
            }

//            if(!storeNewsList.isEmpty()){
//                StorePageDto storePagedto = storeNewsList.get(0);
//                LocalDateTime createdDatetime = storePagedto.getCreatedDatetime();
//
//                daysAgo = Duration.between(createdDatetime, currentDate).toDays();
//            }

            model.addAttribute("daysAgo",daysAgo);
            model.addAttribute("daysAgoMap", daysAgoMap);
            model.addAttribute("currentDate", currentDate);
            model.addAttribute("newsList", storeNewsList);

            return "user/storePage/main";
    }

    }