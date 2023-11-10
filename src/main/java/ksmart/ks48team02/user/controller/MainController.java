package ksmart.ks48team02.user.controller;

import ksmart.ks48team02.user.dto.OrderRank;
import ksmart.ks48team02.user.service.main.UserMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {

	// 로그 추가
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	// DI 의존성 추가
	public final UserMainService userMainService;

	public MainController(UserMainService userMainService){
		this.userMainService = userMainService;
	}

	@PostMapping(value="/ajax/rankCategory")
	@ResponseBody
	public List<OrderRank> getRankCategory(Model model,
										   @RequestParam(name="rankCategory",
													 required = false,
													 defaultValue = "achievementPercent") String rankCategory){
//		System.out.println(rankCategory);
		List<OrderRank> list = userMainService.getRankList(rankCategory);
//		System.out.println(list);
		return list;
	}
	@GetMapping(value = {"" , "/"})
	public String mainPage(Model model,
						   @RequestParam(name="rankCategory",
								   		 required = false,
								   		 defaultValue = "achievementPercent") String rankCategory) {
		List<OrderRank> rankList = userMainService.getRankList(rankCategory);

		log.info("랭크 데이터 :{}", rankList);
		model.addAttribute("rankList", rankList);
		return "user/index";
	}

	@GetMapping("/upload")
	public String uploadPage(){

		return "fileupload/upload";
	}


}
