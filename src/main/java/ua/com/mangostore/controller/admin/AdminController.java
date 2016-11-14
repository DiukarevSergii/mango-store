package ua.com.mangostore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.entity.enums.OnMain;
import ua.com.mangostore.service.EmployeeService;
import ua.com.mangostore.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public ModelAndView secret(ModelAndView modelAndView) {
        System.out.println("admin-secret");
        modelAndView.setViewName("employee/admin/secret");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainAdmin(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee admin = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", admin);
        modelAndView.setViewName("employee/admin/main");

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

        List<Product> groupOfProductsOnMain = new ArrayList<>();
        for (Product product : productService.getAll()) {
//            String onMainPage = product.getOnMain() + "";
//            if ("ON_MAIN".equals(onMainPage)) {
//                groupOfProductsOnMain.add(product);
//            }
            if (OnMain.ON_MAIN.equals(product.getOnMain())) {
                groupOfProductsOnMain.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsOnMain", groupOfProductsOnMain);

        return modelAndView;
    }
}
