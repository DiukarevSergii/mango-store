package ua.com.mangostore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.mangostore.dao.ShoppingBasketDAO;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.model.ShoppingBasket;

import java.util.List;

/**
 * Класс реализует методы интерфейса {@link ShoppingBasketDAO} для работы с корзиной.
 *
 * @author Diukarev Sergii
 * @see ShoppingBasketDAO
 * @see ShoppingBasket
 */
@Repository
public class ShoppingBasketDAOImpl implements ShoppingBasketDAO {
    /**
     * Объект корзина, в которой хранятся торговые позиции клиента.
     */
    private ShoppingBasket shoppingBasket;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     *
     * @param shoppingBasket Объект класса {@link ShoppingBasket} для работы с товарной корзиной.
     */
    @Autowired
    public ShoppingBasketDAOImpl(ShoppingBasket shoppingBasket) {
        super();
        this.shoppingBasket = shoppingBasket;
    }

    /**
     * Возвращает список всех торговых позиций в корзине.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    @Override
    public List<Product> getProductsInBasket() {
        return shoppingBasket.getProductsInBasket();
    }

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param product Торговая позиция, которая будет добавлена в корзину.
     */
    @Override
    public void addProduct(Product product) {
        shoppingBasket.addProduct(product);
    }

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param product Торговая позиция для удаления из корзины.
     */
    @Override
    public void removeProduct(Product product) {
        shoppingBasket.removeProduct(product);
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    @Override
    public void clearProductsInBasket() {
        shoppingBasket.clearProductsInBasket();
    }

    /**
     * Возвращает объект-корзину целиком.
     *
     * @return Объект класса {@link ShoppingBasket} - корзина.
     */
    @Override
    public ShoppingBasket get() {
        return shoppingBasket;
    }

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    @Override
    public int getSize() {
        return shoppingBasket.getSize();
    }

    /**
     * Возвращает цену корзины - цена всех продаж.
     *
     * @return Значение типа double - цена корзины.
     */
    @Override
    public double getPrice() {
        return shoppingBasket.getPrice();
    }
}
