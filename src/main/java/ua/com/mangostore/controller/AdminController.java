package ua.com.mangostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping
    public String loginPage() {
        System.out.println("Hello");
        return "employee/admin/admin";
    }
}
