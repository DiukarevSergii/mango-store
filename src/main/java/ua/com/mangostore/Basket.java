package ua.com.mangostore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Baskets")
public class Basket {

    @Id
    @GeneratedValue
    @Column(name = "BASKET_ID")
    private long basketId;

    @Column(nullable = false, name = "BASKET_PRICE")
    private int basketPrice;

    @Column(nullable = false, name = "BASKET_QUANTITY")
    private int basketQuantity;

    @Column(nullable = false, name = "BASKET_DISCOUNT")
    private int basketDiscount;

    @ManyToMany(mappedBy = "baskets", cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    public Basket() {
    }

    public Basket(int basketPrice, int basketQuantity, int basketDiscount) {
        this.basketPrice = basketPrice;
        this.basketQuantity = basketQuantity;
        this.basketDiscount = basketDiscount;
    }

    public void addProduct(Product product) {
        if (!products.contains(product))
            products.add(product);
        if (!product.baskets.contains(this))
            product.baskets.add(this);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getBasketPrice() {
        return basketPrice;
    }

    public void setBasketPrice(int basketPrice) {
        this.basketPrice = basketPrice;
    }

    public int getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(int basketQuantity) {
        this.basketQuantity = basketQuantity;
    }

    public int getBasketDiscount() {
        return basketDiscount;
    }

    public void setBasketDiscount(int basketDiscount) {
        this.basketDiscount = basketDiscount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", basketPrice=" + basketPrice +
                ", basketQuantity=" + basketQuantity +
                ", basketDiscount=" + basketDiscount +
                '}';
    }
}
