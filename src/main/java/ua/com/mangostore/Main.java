package ua.com.mangostore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

            order.setNameRecipient("Simon");
            order.setSurnameRecipient("Fourcade");
            order.setAddressRecipient("Paris");

            Order order2 = new Order();
            order2.addProduct(product3);

            initOrder(order2);

            order2.setNameRecipient("Marten");
            order2.setSurnameRecipient("Fourcade");
            order2.setAddressRecipient("Paris");

            em.persist(order);
            em.persist(order2);

            System.out.println("------------Then-------------------");

            Query query = em.createQuery("SELECT b FROM Order b", Order.class);
            List<Order> basketList = query.getResultList();
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
