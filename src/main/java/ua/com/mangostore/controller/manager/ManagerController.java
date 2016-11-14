package ua.com.mangostore.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.service.EmployeeService;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public ModelAndView secret(ModelAndView modelAndView) {
        System.out.println("manager-secret");
        modelAndView.setViewName("employee/managers/secret");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainAdmin(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();

        Employee manager = employeeService.getByEmail(email);

        modelAndView.addObject("user",manager);
        modelAndView.setViewName("employee/managers/main");
        return modelAndView;
    }
}