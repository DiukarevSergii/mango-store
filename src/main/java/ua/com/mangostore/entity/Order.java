package ua.com.mangostore.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "Orders")
public class Order {
    /**
     * Уникальный код обьекта.
     * Аннотация @Id говорит о том что поле является ключем для текущего объекта,
     * Аннотация @GeneratedValue говорит о том что значение генерируется автоматически.
     * Значение поля сохраняется в колонке "ORDER_ID".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long orderId;

    /**
     * Общая стоимость заказа. Значение поля сохраняется в колонке "ORDER_PRICE". Не может быть null.
     */
    @Column(nullable = false, name = "ORDER_PRICE")
    private double orderPrice;

    /**
     * Общая стоимость заказа со скидкой. Значение поля сохраняется в колонке "ORDER_PRICE_WITH_DISCOUNT".
     * Может быть null.
     */
    @Column(nullable = false, name = "ORDER_PRICE_WITH_DISCOUNT")
    private double orderPriceWithDiscount;

    /**
     * Сумма скидки для заказа. Значение поля сохраняется в колонке "ORDER_DISCOUNT". Может быть null.
     */
    @Column(name = "ORDER_DISCOUNT")
    private int orderDiscount;

    /**
     * Дата создания заказа. Значение поля сохраняется в колонке "DATE_CREATED". Не может быть null.
     */
    @Column(nullable = false, name = "DATE_CREATED")
    private String dateCreated;

    /**
     * Номер заказа. Значение поля сохраняется в колонке "number". Не может быть null.
     */
    @Column(name = "NUMBER", nullable = false)
    private String number;

    @OneToOne(mappedBy = "order")
    private Delivery delivery;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
//    List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    /**
     * Список торговых позиция текущего заказу.
     * К текущему заказу можно добраться через поле "order"
     * в объекте класса {@link SalePosition}.
     * Выборка продаж при первом доступе к текущему объекту.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<SalePosition> salePositions = new ArrayList<>();

    public Order() {
        this.dateCreated = LocalDate.now().toString();
        this.number = createNumberOfOrder();
    }

    /**
     * Набор вожможных символов для использованния по-умолчанию.
     */

    protected static final char[] NUMBER_PATTERN = {
            'M', 'A', 'N', 'G', 'O', 'S', 'T', 'R', 'E',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private String createNumberOfOrder() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int number = new Random().nextInt(NUMBER_PATTERN.length);
            char ch = NUMBER_PATTERN[number];
            builder.append(ch);
        }
        return builder.toString();
    }

//      public void addProduct(Product product){
//          products.add(product);
//          if(product.getOrder() != this){
//              product.setOnMain("");
//              product.setQuantity(1);
//              product.setOrder(this);
//          } else {
//              product.setQuantity(product.getQuantity() + 1);
//
//          }
//          setOrderQuantity(products.size());
//          setOrderPrice(getOrderPrice() + product.getFullPrice());
//      }




    /**
     * Добавляет торговую позицию в текущий заказа.
     *
     * @param salePosition Торговая позиция, которая будет добавлена в заказ.
     */
    public void addSalePosition(SalePosition salePosition) {
        salePositions.add(salePosition);
        if (salePosition.getOrder() != this) {
            salePosition.setOrder(this);
        }
    }

    /**
     * Добавляет список торговых позиций в текущий заказ.
     *
     * @param salePositions Список торговых позиций, которые будут дабавлены в заказ.
     */
    public void addSalePositions(List<SalePosition> salePositions) {
        this.salePositions.addAll(salePositions);
        for (SalePosition salePosition : salePositions) {
            if (salePosition.getOrder() != this) {
                salePosition.setOrder(this);
            }
        }
    }

    /**
     * Удаляет торговую позицию из текущего заказа.
     *
     * @param salePosition Торговая позиция, которая будет удалена из заказу.
     */
    public void removeSalePosition(SalePosition salePosition) {
        salePositions.remove(salePosition);
    }

    /**
     * Удаляет список торговых позиция из текущего заказа.
     *
     * @param salePositions Список торговых позиция, которые будут удалены из заказа.
     */
    public void removeSalePositions(List<SalePosition> salePositions) {
        this.salePositions.removeAll(salePositions);
    }

    /**
     * Очищает список торговых позиция текущего заказа.
     */
    public void clearSalePositions() {
        salePositions.clear();
    }

    /**
     * Конвертирует список торговых позиций текущего заказа в список
     * только для чтений и возвращает его.
     *
     * @return Объект типа {@link List} - список торговых позиция только для чтения или пустой список.
     */
    public List<SalePosition> getSalePositions() {
        return Collections.unmodifiableList(salePositions);
    }

    /**
     * Устанавливает список торговых позицияй текущему заказу.
     *
     * @param salePositions Список торговых позиция.
     */
    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
        for (SalePosition salePosition : this.salePositions) {
            if (salePosition.getOrder() != this) {
                salePosition.setOrder(this);
            }
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getOrderPriceWithDiscount() {
        return orderPriceWithDiscount;
    }

    public void setOrderPriceWithDiscount(double orderPriceWithDiscount) {
        this.orderPriceWithDiscount = orderPriceWithDiscount;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double OrderPrice) {
        this.orderPrice = OrderPrice;
    }

    public int getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(int OrderDiscount) {
        this.orderDiscount = OrderDiscount;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public long getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", orderPriceWithDiscount=" + orderPriceWithDiscount +
                ", orderDiscount=" + orderDiscount +
                ", dateCreated='" + dateCreated + '\'' +
                ", delivery=" + delivery +
                ", employee=" + employee +
                '}';
    }
}