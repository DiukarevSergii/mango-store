package ua.com.mangostore.entity;

import ua.com.mangostore.entity.enums.DeliveryType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Deliveries")
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private long deliveryId;

    @Column(name = "DELIVERY_DATE")
    private String deliveryDate;

    @Column(name = "DELIVERY_TIME")
    private String deliveryTime;

    @Column(name = "DELIVERY_COST")
    private double cost;

    @Column(name = "DELIVERY_TYPE")
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

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

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate.toString();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime.toString();
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

    public void reset(){
        this.deliveryTime = "";
        this.deliveryDate = "";
        this.setEmployee(null);
    }

}
