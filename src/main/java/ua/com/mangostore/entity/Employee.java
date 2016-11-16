package ua.com.mangostore.entity;

//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import ua.com.mangostore.entity.enums.EmployeePosition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private long employeeId;

    @Column(nullable = false, name = "FULL_NAME")
    private String fullName;

    @Column(nullable = false, name = "POSITION")
    @Enumerated(EnumType.STRING)
    private EmployeePosition position;

    @Column(nullable = false, name = "PHONE")
    private String phone;

    /**
     * Электронная почта сотрудника, также используется для входа в учетную запись на сайте (логин).
     * Значение поля сохраняется в колонке "EMAIL".
     * Может быть null.
     */
    @Column(nullable = false, name = "EMAIL")
    private String email;

    /**
     * Пароль пользователя для входа в учетную запись на сайте.
     * Значение поля сохраняется в колонке "PASSWORD".
     * Может быть null.
     */
    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Delivery> deliveries = new ArrayList<>();

    public Employee() {
    }

    public Employee(String fullName, EmployeePosition position, String phone, String email, String password) {
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.password = "";
        this.setPassword(password);
    }

    public void addOrder(Order order){
        order.setEmployee(this);
        orders.add(order);
    }

    public void addDelivery(Delivery delivery){
        delivery.setEmployee(this);
        deliveries.add(delivery);
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
            this.password = shaPasswordEncoder.encodePassword(password, null);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return email.equals(employee.email);

    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
