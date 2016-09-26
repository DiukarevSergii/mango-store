package ua.com.mangostore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Basket")
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

    @ManyToMany(mappedBy = "baskets")
    List<Product> products = new ArrayList<>();

    public Basket() {
    }

    public Basket(int basketPrice, int basketQuantity, int basketDiscount) {
        this.basketPrice = basketPrice;
        this.basketQuantity = basketQuantity;
        this.basketDiscount = basketDiscount;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
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
