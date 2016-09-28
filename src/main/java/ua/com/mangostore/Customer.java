package ua.com.mangostore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(nullable = false, name = "NAME_RECIPIENT")
    private String name;

    @Column(nullable = false, name = "SURNAME")
    private String surname;

    @Column(nullable = false, name = "ADDRESS")
    private String address;

    @Column(nullable = false, name = "CITY")
    private String city;

    @Column(name = "ZIPCODE")
    private int zipcode;

    @Column(nullable = false, name = "PHONE")
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "customer")
    private CreditCard creditCard;

    public Customer() {
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orders.add(order);
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
