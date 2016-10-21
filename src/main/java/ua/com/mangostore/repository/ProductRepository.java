package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.mangostore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.productTitle = :name")
    Product findByName(@Param("name") String name);

    @Query("select p from Product p where p.productId = :id")
    Product findById(@Param("id") long id);
}
