package ua.com.mangostore.service;

import ua.com.mangostore.entity.Product;
import ua.com.mangostore.model.ShoppingBasket;

import java.util.List;

/**
 * Интерфейс сервисного слоя для работы с торговой корзиной.
 * Представляет методы с торговой корзиной и торговыми позициями,
 * которые оформляет клиент.
 *
 * @author Diukarev Sergii
 * @see ShoppingBasket
 */
public interface ShoppingBasketService {

    /**
     * Возвращает объект корзину.
     * @return Объект класса {@link ShoppingBasket} - торговая корзина.
     */
    ShoppingBasket getShoppingBasket();

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param product Торговая позиция, которая будет добавлена в корзину.
     */
    void add(Product product);

    /**
     * Возвращает список всех торговых позиций в корзине.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    List getProductsInBasket();

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param product Торговая позиция для удаления из корзины.
     */
    void remove(Product product);

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    void clear();

    /**
     * Возвращает цену корзины - цена всех продаж.
     *
     * @return Значение типа double - цена корзины.
     */
    double getPrice();

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    int getSize();
}
