package ua.com.mangostore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
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

    private int price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToMany
    @JoinTable(name = "ProductBasket",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "BASKET_ID", referencedColumnName = "BASKET_ID")})
    List<Basket> baskets = new ArrayList<>();

    public Product() {
    }

    public Product(String productTitle, String type, String brandName, int price, int quantity) {
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

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", type='" + type + '\'' +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
