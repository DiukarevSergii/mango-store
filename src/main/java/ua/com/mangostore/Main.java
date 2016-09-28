package ua.com.mangostore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MangoStore");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Product product1 = new Product("Meizu M2", "Smartphone", "Meizu", 4500);
            Product product2 = new Product("Meizu M3", "Smartphone", "Meizu", 4000);
            Product product3 = new Product("Meizu M3 Note", "Smartphone", "Meizu", 4550);

            Order order = new Order();
            order.addProduct(product1);
            order.addProduct(product2);
            order.addProduct(product3);

            initOrder(order);

            Customer customer = new Customer();
            customer.setName("Simon");
            customer.setSurname("Fourcade");
            customer.setCity("Paris");
            customer.setAddress("por favor 19, apr.29");
            customer.setPhone("911");
            customer.setZipcode(75001);
            customer.addOrder(order);

            Order order2 = new Order();
            order2.addProduct(product3);

            initOrder(order2);

            Customer customer2 = new Customer();
            customer2.setName("Marten");
            customer2.setSurname("Fourcade");
            customer2.setCity("Paris");
            customer2.setAddress("por favor 19, apr.30");
            customer2.setPhone("911-45");
            customer2.setZipcode(75001);
            customer2.addOrder(order2);

            em.persist(customer);
            em.persist(customer2);

//            em.persist(order);
//            em.persist(order2);

            System.out.println("------------Then-------------------");

            Query query = em.createQuery("SELECT b FROM Order b", Order.class);
            List<Order> basketList = query.getResultList();
            for (Order b : basketList) {
                System.out.println(b);
            }
            System.out.println("------------Create delivery-------------------");
            Delivery delivery = new Delivery();
            delivery.setDeliveryDate(LocalDate.of(2016, 11, 1));
            delivery.setDeliveryTime(LocalTime.of(13, 0));
            delivery.setCost(45);
            delivery.setStatus("not delivered");
            delivery.setType("courier");

            delivery.setOrder(order2);
            order2.setDelivery(delivery);

//            em.persist(order2);
            em.persist(delivery);

            System.out.println("------------Show delivery-------------------");

            query = em.createQuery("SELECT d FROM Delivery d", Delivery.class);
            List<Delivery> deliveryList = query.getResultList();
            System.out.println(deliveryList.size());
            for (Delivery d: deliveryList) {
                System.out.println(d);
            }
            System.out.println("------------Show orders-------------------");
            query = em.createQuery("SELECT b FROM Order b", Order.class);
            basketList = query.getResultList();
            for (Order b : basketList) {
                System.out.println(b);
            }

            System.out.println("-----------Before commit------------");
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void initOrder(Order order) {
        double orderPrice = 0;
        int count = 0;
        for (Product product: order.getProducts()){
            orderPrice += product.getPrice();
            count++;
        }
        order.setOrderPrice(orderPrice);
        order.setOrderQuantity(count);
        if (orderPrice > 3000){
            order.setOrderDiscount(10);
            order.setOrderPriceWithDiscount(orderPrice * 0.9);
        } else {
            order.setOrderDiscount(0);
            order.setOrderPriceWithDiscount(orderPrice);
        }
    }
}
