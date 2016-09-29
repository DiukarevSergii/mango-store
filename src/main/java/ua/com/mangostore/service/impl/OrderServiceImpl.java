package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.repository.OrderRepository;
import ua.com.mangostore.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        Order saveOrder = orderRepository.saveAndFlush(order);
        return saveOrder;
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order editOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
