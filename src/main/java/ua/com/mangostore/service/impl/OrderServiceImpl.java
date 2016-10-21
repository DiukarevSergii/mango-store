package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.repository.OrderRepository;
import ua.com.mangostore.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public Order addOrder(Order order) {
        Order saveOrder = orderRepository.saveAndFlush(order);
        return saveOrder;
    }

    @Override
    @Transactional
    public void delete(long id) {
        orderRepository.delete(id);
    }

    @Override
    @Transactional
    public Order getById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Order editOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    @Transactional
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public int getSize() {
        return orderRepository.findAll().size();
    }
}
