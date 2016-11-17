package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.entity.Customer;
import ua.com.mangostore.repository.CustomerRepository;
import ua.com.mangostore.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        if (getAll().contains(customer)) {
            return customer;
        }
        Customer saveCustomer = customerRepository.saveAndFlush(customer);
        return saveCustomer;
    }

    @Override
    @Transactional
    public void delete(long id) {
        customerRepository.delete(id);
    }

    @Override
    @Transactional
    public Customer getByName(String name) {
        return customerRepository.findByName(name);
    }


    @Override
    @Transactional
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public Customer editCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
