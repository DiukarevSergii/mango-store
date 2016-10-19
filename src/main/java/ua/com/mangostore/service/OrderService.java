package ua.com.mangostore.service;

import ua.com.mangostore.entity.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);
    void delete(long id);
    Order getById(long id);
    Order editOrder(Order order);
    List<Order> getAll();
    int getSize();
}
