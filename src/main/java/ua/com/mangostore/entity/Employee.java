package ua.com.mangostore.entity;

//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

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

    @Column(name = "POSITION")
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
        this.password = password;
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
//        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(1);
//        int salt = (int) (Math.random() * 10000);
//        this.password = passwordEncoder.encodePassword(password, salt);
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
