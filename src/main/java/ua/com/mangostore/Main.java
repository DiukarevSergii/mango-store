package ua.com.mangostore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MangoStore");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

//            String productTitle, String type, String brandName,
//            int price, int quantity, boolean expected

            Product product1 = new Product("Meizu M2", "Smartphone", "Meizu", 4500, 34);
            Product product2 = new Product("Meizu M3", "Smartphone", "Meizu", 4000, 4);
            Product product3 = new Product("Meizu M3 Note", "Smartphone", "Meizu", 4550, 45);

            em.persist(product1);
            em.persist(product2);
            em.persist(product3);

//            int basketPrice, int basketQuantity, int basketDiscount
            Basket basket1 = new Basket(product1.getPrice(), 1, 0);

            List<Product> productList = new ArrayList<>();
            productList.add(product1);
            productList.add(product2);
            productList.add(product3);

            Basket basket2 = new Basket(product1.getPrice(), 22, 10);
            List<Product> productList2 = new ArrayList<>();
            productList2.add(product3);

            basket1.setProducts(productList);
            basket2.setProducts(productList2);

            em.persist(basket1);
            em.persist(basket2);

            em.getTransaction().commit();

            System.out.println("------------After commit--------------");

            Query query = em.createQuery("SELECT b FROM Basket b", Basket.class);
            List<Basket> basketList = query.getResultList();
            for (Basket b : basketList) {
                for (Product p : b.getProducts()) {
                    System.out.println(p);
                }
                System.out.println();
            }
            System.out.println("------------Change...--------------");

            product3.setQuantity(0);

            query = em.createQuery("SELECT b FROM Basket b", Basket.class);
            basketList = query.getResultList();
            for (Basket b : basketList) {
                for (Product p : b.getProducts()) {
                    System.out.println(p);
                }
                System.out.println();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
