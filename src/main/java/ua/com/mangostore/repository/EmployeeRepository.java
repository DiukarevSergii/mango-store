package ua.com.mangostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Product;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.fullName = :fullName")
    Employee findByFullName(@Param("fullName") String fullName);


    @Query("select e from Employee e where e.email = :email")
    Employee findByEmail(@Param("email") String email);

    @Query("select e from Employee e where e.employeeId = :id")
    Employee findById(@Param("id") long id);
}
