package ua.com.mangostore;

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

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DELIVERY_TYPE")
    private String type;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    public Delivery() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryDate=" + deliveryDate +
                ", deliveryTime=" + deliveryTime +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
