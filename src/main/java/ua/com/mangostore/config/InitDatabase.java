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
        product1.setImageURL("https://raw.githubusercontent.com/DiukarevSergii/MangoStore/master/src/main/webapp/WEB-INF/img/apple-iphone-7.jpg");
        product1.setSpecification("");
        product1.setOnMain("Y");

        Product product2 = new Product("Samsung Galaxy S6", "Смартфоны", "Samsung", 18_000, 11_199);
        product2.setImageURL("http://urlid.ru/audg");
        product2.setSpecification("");
        product2.setOnMain("Y");

        Product product3 = new Product("Meizu M3 Note", "Смартфоны", "Apple", 4_099, 2_299);
        product3.setImageURL("http://urlid.ru/audi");
        product3.setSpecification("");
        product3.setOnMain("Y");

        Product product4 = new Product("Apple iPad Air 2", "Планшеты", "Apple", 12_000, 10_999);
        product4.setImageURL("http://urlid.ru/audk");
        product4.setSpecification("");
        product4.setOnMain("Y");

        Product product5 = new Product("Xiaomi MiPad 2", "Планшеты", "Xiaomi", 4_700, 3_999);
        product5.setImageURL("http://urlid.ru/audl");
        product5.setSpecification("");
        product5.setOnMain("Y");

        Product product6 = new Product("Samsung Galaxy Tab S2", "Планшеты", "Samsung", 5_000, 3_999);
        product6.setImageURL("http://urlid.ru/audm");
        product6.setSpecification("");
        product6.setOnMain("Y");

        productService.addProduct(product1);
        productService.addProduct(product2);
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

//        Order order2 = new Order();
//        order2.addProduct(product1);
//        order2.addProduct(product2);
//        orderService.addOrder(order2);

        System.out.println("Finish!");
    }
}
