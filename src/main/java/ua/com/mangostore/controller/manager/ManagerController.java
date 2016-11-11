package ua.com.mangostore.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public ModelAndView secret(ModelAndView modelAndView) {
        System.out.println("manager-secret");
        modelAndView.setViewName("employee/managers/secret");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainManager(ModelAndView modelAndView) {
        System.out.println("main-manager.jsp");
        modelAndView.setViewName("employee/managers/main");
        return modelAndView;
    }
}