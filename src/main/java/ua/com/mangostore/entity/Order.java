package ua.com.mangostore.entity;

import ua.com.mangostore.entity.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Класс описывает сущность "Заказ".
 * Аннотация @Entity говорит о том что объекты этого класса будет обрабатываться Hibernate.
 * Аннотация @Table(name = "Orders") указывает на таблицу "Orders", в которой будут храниться объекты.
 *
 * @author Diukarev Sergii
 */
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
     * Номер заказа. Значение поля сохраняется в колонке "number". Не может быть null.
     */
    @Column(name = "NUMBER", nullable = false)
    private String number;

    /**
     * Статус заказа. Значение поля сохраняется в колонке "status". Не может быть null.
     */
    @Column(name = "STATUS", nullable = false)
    private Status status;

    /**
     * Общая стоимость заказа. Значение поля сохраняется в колонке "ORDER_PRICE". Не может быть null.
     */
    @Column(nullable = false, name = "ORDER_PRICE")
    private double orderPrice;

    /**
     * Дата создания заказа. Значение поля сохраняется в колонке "DATE_CREATED". Не может быть null.
     */
    @Column(nullable = false, name = "DATE_CREATED")
    private String dateCreated;

    /**
     * Время создания заказа. Значение поля сохраняется в колонке "TIME_CREATED". Не может быть null.
     */
    @Column(nullable = false, name = "TIME_CREATED")
    private String timeCreated;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;

    /**
     * Покупатель, оформивший заказ.
     * Между объектами классов {@link Order} и
     * {@link Customer} связь один-ко-многим, а именно каждая
     * запись в одной таблице напрямую связана с одной или несколькими записями в другой таблице.
     * Выборка объекта customer до первого доступа к нему, при первом доступе к текущему объекту.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    /**
     * Покупатель, оформивший заказ.
     * Между объектами классов {@link Order} и
     * {@link Employee} связь один-ко-многим, а именно каждая
     * запись в одной таблице напрямую связана с одной или несколькими записями в другой таблице.
     * Выборка объекта employee при первом доступа к нему.
     */
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

    /**
     * Конструктр без параметров.
     * Автоматически инициализируются поля номер, дата и время создания заказа, статуса заказа.
     */
    public Order() {
        this.setDateCreated(LocalDate.now());
        this.setTimeCreated(LocalTime.now());
        this.number = createNumberOfOrder();
        this.status = Status.NEW;
    }

    /**
     * Набор вожможных символов для использованния по-умолчанию.
     */
    protected static final char[] NUMBER_PATTERN = {
            'M', 'A', 'N', 'G', 'O', 'S', 'T', 'R', 'E',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    /**
     * Возвращает рандомную строку используя набор символов NUMBER_PATTERN.
     *
     * @return Значение типа {@link String} - рандомная строка из набора символов NUMBER_PATTERN.
     */
    private String createNumberOfOrder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = new Random().nextInt(NUMBER_PATTERN.length);
            char ch = NUMBER_PATTERN[number];
            builder.append(ch);
        }
        return builder.toString();
    }

    /**
     * Добавляет торговую позицию в текущий заказа.
     *
     * @param salePosition Торговая позиция, которая будет добавлена в заказ.
     */
    public void addSalePosition(SalePosition salePosition) {
        if (salePositions.contains(salePosition)) {
            for (SalePosition position : salePositions) {
                if (position.equals(salePosition)) {
                    position.setNumber(position.getNumber() + salePosition.getNumber());
                }
            }
        } else {
            salePositions.add(salePosition);
        }
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

    /**
     * Возвращает номер заказа.
     *
     * @return Значение типа {@link String} - номер заказа.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Устанавливает номер заказа.
     *
     * @param number номер заказа.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Возвращает сотрудника, связанного с заказом.
     *
     * @return Значение типа {@link Employee} - сотрудник, связанного с заказом.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Устанавливает сотрудника, связанного с заказом.
     *
     * @param employee сотрудник, связанного с заказом.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Возвращает покупателя, сделавшего заказ.
     *
     * @return Значение типа {@link Customer} - покупатель, сделавший заказ.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Устанавливает покупателя, связанного с заказом.
     *
     * @param customer покупателя, связанного с заказом.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Возвращает статус заказа.
     *
     * @return Значение типа {@link Status} - статус заказа.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Устанавливает статус заказа.
     *
     * @param status статус заказа.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Возвращает общую стоимость заказа.
     *
     * @return Значение типа {@link double} - стоимость заказа.
     */
    public double getOrderPrice() {
        return orderPrice;
    }

    /**
     * Устанавливает общую стоимость заказа.
     *
     * @param orderPrice стоимость заказа.
     */
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Возвращает доставку связанную с заказом.
     *
     * @return Значение типа {@link Delivery} - доставка связанная с заказом.
     */
    public Delivery getDelivery() {
        return delivery;
    }

    /**
     * Устанавливает доставку связанную с заказом.
     *
     * @param delivery доставка связанная с заказом.
     */
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    /**
     * Возвращает уникальный код объекта.
     *
     * @return Значение типа {@link long} - уникальный код объекта.
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Возвращает дату создания заказа.
     *
     * @return Значение типа {@link String} - дата создания заказа.
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * Устанавливает дату создания заказа.
     *
     * @param dateCreated дату создания заказа.
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Устанавливает дату создания заказа.
     *
     * @param localDate дату создания заказа.
     */
    public void setDateCreated(LocalDate localDate) {
        this.dateCreated = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    /**
     * Возвращает время создания заказа.
     *
     * @return Значение типа {@link String} - время создания заказа.
     */
    public String getTimeCreated() {
        return timeCreated;
    }

    /**
     * Устанавливает время создания заказа.
     *
     * @param timeCreated времясоздания заказа.
     */
    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    /**
     * Устанавливает время создания заказа.
     *
     * @param localTime времясоздания заказа.
     */
    public void setTimeCreated(LocalTime localTime) {
        this.timeCreated = localTime.format(DateTimeFormatter.ofPattern("H:mm"));
    }

    /**
     * Возвращает описание заказа.
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link String} - строка описание заказа (номер, статус, стоимтость,
     * дата, время, информация о доставке, информация о покупателе, информация о сотруднике.
     */
    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", status=" + status +
                ", orderPrice=" + orderPrice +
                ", dateCreated='" + dateCreated + '\'' +
                ", timeCreated='" + timeCreated + '\'' +
                ", delivery=" + delivery +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}