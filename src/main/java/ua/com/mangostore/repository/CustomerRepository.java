package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.mangostore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Query("select c from Customer c where c.name = :name")
    Customer findByName(@Param("name") String name);

    @Query("select c from Customer c where c.email = :email")
    Customer findByEmail(@Param("email") String email);
}
