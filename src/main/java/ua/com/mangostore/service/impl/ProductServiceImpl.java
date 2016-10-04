package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.repository.ProductRepository;
import ua.com.mangostore.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product addProduct(Product product) {
        Product saveProduct = productRepository.saveAndFlush(product);
        return saveProduct;
    }

    @Override
    @Transactional
    public void delete(long id) {
        productRepository.delete(id);
    }

    @Override
    @Transactional
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Product editProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
