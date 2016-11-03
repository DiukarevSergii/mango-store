package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.dao.ShoppingBasketDAO;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.exception.BadRequestException;
import ua.com.mangostore.model.ShoppingBasket;
import ua.com.mangostore.service.ShoppingBasketService;

import java.util.List;

/**
 * Класс сервисного слоя для работы с торговой корзиной.
 * Реализует методы интерфейса {@link ShoppingBasketService}.
 * Класс помечан аннотацией @Service - аннотация обьявляющая, что этот класс представляет
 * собой сервис – компонент сервис-слоя. Сервис является подтипом класса @Component.
 * Использование данной аннотации позволит искать бины-сервисы автоматически.
 * Методы класса помечены аннотацией @Transactional - перед исполнением метода помеченного
 * данной аннотацией начинается транзакция, после выполнения метода транзакция коммитится,
 * при выбрасывании RuntimeException откатывается.
 *
 * @author Yurii Salimov
 * @see ShoppingBasket
 * @see ShoppingBasketService
 * @see ShoppingBasketDAO
 */
@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    /**
     * Реализация интерфейса для работы з торговой корзиной.
     */
    private ShoppingBasketDAO shoppingBasketDAO;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring автоматически инициализировать объект.
     *
     * @param shoppingBasketDAO Реализация интерфейса для работы з торговой корзиной.
     */
    @Autowired
    public ShoppingBasketServiceImpl(ShoppingBasketDAO shoppingBasketDAO) {
        this.shoppingBasketDAO = shoppingBasketDAO;
    }

    /**
     * Возвращает объект корзину. Режим только для чтения.
     *
     * @return Объект класса {@link ShoppingBasket} - торговая корзина.
     * @throws BadRequestException Бросает исключение, если корзина отсутствует.
     */
    @Override
    @Transactional(readOnly = true)
    public ShoppingBasket getShoppingBasket() throws BadRequestException {
        ShoppingBasket shoppingBasket = shoppingBasketDAO.get();
        if (shoppingBasket == null) {
            throw new BadRequestException("Can't find shopping basket!");
        }
        return shoppingBasket;
    }

    /**
     * Добавляет торговую позицию в список корзины.
     *
     * @param product Торговая позиция, которая будет добавлена в корзину.
     */
    @Override
    @Transactional
    public void add(Product product) {
        if (product != null) {
            shoppingBasketDAO.addProduct(product);
        }
    }

    /**
     * Возвращает список всех торговых позиций в корзине. Режим только для чтения.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    @Transactional(readOnly = true)
    public List<Product> getProductsInBasket() {
        return shoppingBasketDAO.getProductsInBasket();
    }

    /**
     * Удаляет торговую позицию из корзины.
     *
     * @param product Торговая позиция для удаления из корзины.
     */
    @Override
    @Transactional
    public void remove(Product product) {
        if (product != null) {
            shoppingBasketDAO.removeProduct(product);
        }
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    @Override
    @Transactional
    public void clear() {
        shoppingBasketDAO.clearProductsInBasket();
    }

    /**
     * Возвращает цену корзины - цена всех продаж. Режим только для чтения.
     *
     * @return Значение типа double - цена корзины.
     */
    @Override
    @Transactional(readOnly = true)
    public double getPrice() {
        return shoppingBasketDAO.getPrice();
    }

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     * Режим только для чтения.
     *
     * @return Значение типа int - количество товаров в корзине.
     */
    @Override
    @Transactional(readOnly = true)
    public int getSize() {
        return shoppingBasketDAO.getSize();
    }
}