package ua.com.mangostore.test.util;

import ua.com.mangostore.entity.Product;

public class ProductUtil {
    public static Product createProduct(){
        Product product = new Product();
        product.setProductTitle("LG 7689");
        return product;
    }
}
