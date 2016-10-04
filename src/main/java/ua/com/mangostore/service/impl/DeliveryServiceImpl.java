package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.entity.Delivery;
import ua.com.mangostore.repository.DeliveryRepository;
import ua.com.mangostore.service.DeliveryService;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public Delivery addDelivery(Delivery delivery) {
        Delivery saveDelivery = deliveryRepository.saveAndFlush(delivery);
        return saveDelivery;
    }

    @Override
    @Transactional
    public void delete(long id) {
        deliveryRepository.delete(id);
    }

    @Override
    @Transactional
    public Delivery getById(long id) {
        return deliveryRepository.findById(id);
    }

    @Override
    @Transactional
    public Delivery editDelivery(Delivery delivery) {
        return deliveryRepository.saveAndFlush(delivery);
    }

    @Override
    @Transactional
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }
}
