package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.mangostore.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
