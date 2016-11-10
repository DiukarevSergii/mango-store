package ua.com.mangostore.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.entity.SalePosition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс описывает корзину товаров.
 * Реализует интерфейс Serializable, может быть сериализован.
 * Помечен аннотациями @Component указывает, что клас является компонентом фреймворка Spring;
 * и @Scope - область видимости бина "session" (один экземпляр бина для каждой сессии).
 *
 * @author Diukarev Sergii
 * @see SalePosition
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Список торговых позиций, которые сделал клиент, но пока не оформил заказ.
     */
    private List<SalePosition> salePositions = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public ShoppingCart() {
        super();
    }

    /**
     * Конструктор для инициализации основных переменных корзины.
     *
     * @param salePositions Торговые позиции, сделаные клиентом.
     */
    public ShoppingCart(List<SalePosition> salePositions) {
        super();
        this.salePositions = salePositions;
    }

    /**
     * Возвращает описание корзины.
     * Переопределенный метод родительского класса {@link Object}.
     *
     * @return Значение типа {@link String} - строка описание корзины
     * (информация о торговых позициях, цена корзины).
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shoping Cart: ");
        if (salePositions != null && !salePositions.isEmpty()) {
            int count = 1;
            for (SalePosition salePosition : salePositions) {
                sb.append("\n").append(count++).append(") ").append(salePosition.getProduct().getProductTitle())
                        .append("\n№ ").append(salePosition.getProduct().getProductId())
                        .append(", ").append(salePosition.getPrice()).append(" UAH");
            }
            sb.append("\nPrice: ").append(getPrice()).append(" UAH");
        } else {
            sb.append("is empty!");
        }
        return sb.toString();
    }

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param salePosition Торговая позиция, которая будет добавлена в корзину.
     */
    public void addSalePosition(SalePosition salePosition) {
        if (salePosition != null) {
            if (!salePositions.contains(salePosition)) {
                salePositions.add(salePosition);
            } else {
                int index = salePositions.indexOf(salePosition);
                salePositions.get(index).numberIncr();
            }
        }
    }

    /**
     * Добавляет список торговых позиций в список корзины.
     *
     * @param salePositions Список торговых позиций, которые будут добавлены в корзину.
     */
    public void addSalePositions(List<SalePosition> salePositions) {
        for (SalePosition salePosition : salePositions) {
            addSalePosition(salePosition);
        }
    }

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param salePosition Торговая позиция для удаления из корзины.
     */
    public void removeSalePosition(SalePosition salePosition) {
        salePositions.remove(salePosition);
    }

    /**
     * Удаляет список торговых позицый из корзины.
     *
     * @param salePositions Торговые позиции для удаления из корзины.
     */
    public void removeSalePositions(List<SalePosition> salePositions) {
        this.salePositions.removeAll(salePositions);
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    public void clearSalePositions() {
        salePositions.clear();
    }

    /**
     * Возвращает список всех торговых позиций в корзине.
     * Метод конвертирует список торговых позиций в корзине в список только для чтений и возвращает его.
     *
     * @return Объект типа {@link List} - список торговых позиций только для чтения или пустой список.
     */
    public List<SalePosition> getSalePositions() {
        return salePositions == null || salePositions.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(salePositions);
    }

    /**
     * Устанавливает список торговых позиций.
     *
     * @param salePositions Список торговых позиций .
     */
    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
    }

    /**
     * Возвращает цену корзины - цена всех торговых позиций.
     *
     * @return Значение типа double - цена корзины.
     */
    public double getPrice() {
        double sum = 0;
        for (SalePosition salePosition : salePositions) {
            sum += salePosition.getPrice();
        }
        return sum;
    }

    /**
     * Возвращает цену корзины в отформатированном виде- цена всех продаж.
     *
     * @return Значение типа String - цена корзины в отформатированном виде.
     */
    public String getFormatPrice() {
        return Product.df.format(getPrice());
    }

    /**
     * Возвращает размер корзины - количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    public int getSize() {
        int size = 0;
        for (SalePosition salePosition : salePositions) {
            size += salePosition.getNumber();
        }
        return size;
    }

}
