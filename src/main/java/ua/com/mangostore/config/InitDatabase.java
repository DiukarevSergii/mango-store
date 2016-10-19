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
        product1.setImage("http://urlid.ru/audh");
        product1.setSpecification("");
        Product product2 = new Product("iPhone 5 (Jet Black)", "Smartphone", "Apple", 35_00, 17_999);
        product2.setImage("http://urlid.ru/audh");
        product2.setSpecification("");
//        Product product2 = new Product("Meizu M2", "Smartphone", "Meizu", 4500);
//        Product product3 = new Product("Meizu M3", "Smartphone", "Meizu", 4000);

        productService.addProduct(product1);
        productService.addProduct(product2);

//        productService.addProduct(product2);
//        productService.addProduct(product3);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        orderService.addOrder(order);
        orderService.addOrder(order);

        System.out.println("Finish!");
    }
}
