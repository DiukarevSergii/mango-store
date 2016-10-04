package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.repository.EmployeeRepository;
import ua.com.mangostore.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        Employee saveEmployee = employeeRepository.saveAndFlush(employee);
        return saveEmployee;
    }

    @Override
    @Transactional
    public void delete(long id) {
        employeeRepository.delete(id);
    }

    @Override
    @Transactional
    public Employee getByFullName(String fullName) {
        return employeeRepository.findByFullName(fullName);
    }

    @Override
    @Transactional
    public Employee editEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
