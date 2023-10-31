package ksmart.ks48team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMainController")
@RequestMapping("/admin")
public class MainController {
	
	@GetMapping(value = {"", "/"})
	public String adminMainPage(Model model) {


		return "admin/index";
	}
}
