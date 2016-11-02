package ua.com.mangostore.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ua.com.mangostore.entity.Product;

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
 * @see Product
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingBasket implements Serializable {
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Список торговых позиций, которые сделал клиент, но пока не оформил заказ.
     */
    private List<Product> productsInBasket = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public ShoppingBasket() {
    }

    /**
     * Конструктор для инициализации основных переменных корзины.
     *
     * @param productsInBasket Торговые позиции, добавленные клиентом в корзину.
     */
    public ShoppingBasket(List<Product> productsInBasket) {
        this.productsInBasket = productsInBasket;
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
        if (productsInBasket != null && !productsInBasket.isEmpty()) {
            int count = 1;
            for (Product product : productsInBasket) {
                sb.append("\n").append(count++).append(") ").append(product.getProductTitle())
                        .append("\n№ ").append(product.getProductId())
                        .append(", ").append(product.getSalePrice()).append(" UAH");
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
     * @param product Торговая позиция, которая будет добавлена в корзину.
     */
    public void addProduct(Product product) {
        if (product != null) {
            if (!productsInBasket.contains(product)) {
                productsInBasket.add(product);
                product.setQuantity(1);
            } else {
                product.setQuantity(product.getQuantity() + 1);
            }
        }
    }

    /**
     * Добавляет список торговых позиций в список корзины.
     *
     * @param productsInBasket Список торговых позиций, которые будут добавлены в корзину.
     */
    public void addProductsInBasket(List<Product> productsInBasket) {
        for (Product product : productsInBasket) {
            addProduct(product);
        }
    }

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param product Торговая позиция для удаления из корзины.
     */
    public void removeProduct(Product product) {
        productsInBasket.remove(product);
    }

    /**
     * Удаляет список торговых позицый из корзины.
     *
     * @param productsInBasket Торговые позиции для удаления из корзины.
     */
    public void removeProductsInBasket(List<Product> productsInBasket) {
        this.productsInBasket.removeAll(productsInBasket);
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    public void clearProductsInBasket() {
        productsInBasket.clear();
    }

    /**
     * Возвращает список всех торговых позиций в корзине.
     * Метод конвертирует список торговых позиций в корзине в список только для чтений и возвращает его.
     *
     * @return Объект типа {@link List} - список торговых позиций только для чтения или пустой список.
     */
    public List<Product> getProductsInBasket() {
        return productsInBasket == null || productsInBasket.isEmpty()
                ? Collections.EMPTY_LIST
                : Collections.unmodifiableList(productsInBasket);
    }

    /**
     * Устанавливает список торговых позиций.
     *
     * @param productsInBasket Список торговых позиций .
     */
    public void setProductsInBasket(List<Product> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    /**
     * Возвращает цену корзины - цена всех торговых позиций.
     *
     * @return Значение типа double - цена корзины.
     */
    public double getPrice() {
        double sum = 0;
        for (Product product : productsInBasket) {
            sum += product.getSalePrice();
        }
        return sum;
    }

    /**
     * Возвращает размер корзины - количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    public int getSize() {
        int size = 0;
        for (Product product : productsInBasket) {
            size += product.getQuantity();
        }
        return size;
    }
}
