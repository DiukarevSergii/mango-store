package ua.com.mangostore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(nullable = false, name = "ORDER_PRICE")
    private double orderPrice;

    @Column(nullable = false, name = "ORDER_PRICE_WITH_DISCOUNT")
    private double orderPriceWithDiscount;

    @Column(nullable = false, name = "ORDER_QUANTITY")
    private int orderQuantity;

    @Column(nullable = false, name = "ORDER_DISCOUNT")
    private int orderDiscount;

    @Column(nullable = false, name = "DATE_CREATED")
    private Date dateCreated ;

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    public Order() {
        this.dateCreated = new Date();
    }

    public void addProduct(Product product) {
        if (!products.contains(product))
            products.add(product);
        if (!product.orders.contains(this))
            product.orders.add(this);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getOrderPriceWithDiscount() {
        return orderPriceWithDiscount;
    }

    public void setOrderPriceWithDiscount(double orderPriceWithDiscount) {
        this.orderPriceWithDiscount = orderPriceWithDiscount;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double OrderPrice) {
        this.orderPrice = OrderPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int OrderQuantity) {
        this.orderQuantity = OrderQuantity;
    }

    public int getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(int OrderDiscount) {
        this.orderDiscount = OrderDiscount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderPrice=" + orderPrice +
                ", orderPriceWithDiscount=" + orderPriceWithDiscount +
                ", orderQuantity=" + orderQuantity +
                ", orderDiscount=" + orderDiscount +
                ", dateCreated=" + dateCreated +
                ", customer=" + customer +
                '}';
    }
}
