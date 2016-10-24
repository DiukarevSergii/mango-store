package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.mangostore.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    @Query("select c from CreditCard c where c.cardId = :id")
    CreditCard findById(@Param("id") long id);
}
