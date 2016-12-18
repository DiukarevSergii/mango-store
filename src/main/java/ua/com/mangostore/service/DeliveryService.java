package ua.com.mangostore.service;

import ua.com.mangostore.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    Delivery addDelivery(Delivery delivery);
    void delete(long id);
    Delivery getById(long id);
    List<Delivery> getByEmployeeId(long id);
    Delivery editDelivery(Delivery delivery);
    List<Delivery> getAll();
}

