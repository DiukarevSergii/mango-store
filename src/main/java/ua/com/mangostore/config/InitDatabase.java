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


//        Product product1 = new Product("iPhone 7 (Jet Black)", "Смартфоны", "Apple", 35_000, 17_999);
//        product1.setImageURL("http://urlid.ru/audh");
//        product1.setSpecification("");
//        product1.setOnMain("Y");
//
//        Product product2 = new Product("Samsung Galaxy S6", "Смартфоны", "Samsung", 18_000, 11_199);
//        product2.setImageURL("http://urlid.ru/audg");
//        product2.setSpecification("");
//        product2.setOnMain("Y");
//
//        Product product3 = new Product("Meizu M3 Note", "Смартфоны", "Apple", 4_099, 2_299);
//        product3.setImageURL("http://urlid.ru/audi");
//        product3.setSpecification("");
//        product3.setOnMain("Y");

        Product product1 = new Product("1", "Смартфоны", "Apple", 35_000, 17_999);
        product1.setImageURL("http://urlid.ru/audh");
        product1.setSpecification("");
        product1.setOnMain("Y");

        Product product2 = new Product("2", "Смартфоны", "Samsung", 18_000, 11_199);
        product2.setImageURL("http://urlid.ru/audg");
        product2.setSpecification("");
        product2.setOnMain("Y");

        Product product3 = new Product("3", "Смартфоны", "Apple", 4_099, 2_299);
        product3.setImageURL("http://urlid.ru/audi");
        product3.setSpecification("");
        product3.setOnMain("Y");

        Product product4 = new Product("4", "Смартфоны", "Apple", 35_000, 17_999);
        product4.setImageURL("http://urlid.ru/audh");
        product4.setSpecification("");
        product4.setOnMain("Y");

        Product product5 = new Product("5", "Смартфоны", "Apple", 35_000, 17_999);
        product5.setImageURL("http://urlid.ru/audh");
        product5.setSpecification("");
        product5.setOnMain("Y");

        Product product6 = new Product("6", "Смартфоны", "Apple", 35_000, 17_999);
        product5.setImageURL("http://urlid.ru/audh");
        product5.setSpecification("");
        product5.setOnMain("Y");

        Product product7 = new Product("7", "Смартфоны", "Apple", 35_000, 17_999);
        product5.setImageURL("http://urlid.ru/audh");
        product5.setSpecification("");
        product5.setOnMain("Y");

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);
        productService.addProduct(product5);
        productService.addProduct(product6);
        productService.addProduct(product7);

//        Product product8 = new Product("8", "Смартфоны", "Apple", 35_000, 17_999);
//        Product product9 = new Product("9", "Смартфоны", "Apple", 35_000, 17_999);
//        Product product10 = new Product("10", "Смартфоны", "Apple", 35_000, 17_999);
//
//        productService.addProduct(product8);
//        productService.addProduct(product9);
//        productService.addProduct(product10);


//        Order order1 = new Order();
//        order1.addProduct(product1);
//        order1.addProduct(product1);
//        order1.addProduct(product2);
//        orderService.addOrder(order1);
//
//        Order order2 = new Order();
//        order2.addProduct(product1);
//        order2.addProduct(product2);
//        orderService.addOrder(order2);

        System.out.println("Finish!");
    }
}
