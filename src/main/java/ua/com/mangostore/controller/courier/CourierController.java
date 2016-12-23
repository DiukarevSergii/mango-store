package ua.com.mangostore.controller.courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.config.InitDatabase;
import ua.com.mangostore.entity.Delivery;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.entity.enums.DeliveryType;
import ua.com.mangostore.entity.enums.Status;
import ua.com.mangostore.service.DeliveryService;
import ua.com.mangostore.service.EmployeeService;
import ua.com.mangostore.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-контроллер курьерских страниц страниц. К даному контроллеру и соответствующим
 * страницам могут обращаться только пользователи с ролью администратора.
 * Аннотация @Controller служит для сообщения Spring'у о том, что данный класс
 * является bean'ом и его необходимо подгрузить при старте приложения.
 * Методы класса работают с объектом, возвращенным handleRequest методом, является
 * типом {@link ModelAndView}, который агрегирует все параметры модели и имя отображения.
 * Этот тип представляет Model и View в MVC шаблоне.
 *
 * @author Diukarev Sergii
 * @see InitDatabase
 * @see Product
 * @see EmployeeService
 * @see OrderService
 * @see DeliveryService
 */
@Controller
@RequestMapping("/courier")
public class CourierController {

    /**
     * Объект сервиса для работы с сотрудниками.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Объект сервиса для работы с заказами.
     */
    @Autowired
    private OrderService orderService;

    /**
     * Объект сервиса для работы с доставками.
     */
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView onMainCouriers(ModelAndView modelAndView) {
        getUser(modelAndView);

        List<Order> newOrders = new ArrayList<>();

        //Use Java 7
//        for (Order order : orderService.getAll()) {
//            if (order.getStatus().name().equals(Status.WORK.name())
//                    && !order.getDelivery().getDeliveryType().name().equals(DeliveryType.PICKUP.name())) {
//                newOrders.add(order);
//            }
//        }

        //Use Java 8
        newOrders.addAll(
                orderService.getAll().stream()
                        .filter(order -> order.getStatus().name().equals(Status.WORK.name())
                                && !order.getDelivery().getDeliveryType().name().equals(DeliveryType.PICKUP.name()))
                        .collect(Collectors.toList())
        );

        modelAndView.addObject("orders", newOrders);
        modelAndView.setViewName("employee/courier/main");
        return modelAndView;
    }


    @RequestMapping(value = "/deliveries", method = RequestMethod.GET)
    public ModelAndView onDeliveries(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee employee = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", employee);

        List<Delivery> deliveries = deliveryService.getByEmployeeId(employee.getEmployeeId());
        if (deliveries != null) {
            modelAndView.addObject("deliveries", deliveries);
        } else {
            modelAndView.addObject("deliveries", new ArrayList<>());
        }
        modelAndView.setViewName("employee/courier/deliveries");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateDelivery(@RequestParam long id,
                                       ModelAndView modelAndView) {
        getUser(modelAndView);

        Order order = orderService.getById(id);
        Delivery delivery = order.getDelivery();

        modelAndView.addObject("order", order);
        modelAndView.addObject("delivery", delivery);
        modelAndView.setViewName("employee/courier/update");
        return modelAndView;
    }

    @RequestMapping(value = "/updated", method = RequestMethod.GET)
    public ModelAndView updatedDelivery(@RequestParam long orderId,
                                        @RequestParam long deliveryId,
                                        @RequestParam String deliveryType,
                                        @RequestParam String deliveryDate,
                                        @RequestParam String deliveryTime,
                                        @RequestParam String status,
                                        ModelAndView modelAndView) {
        Order order = orderService.getById(orderId);
        if (order.getStatus().name().equals("WORK")) {
            order.setStatus(Status.DELIVERY);
        } else {
            if (status.equals("DELIVERY")) {
                order.setStatus(Status.DELIVERY);
            } else {
                order.setStatus(Status.CLOSED);
            }
        }
        orderService.editOrder(order);

        Delivery delivery = deliveryService.getById(deliveryId);
        delivery.setDeliveryType(deliveryType);

        if (!deliveryDate.isEmpty() && !deliveryTime.isEmpty()) {
            delivery.setDeliveryDate(deliveryDate);
            delivery.setDeliveryTime(deliveryTime);
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee employee = employeeService.getByEmail(user.getUsername());
        delivery.setEmployee(employee);
        deliveryService.editDelivery(delivery);

        modelAndView.addObject("user", employee);
        modelAndView.setViewName("redirect:/courier/main");
        return modelAndView;
    }

    private void getUser(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee employee = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", employee);
    }
}