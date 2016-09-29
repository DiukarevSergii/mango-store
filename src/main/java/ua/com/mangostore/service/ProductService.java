package ua.com.mangostore.service;

import ua.com.mangostore.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    void delete(long id);
    Product getByName(String name);
    Product editProduct(Product product);
    List<Product> getAll();

}
