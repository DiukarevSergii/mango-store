package ua.com.mangostore.controller.courier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courier")
public class CourierController {
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainManager(ModelAndView modelAndView) {
        System.out.println("main-manager.jsp");
        modelAndView.setViewName("employee/courier/main");
        return modelAndView;
    }
}