package ua.com.mangostore.entity;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import ua.com.mangostore.entity.enums.EmployeePosition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает сущность "Сотрудник".
 * Аннотация @Entity говорит о том что объекты этого класса будет обрабатываться Hibernate.
 * Аннотация @Table(name = "Employees") указывает на таблицу "Employees", в которой будут храниться объекты.
 *
 * @author Diukarev Sergii
 */
@Entity
@Table(name = "Employees")
public class Employee {

    /**
     * Уникальный код обьекта.
     * Аннотация @Id говорит о том что поле является ключем для текущего объекта,
     * Аннотация @GeneratedValue говорит о том что значение генерируется автоматически.
     * Значение поля сохраняется в колонке "EMPLOYEE_ID".
     */
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private long employeeId;

    /**
     * ФИО сотрудника. Значение поля сохраняется в колонке "FULL_NAME". Не может быть null.
     */
    @Column(nullable = false, name = "FULL_NAME")
    private String fullName;

    /**
     * Должность сотрудника. Не может быть null.
     */
    @Column(nullable = false, name = "POSITION")
    @Enumerated(EnumType.STRING)
    private EmployeePosition position;

    /**
     * Телефон сотрудника. Не может быть null.
     */
    @Column(nullable = false, name = "PHONE")
    private String phone;

    /**
     * Электронная почта сотрудника, также используется для входа в учетную запись на сайте (логин).
     * Значение поля сохраняется в колонке "EMAIL".
     * Не может быть null.
     */
    @Column(nullable = false, name = "EMAIL")
    private String email;

    /**
     * Пароль пользователя для входа в учетную запись на сайте.
     * Значение поля сохраняется в колонке "PASSWORD".
     * Не может быть null.
     */
    @Column(nullable = false, name = "PASSWORD")
    private String password;

    /**
     * Список заказов, которые относятся к данному сотруднику.
     * К текущему сотруднику можно добраться через поле "employee"
     * в объекте класса {@link Order}.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    /**
     * Список доставок, которые относятся к данному сотруднику.
     * К текущему сотруднику можно добраться через поле "employee"
     * в объекте класса {@link Delivery}.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Delivery> deliveries = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public Employee() {
    }

    /**
     * Конструктр с параметрами.
     *
     * @param fullName ФИО сотрудника
     * @param position Должность
     * @param phone    Телефон
     * @param email    Электронная почта
     * @param password Пароль
     */
    public Employee(String fullName, EmployeePosition position, String phone, String email, String password) {
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.password = "";
        this.setPassword(password);
    }

    /**
     * Добавляет заказ текущему сотруднику.
     *
     * @param order Заказ, который будет добавлен сотруднику.
     */
    public void addOrder(Order order) {
        order.setEmployee(this);
        orders.add(order);
    }

    /**
     * Добавляет доставку текущему сотруднику.
     *
     * @param delivery Доставка, которая будет добавлена сотруднику.
     */
    public void addDelivery(Delivery delivery) {
        delivery.setEmployee(this);
        deliveries.add(delivery);
    }

    /**
     * Возвращает пароль сотрудника.
     *
     * @return Значение типа {@link String} - пароль сотрудника.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Устанавливает пароль сотрудника.
     * Хеширует пароль используя алгоритм криптографического хеширования SHA-1
     *
     * @param password телефон покупателя.
     */
    public void setPassword(String password) {
        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
        this.password = shaPasswordEncoder.encodePassword(password, null);
    }

    /**
     * Возвращает ФИО сотрудника.
     *
     * @return Значение типа {@link String} - ФИО сотрудника.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Устанавливает ФИО сотрудника.
     *
     * @param fullName ФИО сотрудника.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Возвращает email сотрудника.
     *
     * @return Значение типа {@link String} - email сотрудника.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает электронную почту сотрудника.
     *
     * @param email электронную почту сотрудника.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Возвращает должность сотрудника.
     *
     * @return Значение типа {@link String} - должность сотрудника.
     */
    public EmployeePosition getPosition() {
        return position;
    }

    /**
     * Устанавливает должность сотрудника.
     *
     * @param position должность сотрудника.
     */
    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
    /**
     * Возвращает телефон сотрудника.
     *
     * @return Значение типа {@link String} - телефон сотрудника.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Устанавливает телефон сотрудника.
     *
     * @param phone телефон сотрудника.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Сравнение сотрудников
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link boolean}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return email.equals(employee.email);

    }

    /**
     * HashCode сотрудника
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link int}.
     */
    @Override
    public int hashCode() {
        return email.hashCode();
    }

    /**
     * Возвращает описание сотрудника.
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link String} - строка описание сотрудника (ФИО, должность, телефон, email, пароль, заказы и доставки).
     */
    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position=" + position +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                ", deliveries=" + deliveries +
                '}';
    }
}
