package ua.com.mangostore.model;

import org.springframework.stereotype.Component;

/**
 * Класс описывает спикок товаров для отображения на главной странице.
 * Помечен аннотациями @Component указывает, что клас является компонентом фреймворка Spring;
 *
 * @author Diukarev Sergii
 * @see ua.com.mangostore.MainController
 */
@Component
public class GroupOfProducts {
    private String productTitle;
    private String type;
    private String brand;
    private String fullPrice;
    private String salePrice;
    private String specification;
    private String imageURL;

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

    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    public void setSalePrice(String salePrice) {
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

    public String getFullPrice() {
        return fullPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }
}
