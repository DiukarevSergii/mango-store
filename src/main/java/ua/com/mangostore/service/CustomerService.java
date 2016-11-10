package ua.com.mangostore.service;

import ua.com.mangostore.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    void delete(long id);
    Customer getByName(String name);
    Customer getByEmail(String email);
    Customer editCustomer(Customer customer);
    List<Customer> getAll();
}
