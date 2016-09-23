package ua.com.mangostore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Products {

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

    private int price;

    @Column(name = "QUANTITY")
    private int quantity;


    @OneToMany(mappedBy = "products")
    private Set<Basket> basketSet;

    public Products() {
    }

    public Products(String productTitle, String type, String brandName, int price, int quantity) {
        this.productTitle = productTitle;
        this.type = type;
        this.brandName = brandName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Set<Basket> getBasketSet() {
        return basketSet;
    }

    public void setBasketSet(Set<Basket> basketSet) {
        this.basketSet = basketSet;
    }
}
