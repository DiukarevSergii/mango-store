package ua.com.mangostore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public ModelAndView secret(ModelAndView modelAndView) {
        System.out.println("admin-secret");
        modelAndView.setViewName("employee/admin/secret");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainAdmin(ModelAndView modelAndView) {
        System.out.println("main-admin.jsp");
        modelAndView.setViewName("employee/admin/main");
        return modelAndView;
    }
}
