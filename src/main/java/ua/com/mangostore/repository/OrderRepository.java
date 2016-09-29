package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.mangostore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
