package ua.com.mangostore.test.util;

import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.enums.EmployeePosition;

public class EmployeeUtil {
    public static Employee createEmployee() {
        Employee employee = new Employee(
                "Super Admin", EmployeePosition.ADMIN, "044 410 66 50",
                "admin@mango.com.uaa", "password");
        return employee;
    }
}
