package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.mangostore.entity.Customer;
import ua.com.mangostore.repository.CustomerRepository;
import ua.com.mangostore.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        Customer saveCustomer = customerRepository.saveAndFlush(customer);
        return saveCustomer;
    }

    @Override
    public void delete(long id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer getByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer editCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
