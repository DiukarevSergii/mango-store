package ua.com.mangostore.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.service.EmployeeService;
import ua.com.mangostore.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainAdmin(ModelAndView modelAndView) {
        getUser(modelAndView);

        modelAndView.addObject("orders", orderService.getAll());
        modelAndView.setViewName("employee/managers/main");
        return modelAndView;
    }


    @RequestMapping(value = "/order-{id}", method = RequestMethod.GET)
    public ModelAndView mainAdmin(@PathVariable long id,
                                  ModelAndView modelAndView) {
        getUser(modelAndView);

        modelAndView.addObject("order", orderService.getById(id));
        modelAndView.setViewName("employee/managers/update");
        return modelAndView;
    }

    private void getUser(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee admin = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", admin);
    }
}