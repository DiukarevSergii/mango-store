package ua.com.mangostore.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.service.OrderService;
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
    @Resource
    private OrderService orderService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Start init!");


        Product product1 = new Product("iPhone 7 (Jet Black)", "Smartphone", "Apple", 35_00, 17_999);
        Product product3= new Product("iPhone 7 (Jet Black)", "Smartphone", "Apple", 35_00, 17_999);
        System.out.println(product1.equals(product3));
        product1.setImageURL("http://urlid.ru/audh");
        product1.setSpecification("");
        Product product2 = new Product("iPhone 5 (Jet Black)", "Smartphone", "Apple", 35_00, 17_999);
        product2.setImageURL("http://urlid.ru/audh");
        product2.setSpecification("");


        productService.addProduct(product1);
        productService.addProduct(product1);
        productService.addProduct(product1);
        productService.addProduct(product2);

        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        orderService.addOrder(order1);

        Order order2 = new Order();
        order2.addProduct(product1);
        order2.addProduct(product2);
        orderService.addOrder(order2);

        System.out.println("Finish!");
    }
}
