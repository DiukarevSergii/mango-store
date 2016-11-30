package ua.com.mangostore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.mangostore.repository.ShoppingCartRepository;
import ua.com.mangostore.entity.SalePosition;
import ua.com.mangostore.model.ShoppingCart;

import java.util.List;

/**
 * Класс реализует методы интерфейса {@link ShoppingCartRepository} для работы с корзиной.
 *
 * @author Diukarev Sergii
 * @see ShoppingCartRepository
 * @see ShoppingCart
 */
@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {
    /**
     * Объект корзина, в которой хранятся торговые позиции клиента.
     */
    private ShoppingCart shoppingCart;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     *
     * @param shoppingCart Объект класса {@link ShoppingCart} для работы с товарной корзиной.
     */
    @Autowired
    public ShoppingCartRepositoryImpl(ShoppingCart shoppingCart) {
        super();
        this.shoppingCart = shoppingCart;
    }

    /**
     * Возвращает список всех торговых позиций в корзине.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    @Override
    public List<SalePosition> getSalePositions() {
        return shoppingCart.getSalePositions();
    }

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param salePosition Торговая позиция, которая будет добавлена в корзину.
     */
    @Override
    public void addSalePosition(SalePosition salePosition) {
        shoppingCart.addSalePosition(salePosition);
    }

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param salePosition Торговая позиция для удаления из корзины.
     */
    @Override
    public void removeSalePosition(SalePosition salePosition) {
        shoppingCart.removeSalePosition(salePosition);
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    @Override
    public void clearSalePositions() {
        shoppingCart.clearSalePositions();
    }

    /**
     * Возвращает объект-корзину целиком.
     *
     * @return Объект класса {@link ShoppingCart} - корзина.
     */
    @Override
    public ShoppingCart get() {
        return shoppingCart;
    }

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    @Override
    public int getSize() {
        return shoppingCart.getSize();
    }

    /**
     * Возвращает цену корзины - цена всех продаж.
     *
     * @return Значение типа double - цена корзины.
     */
    @Override
    public double getPrice() {
        return shoppingCart.getPrice();
    }

    /**
     * Возвращает цену корзины в отформатированном виде- цена всех продаж.
     *
     * @return Значение типа String - цена корзины в отформатированном виде.
     */
    @Override
    public String getFormatPrice(){
        return shoppingCart.getFormatPrice();
    }
}
