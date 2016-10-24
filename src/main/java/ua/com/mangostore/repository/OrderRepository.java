package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.mangostore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.orderId = :id")
    Order findById(@Param("id") long id);
}
