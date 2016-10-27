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

        Product product1 = new Product("iPhone 7 (Jet Black)", "Смартфоны", "Apple", 35_000, 17_999);
        product1.setImageURL("http://localhost:8080/resources/img/apple_iphone-7_400x480.jpg");
        product1.setSpecification("");
        product1.setOnMain("Y");

        Product product2 = new Product("Samsung Galaxy A7", "Смартфоны", "Samsung", 11_199, 7_999);
        product2.setImageURL("http://localhost:8080/resources/img/samsung_a710f_galaxy_a7_400x480.jpg");
        product2.setSpecification("");
        product2.setOnMain("Y");

        Product product3 = new Product("Meizu MX6", "Смартфоны", "Meizu", 15_099, 10_299);
        product3.setImageURL("http://localhost:8080/resources/img/meizu_mx6_400x480.jpg");
        product3.setSpecification("");
//        product3.setSpecification("icationspecifnspecification specificationspecifnspecification ");
        product3.setOnMain("");

        Product product4 = new Product("Apple iPad Air 2", "Планшеты", "Apple", 12_000, 10_999);
        product4.setImageURL("http://localhost:8080/resources/img/apple_ipad_air-2_400x480.jpg");
        product4.setSpecification("");
        product4.setOnMain("Y");

        Product product5 = new Product("Xiaomi MiPad 2", "Планшеты", "Xiaomi", 4_700, 3_999);
        product5.setImageURL("http://localhost:8080/resources/img/xiaomi_mipad_2_16Gb_400x480.jpg");
        product5.setSpecification("");
        product5.setOnMain("Y");

        Product product6 = new Product("Samsung Galaxy Tab S2", "Планшеты", "Samsung", 5_000, 3_999);
        product6.setImageURL("http://localhost:8080/resources/img/samsung_galaxy_tab_s2_400x480.jpg");
        product6.setSpecification("");
        product6.setOnMain("Y");
        product6.setSpecification("this is on main page");

        Product product7= new Product("Meizu M3s", "Смартфоны", "Meizu", 5_000, 3_999);
        product7.setImageURL("http://localhost:8080/resources/img/meizu_m3s_400x480.jpg");
        product7.setSpecification("");
        product7.setOnMain("Y");
        product7.setSpecification("this is not on main page");

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product7);
        productService.addProduct(product3);
        productService.addProduct(product4);
        productService.addProduct(product5);
        productService.addProduct(product6);

        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.addProduct(product5);
        order1.addProduct(product5);
        order1.addProduct(product5);
        orderService.addOrder(order1);

        Order order2 = new Order();
        order2.addProduct(product1);
        order2.addProduct(product2);
        orderService.addOrder(order2);

        System.out.println("Finish!");
    }
}
