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

//            String productTitle, String type, String brandName,
//            int price, int quantity, boolean expected

            Products product1 = new Products("Meizu M2", "Smartphone", "Meizu", 4500, 34);
            Products product2 = new Products("Meizu M3", "Smartphone", "Meizu", 4000, 4);
            Products product3 = new Products("Meizu M3 Note", "Smartphone", "Meizu", 4550, 45);
            em.persist(product1);
            em.persist(product2);
            em.persist(product3);


//            int basketPrice, int basketQuantity, int basketDiscount
            Basket basket1 = new Basket(product1.getPrice(), 1, 0);
            Basket basket2 = new Basket(product1.getPrice(), 2, 10);
            em.persist(basket1);
            em.persist(basket2);

            basket1.setProducts(product1);
            basket1.setProducts(product2);
            basket2.setProducts(product2);
            basket1.setProducts(product3);


//            Department department = new Department();
//            department.setDepartmentName("Sales1");
//            em.persist(department);
//
//            Department department2 = new Department();
//            department2.setDepartmentName("Sales2");
//            em.persist(department2);
//
//            Employee emp1 = new Employee("Nina", "Mayers", "111");
//            Employee emp2 = new Employee("Tony", "Almeida", "222");
//            Employee emp3 = new Employee("Tony3", "Almeida3", "333");
//
//            emp1.setDepartment(department);
//            emp2.setDepartment(department);
//            emp3.setDepartment(department2);
//
//
//            em.persist(emp1);
//            em.persist(emp2);
//            em.persist(emp3);

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
