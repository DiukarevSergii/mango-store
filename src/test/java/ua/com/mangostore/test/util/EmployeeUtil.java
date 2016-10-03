package ua.com.mangostore.test.util;

import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.EmployeePosition;

public class EmployeeUtil {
    public static Employee createEmployee(){
        Employee employee = new Employee();
        employee.setEmail("wozniak@mangostore.com.ua");
        employee.setFullName("Stephen Gary Wozniak");
        employee.setPhone("911");
        employee.setPosition(EmployeePosition.MANAGER);
        return employee;
    }
}
