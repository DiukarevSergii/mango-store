package ua.com.mangostore.entity;

import ua.com.mangostore.model.ShoppingCart;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Класс описывает сущность "Торговая позиция".
 * Торговая позиция составляет товар и количество этого товара.
 * Аннотация @Entity говорит о том что объекты этого класса будет обрабатываться hibernate.
 * Аннотация @Table(name = "sales") указывает на таблицу "sales", в которой будут храниться объекты.
 *
 * @author Diukarev Sergii
 * @see Product
 * @see Order
 * @see ShoppingCart
 */
@Entity
@Table(name = "SalePosition")
public class SalePosition{

    @Id
    @GeneratedValue
    @Column(name = "SALE_POSITION_ID")
    private long salePositionId;


    /**
     * Товар текущей торговой позици.
     * Значение поля (id объекта product) сохраняется в колонке "product_id". Не может быть null.
     * Между объектами классов {@link Product}
     * и {@link SalePosition} связь один-к-одному, а именно каждая
     * запись в одной таблице напрямую связана с отдельной записью в другой таблице.
     * Выборка объекта product до первого доступа нему, при первом доступе к текущему объекту.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    /**
     * Количество товаров в текущей торговой позиции.
     * Значение поля сохраняется в колонке "description". Не может быть null.
     */
    @Column(name = "number", nullable = false)
    private int number;

    /**
     * Заказ, к которому относится текущая торговая позиция
     * Значение поля (id объекта order) сохраняется в колонке "ORDER_ID". Не может быть null.
     * Между объектами классов {@link Order} и
     * {@link SalePosition} связь многие-к-одному, а именно каждая
     * много заказов могут иметь одинаковый статус выполнения.
     * Выборка объекта order при первом доступе к нему.
     * Сущность order автоматически удаляется при удалении текущей.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    /**
     * Конструктр без параметров.
     */
    public SalePosition() {
        super();
        number = 0;
    }

    /**
     * Конструктор для инициализации основных переменных категории.
     *
     * @param product Товар текущей торговой позици.
     * @param number  Количество товаров в текущей торговой позиции.
     */
    public SalePosition(Product product, int number) {
        super();
        this.product = product;
        this.number = number;
    }

    public long getSalePositionId() {
        return salePositionId;
    }

    public void setSalePositionId(long salePositionId) {
        this.salePositionId = salePositionId;
    }

    /**
     * Возвращает общую стоимость торговой позиции (цена товара * количество).
     *
     * @return Значение типа double - цена торговой пзиции.
     */
    public double getPrice() {
        return product.getSalePrice() * number;
    }

    /**
     * Возвращает общую стоимость торговой позиции (цена товара * количество).
     *
     * @return Значение типа double - цена торговой пзиции.
     */
    public String getFormatPrice() {
        return Product.df.format(product.getSalePrice() * number);
    }

    /**
     * Увеличивает количество товаров в позиции на 1.
     */
    public void numberIncr() {
        number++;
    }

    /**
     * Возвращает товар текущей торговой позиции.
     *
     * @return Объект класса {@link Product} - товар позиции.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Устанавливает товар для текущей торговой позиции.
     *
     * @param product Товар для позиции.
     */
    public void setProduct(Product product) {
        this.product = product;
        number = product == null ? 0 : 1;
    }

    /**
     * Возвращает номер торговой позиции.
     *
     * @return Значение типа {@link String} - номер торговой позиции.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Устанавливает номер торговой позиции.
     * Если входной параметр меньше 0, тогда значение номера будет 0.
     *
     * @param number Номер торговой позиции.
     */
    public void setNumber(int number) {
        this.number = number > 0 ? number : 0;
    }

    /**
     * Возвращает заказ, которому пренадлежит текущая торговая позиция.
     *
     * @return Объект класса {@link Order} - заказ торговой позиции.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Устанавливает заказ, которому пренадлежит текущая торговая позиция.
     *
     * @param order Заказ торговой позиции.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalePosition that = (SalePosition) o;

        return product.equals(that.product);

    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }
}
