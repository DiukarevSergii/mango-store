package ua.com.mangostore.service;

import ua.com.mangostore.entity.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard addProduct(CreditCard creditCard);
    void delete(long id);
    CreditCard getById(long id);
    CreditCard editProduct(CreditCard creditCard);
    List<CreditCard> getAll();
}
