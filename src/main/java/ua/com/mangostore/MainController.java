package ua.com.mangostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.config.InitDatabase;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.model.GroupOfProducts;
import ua.com.mangostore.service.OrderService;
import ua.com.mangostore.service.ProductService;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс-контроллер основных страниц. К даному контроллеру и соответствующим
 * страницам могут обращатсья все пользователи, независимо от ихних ролей.
 * Аннотация @Controller служит для сообщения Spring'у о том, что данный класс
 * является bean'ом и его необходимо подгрузить при старте приложения.
 * Методы класса работают с объектом, возвращенным handleRequest методом, является
 * типом {@link ModelAndView}, который агрегирует все параметры модели и имя отображения.
 * Этот тип представляет Model и View в MVC шаблоне.
 *
 * @author Diukarev Sergii
 * @see InitDatabase
 * @see Product
 * @see ProductService
 * @see GroupOfProducts
 * @see OrderService
 */
@Controller
public class MainController {

    /**
     * Объект сервиса для работы с заказами.
     */
    private OrderService orderService;
    /**
     * Объект сервиса для работы с товарами.
     */
    private ProductService productService;

    /**
     * Объект {@link DecimalFormat} для  форматирования десятичных чисел.
     */
    static DecimalFormat df = new DecimalFormat();

    {
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setZeroDigit('0');
        decimalFormatSymbols.setGroupingSeparator(' ');

        df.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    /**
     * Конструктор для инициализации основных переменных контроллера главных страниц сайта.
     * Помечен аннотацией @Autowired, которая позволит Spring автоматически инициализировать объекты.
     *
     * @param productService Объект сервиса для работы с товарами.
     * @param orderService   Объект сервиса для работы с заказами.
     */
    @Autowired
    public MainController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    /**
     * Возвращает главную cтраницу сайта "index". Для формирования страницы с базы подгружаются
     * категории товаров отмеченных при старте в {@link InitDatabase}.
     * URL запроса {"/"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", orderService.getSize());
        modelAndView.addObject("title", "Лидеры продаж");

        List<GroupOfProducts> groupOfProducts = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (product.getOnMain().equals("Y")) {
                GroupOfProducts productOnMain = new GroupOfProducts();
                productOnMain.setProductTitle(product.getProductTitle());
                productOnMain.setImageURL(product.getImageURL());
                productOnMain.setType(product.getType());
                productOnMain.setBrand(product.getBrand());
                productOnMain.setSalePrice(df.format(product.getSalePrice()));
                productOnMain.setFullPrice(df.format(product.getFullPrice()));
                groupOfProducts.add(productOnMain);
            }
        }
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * Возвращает страницу "client/about" - страница описания компании.
     * URL запроса "/about", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String onAbout() {
        return "client/about";
    }

    /**
     * Возвращает страницу "client/stores_addresses" - страница описания адрессов магазинов компаниии.
     * URL запроса "/stores_addresses", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/stores_addresses", method = RequestMethod.GET)
    public String onAddresses() {
        return "client/stores_addresses";
    }

    /**
     * Возвращает страницу "client/sales" - страница описания товаров находящихся на распродаже.
     * URL запроса "/sales", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public String onShares() {
        return "client/sales";
    }

    /**
     * Возвращает страницу "client/payment" - страница описания способов оплаты товаров.
     * URL запроса "/payment", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String onPayment() {
        return "client/payment";
    }

    /**
     * Возвращает страницу "client/delivery" - страница описания доставки товаров.
     * URL запроса "/delivery", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/delivery", method = RequestMethod.GET)
    public String onDelivery() {
        return "client/delivery";
    }

    /**
     * Возвращает страницу "client/service-center" - страница описания сервис центров компании.
     * URL запроса "/service-center", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/service-center", method = RequestMethod.GET)
    public String onService() {
        return "client/service-center";
    }

    /**
     * Возвращает страницу "client/support" - страница описания тех поддержки.
     * URL запроса "/support", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String onSupport() {
        return "client/support";
    }

    /**
     * Возвращает страницу "client/firmware" - страница описания доступных версий для смартфонов.
     * URL запроса "/firmware", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/firmware", method = RequestMethod.GET)
    public String onFirmware() {
        return "client/firmware";
    }

    /**
     * Возвращает страницу "client/news" - страница описания новостей компании.
     * URL запроса "/news", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String onNews() {
        return "client/news";
    }

    /**
     * Возвращает страницу "client/review" - страница описания обзоров товаров компании.
     * URL запроса "/review", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String onReview() {
        return "client/review";
    }

    /**
     * Возвращает страницу "client/login" - страница описания входа в личный кабинет.
     * URL запроса "/login", метод GET.
     *
     * @return URL страницы.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String onLogin() {
        return "client/login";
    }

}


