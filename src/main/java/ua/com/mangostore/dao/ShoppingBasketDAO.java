package ua.com.mangostore.dao;

import ua.com.mangostore.entity.Product;
import ua.com.mangostore.model.ShoppingBasket;

import java.util.List;

/**
 * Интерфейс описывает набор методов для работы объектов класса {@link ShoppingBasket}.
 *
 * @author Yurii Salimov
 * @see ShoppingBasketDAOImpl
 * @see Product
 */
public interface ShoppingBasketDAO {
    /**
     * Возвращает список всех торговых позиций в корзине.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    List<Product> getProductsInBasket();

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param product Торговая позиция, которая будет добавлена в корзину.
     */
    void addProduct(Product product);

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param product Торговая позиция для удаления из корзины.
     */
    void removeProduct(Product product);

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    void clearProductsInBasket();

    /**
     * Возвращает объект-корзину целиком.
     *
     * @return Объект класса {@link ShoppingBasket} - корзина.
     */
    ShoppingBasket get();

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    int getSize();

    /**
     * Возвращает цену корзины - цена всех торговых позиций.
     *
     * @return Значение типа double - цена корзины.
     */
    double getPrice();
}
