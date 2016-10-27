package ua.com.mangostore.entity;

import javax.persistence.*;

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

    @Column(nullable = false, name = "BRAND")
    private String brand;

    @Column(nullable = false, name = "FULL_PRICE")
    private double fullPrice;

    @Column(name = "SALE_PRICE")
    private double salePrice;

    @Column(name = "SPECIFICATION", length = 5000)
    private String specification;

    @Column(name = "IMAGE_URL")
    private String imageURL;

    @Column(name = "ON_MAIN")
    private String onMain;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product() {
    }

    public Product(String productTitle, String type, String brand, double fullPrice, double salePrice) {
        this.productTitle = productTitle;
        this.type = type;
        this.brand = brand;
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
    }

    public Product(String productTitle, String type, String brandName,
                   double fullPrice, double salePrice,
                   String specification, String image) {
        this.productTitle = productTitle;
        this.type = type;
        this.brand = brandName;
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
        this.specification = specification;
        this.imageURL = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOnMain() {
        return onMain;
    }

    public void setOnMain(String onMain) {
        this.onMain = onMain;
    }

    public double getPrice() {
        return fullPrice;
    }

    public void setPrice(double price) {
        this.fullPrice = price;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.fullPrice, fullPrice) != 0) return false;
        if (Double.compare(product.salePrice, salePrice) != 0) return false;
        if (!productTitle.equals(product.productTitle)) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return brand != null ? brand.equals(product.brand) : product.brand == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productTitle.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        temp = Double.doubleToLongBits(fullPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(salePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", type='" + type + '\'' +
                ", brandName='" + brand + '\'' +
                ", fullPrice=" + fullPrice +
                ", salePrice=" + salePrice +
                ", specification='" + specification + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}