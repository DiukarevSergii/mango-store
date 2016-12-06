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

    /**
     * Возвращает курьера.
     *
     * @return Значение типа {@link Employee} - курьер ответственный за доставку.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Устанавливает курьра связанного с доставкой.
     *
     * @param employee курьер связанный с доставкой.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Возвращает заказ связанный с доставкой.
     *
     * @return Значение типа {@link Order} - заказ связанный с доставкой.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Устанавливает заказ связанный с доставкой.
     *
     * @param order заказ связанный с доставкой.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Возвращает дату доставки.
     *
     * @return Значение типа {@link String} - дата доставки.
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Устанавливает дату доставки.
     *
     * @param deliveryDate дату доставки.
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Возвращает время доставки.
     *
     * @return Значение типа {@link String} - время доставки.
     */
    public String getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Устанавливает время доставки.
     *
     * @param deliveryTime время доставки.
     */
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * Возвращает стоимость доставки.
     *
     * @return Значение типа {@link String} - стоимость доставки.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Устанавливает стоимость доставки.
     *
     * @param cost стоимость доставки.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Возвращает тип доставки.
     *
     * @return Значение типа {@link String} - тип доставки.
     */
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    /**
     * Устанавливает тип доставки.
     *
     * @param deliveryType тип доставки.
     */
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

    /**
     * Устанавливает тип доставки.
     *
     * @param deliveryType тип доставки.
     */
    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void reset() {
        this.deliveryTime = "";
        this.deliveryDate = "";
        this.setEmployee(null);
    }

    /**
     * Возвращает описание доставки.
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link String} - строка описание доставки (дата и время доставки, стомость, тип, заказ, курьер).
     */
    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", cost=" + cost +
                ", deliveryType=" + deliveryType +
                ", order=" + order +
                ", employee=" + employee +
                '}';
    }
}
