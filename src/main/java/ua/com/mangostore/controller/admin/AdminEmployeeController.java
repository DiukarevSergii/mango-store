package ua.com.mangostore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.service.EmployeeService;
import ua.com.mangostore.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping(value = "/admin")
public class AdminEmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView mainEmployee(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        List<Employee> couriers = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().name().equals("COURIER")) {
                couriers.add(employee);
            }
            if (employee.getPosition().name().equals("MANAGER")) {
                managers.add(employee);
            }
        }
        modelAndView.addObject("couriers", couriers);
        modelAndView.addObject("managers", managers);
        modelAndView.setViewName("employee/admin/employees/main");
        return modelAndView;
    }


    @RequestMapping(value = "/remove-employee", method = RequestMethod.POST)
    public ModelAndView removeEmployee(@RequestParam("id") long id,
                                       ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        String fullName = employeeService.getById(id).getFullName();
        employeeService.delete(id);

        modelAndView.addObject("title", "сотрудники");
        modelAndView.addObject("message", "удалили сотрудника " + fullName);
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    @RequestMapping(value = "/add-employee", method = RequestMethod.GET)
    public ModelAndView addProduct(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        modelAndView.setViewName("employee/admin/employees/add");
        return modelAndView;
    }

    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    public ModelAndView addProduct(@RequestParam String fullName,
                                   @RequestParam String phone,
                                   @RequestParam String email,
                                   @RequestParam String position,
                                   ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        modelAndView.addObject("title", "сотрудники");
        modelAndView.addObject("message", "добавили сотрудника " + fullName);
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    private void getUserTypeBrand(ModelAndView modelAndView) {
        getUser(modelAndView);
        byType(modelAndView);
        byBrand(modelAndView);
    }

    private void getUser(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee admin = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", admin);
    }

    private void byType(ModelAndView modelAndView) {
        Set<String> types = new TreeSet<>();
        List<Product> groupOfProductsByType = new ArrayList<>();
        for (Product product : productService.getAll()) {
            String type = product.getType();
            if (!types.contains(type)) {
                types.add(type);
                groupOfProductsByType.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsByType", groupOfProductsByType);
    }

    private void byBrand(ModelAndView modelAndView) {
        Set<String> brands = new TreeSet<>();
        List<Product> groupOfProductsByBrand = new ArrayList<>();
        for (Product product : productService.getAll()) {
            String brand = product.getBrand();
            if (!brands.contains(brand)) {
                brands.add(brand);
                groupOfProductsByBrand.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsByBrand", groupOfProductsByBrand);
    }
}
