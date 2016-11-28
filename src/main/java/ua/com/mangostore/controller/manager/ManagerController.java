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
import ua.com.mangostore.entity.*;
import ua.com.mangostore.entity.enums.EmployeePosition;
import ua.com.mangostore.entity.enums.Status;
import ua.com.mangostore.service.*;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView onMainManagers(ModelAndView modelAndView) {
        getUser(modelAndView);

        modelAndView.addObject("orders", orderService.getAll());
        modelAndView.setViewName("employee/managers/main");
        return modelAndView;
    }

    @RequestMapping(value = "/couriers", method = RequestMethod.GET)
    public ModelAndView onCouriers(ModelAndView modelAndView) {
        getUser(modelAndView);

        List<Employee> couriers = new ArrayList<>();
        for (Employee employee: employeeService.getAll()){
            if (employee.getPosition().name().equals(EmployeePosition.COURIER.name())){
                couriers.add(employee);
            }
        }
        modelAndView.addObject("couriers", couriers);
        modelAndView.setViewName("employee/managers/couriers");
        return modelAndView;
    }

    @RequestMapping(value = "/order-{id}", method = RequestMethod.GET)
    public ModelAndView onOrder(@PathVariable long id,
                                  ModelAndView modelAndView) {
        getUser(modelAndView);

        Order order = orderService.getById(id);
        Customer customer = order.getCustomer();

        modelAndView.addObject("order", order);
        modelAndView.addObject("customer", customer);

        Employee courier = order.getDelivery().getEmployee();
        if (courier != null) {
            modelAndView.addObject("fullName",courier.getFullName());
            modelAndView.addObject("phone", courier.getPhone());
        }
        modelAndView.setViewName("employee/managers/update");
        return modelAndView;
    }

    @RequestMapping(value = "/remove-order", method = RequestMethod.POST)
    public ModelAndView removeOrder(@RequestParam long id,
                                  ModelAndView modelAndView) {
        getUser(modelAndView);

        Order order = orderService.getById(id);
        order.setStatus(Status.DELETED);
        orderService.editOrder(order);

        modelAndView.setViewName("redirect:/managers/main");
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
                                      @RequestParam String name,
                                      @RequestParam String surname,
                                      @RequestParam String email,
                                      @RequestParam String phone,
                                      @RequestParam String city,
                                      @RequestParam String address,
                                      @RequestParam String status,
                                      @RequestParam String deliveryType,
                                      @RequestParam double orderPrice,
                                      @RequestParam String idProductForRemove,

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
        customer.setName(name);
        customer.setSurname(surname);
        customer.setEmail(email);
        customer.setCity(city);
        customer.setAddress(address);
        customer.setPhone(phone);
        customerService.editCustomer(customer);

        order.setCustomer(customer);

        //doesn't work yet

//        idProductForRemove = idProductForRemove.replaceFirst(",", "");
//
//        String[] arrIdForRemove = new String[1];
//        if (idProductForRemove.contains(",")) {
//            arrIdForRemove = idProductForRemove.split(",");
//        } else {
//            arrIdForRemove[0] = idProductForRemove;
//        }
//
//        if (!arrIdForRemove[0].isEmpty()) {
//            List<SalePosition> copy = new ArrayList<>(order.getSalePositions());
//            List<SalePosition> salePositions = order.getSalePositions();
//
//            System.out.println("size(): " + salePositions.size());
//
//            for (SalePosition salePosition : copy) {
//                long idProduct = salePosition.getProduct().getProductId();
//                for (String idForRemove : arrIdForRemove) {
//                    if (idProduct == Long.parseLong(idForRemove)) {
//
//                        order.removeSalePosition(salePosition);
//                    }
//                }
//            }
//        }

//        SalePosition salePosition = new SalePosition(productService.getById(4), 1);
//        order.addSalePosition(salePosition);
//
//        SalePosition salePosition1 = new SalePosition(productService.getById(1), 1);
//        order.removeSalePosition(salePosition1);

        orderService.editOrder(order);

        modelAndView.addObject("title", "Заказы");
        modelAndView.addObject("message", "обновили заказ " + order.getNumber());
        modelAndView.setViewName("employee/managers/success");
        return modelAndView;
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ModelAndView addProduct(@RequestParam long id,
                                   @RequestParam long productId,
                                   @RequestParam int number,
                                   ModelAndView modelAndView) {
        Order order = orderService.getById(id);
        SalePosition salePosition = new SalePosition(productService.getById(productId), number);
        order.addSalePosition(salePosition);
        orderService.editOrder(order);

        modelAndView.setViewName("redirect:/managers/order-" + id);
        return modelAndView;
    }

    private void getUser(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee admin = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", admin);
    }
}