package ua.com.mangostore.service;

import ua.com.mangostore.entity.SalePosition;
import ua.com.mangostore.model.ShoppingCart;

import java.util.List;

/**
 * Интерфейс сервисного слоя для работы с торговой корзиной.
 * Представляет методы с торговой корзиной и торговыми позициями,
 * которые оформляет клиент.
 *
 * @author Diukarev Sergii
 * @see ShoppingCart
 */
public interface ShoppingCartService {

    /**
     * Возвращает объект корзину.
     * @return Объект класса {@link ShoppingCart} - торговая корзина.
     */
    ShoppingCart getShoppingCart();

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param salePosition Торговая позиция, которая будет добавлена в корзину.
     */
    void add(SalePosition salePosition);

    /**
     * Возвращает список всех торговых позиций в корзине.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    List getSalePositions();

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param salePosition Торговая позиция для удаления из корзины.
     */
    void remove(SalePosition salePosition);

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
     * Возвращает цену корзины в отформатированном виде- цена всех продаж.
     *
     * @return Значение типа String - цена корзины в отформатированном виде.
     */
    public String getFormatPrice();

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    int getSize();
}
