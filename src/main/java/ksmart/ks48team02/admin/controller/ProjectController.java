package ksmart.ks48team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProjectController {

    @GetMapping("/projectManagement")
    public String projectManagement(Model model){
        model.addAttribute("title", "프로젝트 조회");
        model.addAttribute("contentsTitle", "프로젝트 조회");

        return "admin/project/project_management";
    }

}
