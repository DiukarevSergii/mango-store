package ua.com.mangostore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MangoStore");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Product product1 = new Product("Meizu M2", "Smartphone", "Meizu", 4500, 34);
            Product product2 = new Product("Meizu M3", "Smartphone", "Meizu", 4000, 4);
            Product product3 = new Product("Meizu M3 Note", "Smartphone", "Meizu", 4550, 45);

            Basket basket1 = new Basket(product1.getPrice(), 1, 0);
            basket1.addProduct(product1);
            basket1.addProduct(product2);
            basket1.addProduct(product3);

            Basket basket2 = new Basket(product1.getPrice(), 22, 10);
            basket2.addProduct(product3);

            em.persist(basket1);
            em.persist(basket2);

            Order order = new Order("11", "22", "33");
            order.setBasket(basket1);
            em.persist(order);
//
//            System.out.println("------------After-------------------");
//
//            Query query = em.createQuery("SELECT b FROM Basket b", Basket.class);
//            List<Basket> basketList = query.getResultList();
//            for (Basket b : basketList) {
//                for (Product p : b.getProducts()) {
//                    System.out.println(p);
//                }
//                System.out.println();
//            }
//            System.out.println("------------Change...-----------------");
//
//            product3.setQuantity(0);
//
//            query = em.createQuery("SELECT b FROM Basket b", Basket.class);
//            basketList = query.getResultList();
//            for (Basket b : basketList) {
//                for (Product p : b.getProducts()) {
//                    System.out.println(p);
//                }
//                System.out.println();
//            }
            System.out.println("-----------Before commit------------");
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
