package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.mangostore.entity.SalePosition;

public interface SalePositonRepository extends JpaRepository<SalePosition, Long> {
    @Query("select s from SalePosition s where s.salePositionId = :id")
    SalePosition findById(@Param("id") long id);
}
