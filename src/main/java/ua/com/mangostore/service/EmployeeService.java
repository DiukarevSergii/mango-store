package ua.com.mangostore.service;

import ua.com.mangostore.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    void delete(long id);
    Employee getByFullName(String fullName);
    Employee editEmployee(Employee employee);
    List<Employee> getAll();
}
