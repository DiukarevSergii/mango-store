package ua.com.mangostore.controller.admin;

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
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public ModelAndView secret(ModelAndView modelAndView) {
        System.out.println("admin-secret");
        modelAndView.setViewName("employee/admin/secret");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainAdmin(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();

        Employee admin = employeeService.getByEmail(email);

        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("employee/admin/admin-main");
        return modelAndView;
    }
}
