package ua.com.mangostore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.entity.enums.EmployeePosition;
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
        List<Employee> admins = new ArrayList<>();

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().name().equals("COURIER")) {
                couriers.add(employee);
            } else if (employee.getPosition().name().equals("MANAGER")) {
                managers.add(employee);
            } else {
                admins.add(employee);
            }
        }
        modelAndView.addObject("couriers", couriers);
        modelAndView.addObject("managers", managers);
        modelAndView.addObject("admins", admins);
        modelAndView.setViewName("employee/admin/employees/main");
        return modelAndView;
    }


    @RequestMapping(value = "/remove-employee", method = RequestMethod.POST)
    public ModelAndView removeEmployee(@RequestParam("id") long id,
                                       ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        String fullName = employeeService.getById(id).getFullName();
        employeeService.delete(id);

        modelAndView.addObject("title", "Сотрудники");
        modelAndView.addObject("message", "удалили сотрудника " + fullName);
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/employees/update" с 1-м сотрудником с уникальним URL, который
     * совпадает с входящим параметром url. URL запроса "/employee-{id}", метод GET.
     * В запросе в параметре id передается артикль товара.
     *
     * @param id           id сотрудника, который нужно вернуть на страницу.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/employee-{id}", method = RequestMethod.GET)
    public ModelAndView viewEmployee(@PathVariable("id") long id, ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        Employee employee = employeeService.getById(id);
        modelAndView.addObject("title", "Редактирование информации о сотруднике");
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("employee/admin/employees/update");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/employees/update" с 1-м сотрудником с уникальним URL, который
     * совпадает с входящим параметром url. URL запроса "/employee-{id}", метод GET.
     * В запросе в параметре id передается артикль товара.
     *
     * @param id           id сотрудника, который нужно вернуть на страницу.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/employee-{id}-error", method = RequestMethod.GET)
    public ModelAndView viewEmployeeError(@PathVariable("id") long id, ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        Employee employee = employeeService.getById(id);
        modelAndView.addObject("title", "Редактирование информации о сотруднике");
        modelAndView.addObject("message", "Сотрудник с такой почтой уже существует. Попробуйте ещё раз");
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("employee/admin/employees/update");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/success"  и обновляет информацию о сотруднике по входящим параметрам.
     * URL запроса "/admin/update-employee", метод POST.
     *
     * @param id           Код сотрудника для обновления.
     * @param fullName     ФИО сотрудника.
     * @param phone        Телефон сотрудника.
     * @param email        Почта сотрудника.
     * @param password     Пароль сотрудника.
     * @param position     Должность сотрудника.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/update-employee", method = RequestMethod.POST)
    public ModelAndView updateProduct(@RequestParam long id,
                                      @RequestParam String fullName,
                                      @RequestParam String phone,
                                      @RequestParam String email,
                                      @RequestParam String password,
                                      @RequestParam String position,
                                      ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        Employee employee = employeeService.getById(id);
        if (!employee.getEmail().equals(email) && employeeService.getByEmail(email) != null) {
            modelAndView.setViewName("redirect:/admin/employee-" + id + "-error");
            return modelAndView;
        }

        employee.setFullName(fullName);
        employee.setPhone(phone);
        if (!employee.getPassword().equals(password)) {
            employee.setPassword(password);
        }
        employee.setEmail(email);
        EmployeePosition employeePosition;
        if (EmployeePosition.ADMIN.name().equals(position)) {
            employeePosition = EmployeePosition.ADMIN;
        } else if (EmployeePosition.MANAGER.name().equals(position)) {
            employeePosition = EmployeePosition.MANAGER;
        } else {
            employeePosition = EmployeePosition.COURIER;
        }
        employee.setPosition(employeePosition);
        employeeService.editEmployee(employee);

        modelAndView.addObject("title", "Сотрудники");
        modelAndView.addObject("message", "обновили информацию сотрудника " + fullName);
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
                                   @RequestParam String password,
                                   @RequestParam String position,
                                   ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        if (employeeService.getByEmail(email) != null) {
            modelAndView.addObject("message", "Сотрудник с такой почтой уже существует. Попробуйте ещё раз");
            modelAndView.setViewName("employee/admin/employees/add");
            return modelAndView;
        }

        Employee employee = new Employee();
        employee.setFullName(fullName);
        employee.setPhone(phone);
        employee.setPassword(password);
        employee.setEmail(email);
        EmployeePosition employeePosition;
        if (EmployeePosition.ADMIN.name().equals(position)) {
            employeePosition = EmployeePosition.ADMIN;
        } else if (EmployeePosition.MANAGER.name().equals(position)) {
            employeePosition = EmployeePosition.MANAGER;
        } else {
            employeePosition = EmployeePosition.COURIER;
        }
        employee.setPosition(employeePosition);
        employeeService.addEmployee(employee);

        modelAndView.addObject("title", "Сотрудники");
        modelAndView.addObject("message", "добавили сотрудника " + fullName);
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    @RequestMapping(value = "/remove-all-managers", method = RequestMethod.GET)
    public ModelAndView removeAllManagers(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().equals(EmployeePosition.MANAGER)) {
                employeeService.delete(employee.getEmployeeId());
            }
        }

        modelAndView.addObject("title", "Сотрудники");
        modelAndView.addObject("message", "Вы успешно удалили всех менеджеров!");
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }


    @RequestMapping(value = "/remove-all-couriers", method = RequestMethod.GET)
    public ModelAndView removeAllCouriers(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().equals(EmployeePosition.COURIER)) {
                employeeService.delete(employee.getEmployeeId());
            }
        }
        modelAndView.addObject("title", "Сотрудники");
        modelAndView.addObject("message", "Вы успешно удалили всех курьеров!");
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }


    @RequestMapping(value = "/only-managers", method = RequestMethod.GET)
    public ModelAndView onlyManagers(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        List<Employee> managers = new ArrayList<>();

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().name().equals("MANAGER")) {
                managers.add(employee);
            }
        }
        modelAndView.addObject("managers", managers);
        modelAndView.setViewName("employee/admin/employees/only-managers");
        return modelAndView;
    }

    @RequestMapping(value = "/only-couriers", method = RequestMethod.GET)
    public ModelAndView onlyCouriers(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        List<Employee> couriers = new ArrayList<>();

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().name().equals("COURIER")) {
                couriers.add(employee);
            }
        }
        modelAndView.addObject("couriers", couriers);
        modelAndView.setViewName("employee/admin/employees/only-couriers");
        return modelAndView;
    }

    @RequestMapping(value = "/only-admins", method = RequestMethod.GET)
    public ModelAndView onlyAdmins(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        List<Employee> admins = new ArrayList<>();

        for (Employee employee : employeeService.getAll()) {
            if (employee.getPosition().name().equals("ADMIN")) {
                admins.add(employee);
            }
        }
        modelAndView.addObject("admins", admins);
        modelAndView.setViewName("employee/admin/employees/only-admins");
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
