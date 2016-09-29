package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.repository.EmployeeRepository;
import ua.com.mangostore.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee saveEmployee = employeeRepository.saveAndFlush(employee);
        return saveEmployee;
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee getByFullName(String fullName) {
        return employeeRepository.findByFullName(fullName);
    }

    @Override
    public Employee editEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
