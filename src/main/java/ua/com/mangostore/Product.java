package ua.com.mangostore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(nullable = false, name = "PRODUCT_TITLE")
    private String productTitle;

    @Column(nullable = false, name = "TYPE")
    private String type;

    @Column(nullable = false, name = "BRAND_NAME")
    private String brandName;

    @Column(nullable = false, name = "PRICE")
    private double price;

    @ManyToMany()
    @JoinTable(name = "ProductOrder",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")})
    List<Order> orders = new ArrayList<>();

    public Product() {
    }

    public Product(String productTitle, String type, String brandName, double price) {
        this.productTitle = productTitle;
        this.type = type;
        this.brandName = brandName;
        this.price = price;

    }

    public void addOrder(Order order) {
        if (!orders.contains(order))
            orders.add(order);
        if (!order.products.contains(this))
            order.products.add(this);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", type='" + type + '\'' +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                '}';
    }
}
