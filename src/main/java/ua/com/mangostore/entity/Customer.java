package ua.com.mangostore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает сущность "Покупатель".
 * Аннотация @Entity говорит о том что объекты этого класса будет обрабатываться Hibernate.
 * Аннотация @Table(name = "Customers") указывает на таблицу "Customers", в которой будут храниться объекты.
 *
 * @author Diukarev Sergii
 */
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

    /**
     * Список заказов, которые сделал текущий покупатель.
     * К текущему пользователю можно добраться через поле "customer"
     * в объекте класса {@link Order}.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public Customer() {
    }

    /**
     * Добавляет заказ текущему покупателю.
     *
     * @param order Заказ, который будет добавлен покупателю.
     */
    public void addOrder(Order order) {
        order.setCustomer(this);
        orders.add(order);
    }

    /**
     * Возвращает email покупателя.
     *
     * @return Значение типа {@link String} - email покупателя.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает email покупателя.
     *
     * @param email покупателя.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Возвращает имя покупателя.
     *
     * @return Значение типа {@link String} - имя покупателя.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя покупателя.
     *
     * @param name имя покупателя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает фамилию покупателя.
     *
     * @return Значение типа {@link String} - фамилия покупателя.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Устанавливает фамилию покупателя.
     *
     * @param surname фамилия покупателя.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Возвращает адрес покупателя.
     *
     * @return Значение типа {@link String} - адрес покупателя.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Устанавливает адрес покупателя.
     *
     * @param address адрес покупателя.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Возвращает город покупателя.
     *
     * @return Значение типа {@link String} - город покупателя.
     */
    public String getCity() {
        return city;
    }

    /**
     * Устанавливает город покупателя.
     *
     * @param city город покупателя.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Возвращает телефон покупателя.
     *
     * @return Значение типа {@link String} - телефон покупателя.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Устанавливает телефон покупателя.
     *
     * @param phone телефон покупателя.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Переопределям метод equals на основание поля phone.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phone.equals(customer.phone);
    }

    /**
     * Возвращает hashCode объекта на основание поля phone.
     */
    @Override
    public int hashCode() {
        return phone.hashCode();
    }

    /**
     * Возвращает описание покупателя.
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link String} - строка описание покупателя (имя, фамилия, адрес, город, телефон и email).
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
