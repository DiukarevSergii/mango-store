package ua.com.mangostore.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private String dateCreated;

    @OneToOne(mappedBy = "order")
    private Delivery delivery;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
//    private List<SalePosition> salePositions = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
//    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public Order() {
        this.dateCreated = LocalDate.now().toString();
    }


//    public void addSalePosition(SalePosition salePosition) {
//        salePositions.add(salePosition);
//        if (salePosition.getOrder() != this) {
//            salePosition.setOrder(this);
//        }
//    }

      public void addProduct(Product product){
          products.add(product);
          if(product.getOrder() != this){
              product.setOrder(this);
          }
      }


//    public void addProduct(Product product) {
//        if (!products.contains(product))
//            products.add(product);
//        if (!product.orders.contains(this))
//            product.orders.add(this);
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public long getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", orderPriceWithDiscount=" + orderPriceWithDiscount +
                ", orderQuantity=" + orderQuantity +
                ", orderDiscount=" + orderDiscount +
                ", dateCreated='" + dateCreated + '\'' +
                ", delivery=" + delivery +
                ", employee=" + employee +
                '}';
    }
}