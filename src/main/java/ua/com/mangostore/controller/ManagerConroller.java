package ua.com.mangostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerConroller {
    @RequestMapping
    public String loginPage() {
        return "employee/manager/manager";
    }
}
