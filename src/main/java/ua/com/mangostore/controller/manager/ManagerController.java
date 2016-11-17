package ua.com.mangostore.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Customer;
import ua.com.mangostore.entity.Delivery;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.entity.enums.DeliveryType;
import ua.com.mangostore.entity.enums.Status;
import ua.com.mangostore.service.CustomerService;
import ua.com.mangostore.service.DeliveryService;
import ua.com.mangostore.service.EmployeeService;
import ua.com.mangostore.service.OrderService;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private CustomerService customerService;

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

        Order order = orderService.getById(id);
        Customer customer = order.getCustomer();

        modelAndView.addObject("order", order);
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("employee/managers/update");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/managers/update-order"  и обновляет товар по входящим параметрам.
     * URL запроса "/managers/update-order", метод POST.
     *
     * @param id           Код товара для обновления.
     * @param status       Статус заказа.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/update-order", method = RequestMethod.POST)
    public ModelAndView updateProduct(@RequestParam long id,
                                      @RequestParam String status,
                                      @RequestParam double orderPrice,
                                      @RequestParam String deliveryType,
                                      @RequestParam String email,
                                      @RequestParam String city,
                                      @RequestParam String address,
                                      @RequestParam String phone,

                                      ModelAndView modelAndView) {
        getUser(modelAndView);

        Order order = orderService.getById(id);
        order.setOrderPrice(orderPrice);

        Delivery delivery = order.getDelivery();
        if (!delivery.getDeliveryType().equals(deliveryType)) {
           delivery.setDeliveryType(deliveryType);
        }
        if (!order.getStatus().name().equals(status)) {
            if (status.equals(Status.NEW.name())) {
                order.setStatus(Status.NEW);
                delivery.reset();
            } else if (status.equals(Status.CLOSED.name())) {
                order.setStatus(Status.CLOSED);
            } else if (status.equals(Status.DELETED.name())) {
                order.setStatus(Status.DELETED);
            } else if (status.equals(Status.DELIVERY.name())) {
                order.setStatus(Status.DELIVERY);
            } else {
                order.setStatus(Status.WORK);
            }
        }
        deliveryService.editDelivery(delivery);
        order.setDelivery(delivery);

        Customer customer = customerService.getByEmail(order.getCustomer().getEmail());
        customer.setEmail(email);
        customer.setCity(city);
        customer.setAddress(address);
        customer.setAddress(phone);

        orderService.editOrder(order);

        modelAndView.addObject("title", "Заказы");
        modelAndView.addObject("message", "обновили заказ " + order.getNumber());
        modelAndView.setViewName("employee/managers/success");
        return modelAndView;
    }


    private void getUser(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee admin = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", admin);
    }
}