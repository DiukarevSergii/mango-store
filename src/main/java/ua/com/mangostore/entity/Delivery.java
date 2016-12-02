package ua.com.mangostore.entity;

import ua.com.mangostore.entity.enums.DeliveryType;

import javax.persistence.*;

/**
 * Класс описывает сущность "Доставка".
 * Аннотация @Entity говорит о том что объекты этого класса будет обрабатываться Hibernate.
 * Аннотация @Table(name = "Deliveries") указывает на таблицу "Deliveries", в которой будут храниться объекты.
 *
 * @author Diukarev Sergii
 */
@Entity
@Table(name = "Deliveries")
public class Delivery {

    /**
     * Уникальный код обьекта.
     * Аннотация @Id говорит о том что поле является ключем для текущего объекта,
     * Аннотация @GeneratedValue говорит о том что значение генерируется автоматически.
     * Значение поля сохраняется в колонке "DELIVERY_ID".
     */
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private long deliveryId;

    /**
     * Дата доставки
     */
    @Column(name = "DELIVERY_DATE")
    private String deliveryDate;

    /**
     * Время доставки
     */
    @Column(name = "DELIVERY_TIME")
    private String deliveryTime;

    /**
     * Стоимость доставки
     */
    @Column(name = "DELIVERY_COST")
    private double cost;

    /**
     * Тип доставки
     */
    @Column(name = "DELIVERY_TYPE")
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    /**
     * Заказ, который звязан с текущей доставкой.
     * Значение поля (orderId объекта Order) сохраняется в колонке "ORDER_ID".
     * в объекте класса {@link Order}.
     * Между объектами классов {@link Order} и {@link Delivery} связь один-к-одному,
     * а именно каждая запись в одной таблице напрямую связана с отдельной записью в другой таблице.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    /**
     * Сотрудник-курьер связанный с заказом.
     * Значение поля (employeeId объекта Employee) сохраняется в колонке "EMPLOYEE_ID".
     * Между объектами классов {@link Delivery} и {@link Employee} связь многие-к-одному,
     * а именно много разных заказов могут иметь одного курьера.
     * Выборка объекта status до первого доступа нему, при первом доступе к текущему объекту.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    /**
     * Конструктр без параметров.
     */
    public Delivery() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        if (deliveryType.equals(DeliveryType.PICKUP.name())) {
            this.setDeliveryType(DeliveryType.PICKUP);
            this.setCost(0);
        } else if (deliveryType.equals(DeliveryType.COURIER.name())) {
            this.setDeliveryType(DeliveryType.COURIER);
            this.setCost(50);
        } else {
            this.setDeliveryType(DeliveryType.UNMANNED_AIRCRAFT);
            this.setCost(150);
        }
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void reset() {
        this.deliveryTime = "";
        this.deliveryDate = "";
        this.setEmployee(null);
    }

}
