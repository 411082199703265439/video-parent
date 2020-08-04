package com.qf.videos.controller;

import com.qf.videos.pojo.Admin;
import com.qf.videos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request){
        admin = adminService.selectAdminByUsernameAndPassword(admin);
        if (admin != null){
            HttpSession session = request.getSession();
            session.setAttribute("userName",admin.getUsername());
            return "success";
        }
        else {
            return "failed";
        }
    }
    @RequestMapping("/loginView")
    public String loginView() {
        return "/behind/login";
    }
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        return "redirect:loginView";
    }
}
