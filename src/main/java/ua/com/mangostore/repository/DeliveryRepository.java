package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.mangostore.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
