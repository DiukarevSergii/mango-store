package ua.com.mangostore.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.service.ProductService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@ComponentScan("ua.com.mangostore")
public class InitDatabase implements ApplicationListener<ContextRefreshedEvent> {
    @PersistenceContext
    protected EntityManager em;
    @Resource
    private ProductService productService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("WORKING!");

        Product product = new Product();
        product.setBrandName("LG");
        product.setPrice(12);
        product.setType("Smartphone");
        product.setProductTitle("LG 7689");

        Product product1 = new Product("Meizu M2", "Smartphone", "Meizu", 4500);
        Product product2 = new Product("Meizu M3", "Smartphone", "Meizu", 4000);

        productService.addProduct(product);
        productService.addProduct(product1);
        productService.addProduct(product2);
    }
}
