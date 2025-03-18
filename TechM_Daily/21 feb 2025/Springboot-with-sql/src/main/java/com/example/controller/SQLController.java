package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.EmpInfo;

@Controller
@RequestMapping("/index")
public class SQLController {

    @GetMapping("/form")
    public String showLoginForm(Model model) {
        model.addAttribute("empInfo", new EmpInfo()); 
        return "login";  // Redirect to login.jsp
    }

    @PostMapping("/form")
    public String processLogin(EmpInfo empInfo) {
        System.out.println("User logged in: " + empInfo);
        return "welcome";  // Redirect to welcome.jsp
    }
}
