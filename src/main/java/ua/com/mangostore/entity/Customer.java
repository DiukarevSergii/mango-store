package ua.com.mangostore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer {
    /**
     * Уникальный код обьекта.
     * Аннотация @Id говорит о том что поле является ключем для текущего объекта,
     * Аннотация @GeneratedValue говорит о том что значение генерируется автоматически.
     * Значение поля сохраняется в колонке "CUSTOMER_ID".
     */
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    /**
     * Имя покупателя. Значение поля сохраняется в колонке "NAME". Не может быть null.
     */
    @Column(nullable = false, name = "NAME")
    private String name;

    /**
     * Фамилия покупателя. Значение поля сохраняется в колонке "SURNAME". Не может быть null.
     */
    @Column(nullable = false, name = "SURNAME")
    private String surname;

    /**
     * Адресс покупателя. Значение поля сохраняется в колонке "ADDRESS". Может быть null.
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * Город покупателя. Значение поля сохраняется в колонке "CITY". Не может быть null.
     */
    @Column(nullable = false, name = "CITY")
    private String city;

    /**
     * Телефон покупателя. Значение поля сохраняется в колонке "PHONE". Не может быть null.
     */
    @Column(nullable = false, name = "PHONE")
    private String phone;

    /**
     * Электронная почта покупателя. Значение поля сохраняется в колонке "EMAIL".
     * Не может быть null.
     */
    @Column(name = "EMAIL")
    private String email;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orders.add(order);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return phone.equals(customer.phone);

    }

    @Override
    public int hashCode() {
        return phone.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
