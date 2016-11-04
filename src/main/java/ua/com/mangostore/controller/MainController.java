package ua.com.mangostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.config.InitDatabase;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.entity.SalePosition;
import ua.com.mangostore.service.OrderService;
import ua.com.mangostore.service.ProductService;
import ua.com.mangostore.service.ShoppingCartService;

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
 * @see OrderService
 * @see ShoppingCartService
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
     * Объект сервиса для работы с торговой корзиной.
     */
    private ShoppingCartService shoppingCartService;

    /**
     * Конструктор для инициализации основных переменных контроллера главных страниц сайта.
     * Помечен аннотацией @Autowired, которая позволит Spring автоматически инициализировать объекты.
     *
     * @param productService        Объект сервиса для работы с товарами.
     * @param orderService          Объект сервиса для работы с заказами.
     * @param shoppingCartService Объект сервиса для работы с торговой корзиной.
     */
    @Autowired
    public MainController(OrderService orderService, ProductService productService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
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
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Лидеры продаж");
        modelAndView.addObject("url", "/");
        List<Product> groupOfProducts = new ArrayList<>();
        Product sliderProduct = null;
        for (Product product : productService.getAll()) {
            if (!product.getOnMain().isEmpty()) {
                groupOfProducts.add(product);
            }
            if (product.getProductTitle().equals("Meizu MX6")) {
                sliderProduct = product;
            }
        }
        if (sliderProduct != null) {
            modelAndView.addObject("meizu_id", sliderProduct.getProductId());
            modelAndView.addObject("meizu_alt", sliderProduct.getProductTitle());
        }
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/samsung"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/samsung"}, method = RequestMethod.GET)
    public ModelAndView samsung(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Samsung");
        modelAndView.addObject("url", "/samsung");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByBrand(groupOfProducts, "Samsung");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/samsung/smartphones"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/samsung/smartphones"}, method = RequestMethod.GET)
    public ModelAndView samsungSmartphones(ModelAndView modelAndView) {
        getModelAndView(modelAndView, "Смартфоны", "/samsung/smartphones");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/samsung/tablet-pc"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/samsung/tablet-pc"}, method = RequestMethod.GET)
    public ModelAndView samsungTabletPC(ModelAndView modelAndView) {
        return getModelAndView(modelAndView, "Планшеты", "/samsung/tablet-pc");
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/samsung/tv"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/samsung/tv"}, method = RequestMethod.GET)
    public ModelAndView samsungTV(ModelAndView modelAndView) {
        getModelAndView(modelAndView, "Телевизоры", "/samsung/tv");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/samsung/accessories"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/samsung/accessories"}, method = RequestMethod.GET)
    public ModelAndView samsungAccessories(ModelAndView modelAndView) {
        getModelAndView(modelAndView, "Акссесуары", "/samsung/accessories");
        return modelAndView;
    }

    private ModelAndView getModelAndView(ModelAndView modelAndView, String type, String url) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", type + " от фирмы Samsung");
        modelAndView.addObject("url", url);
        List<Product> groupOfProducts = new ArrayList<>();
        groupByBrand(groupOfProducts, "Samsung");
        groupByType(type, groupOfProducts);
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/apple"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/apple"}, method = RequestMethod.GET)
    public ModelAndView apple(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Apple");
        modelAndView.addObject("url", "/apple");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByBrand(groupOfProducts, "Apple");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/apple/iphone"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/apple/iphone"}, method = RequestMethod.GET)
    public ModelAndView iphone(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "iPhone");
        modelAndView.addObject("url", "/apple/iphone");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByModel(groupOfProducts, "iphone", "apple");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/apple/ipad"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/apple/ipad"}, method = RequestMethod.GET)
    public ModelAndView ipad(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "iPad");
        modelAndView.addObject("url", "/apple/ipad");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByModel(groupOfProducts, "ipad", "apple");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/apple/mac"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/apple/mac"}, method = RequestMethod.GET)
    public ModelAndView mac(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "MacBook и iMac");
        modelAndView.addObject("url", "/apple/mac");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByModel(groupOfProducts, "mac", "apple");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/apple/accessories"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/apple/accessories"}, method = RequestMethod.GET)
    public ModelAndView appleAccessories(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Акссесуары для Apple");
        modelAndView.addObject("url", "/apple/accessories");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByType(groupOfProducts, "Акссесуары для Apple");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    private void groupByModel(List<Product> groupOfProducts, String model, String brand) {
        for (Product product : productService.getAll()) {
            if (product.getOrder() == null
                    && product.getProductTitle().toLowerCase().contains(model)
                    && product.getBrand().toLowerCase().contains(brand)) {
                groupOfProducts.add(product);
            }
        }
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/xiaomi"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/xiaomi"}, method = RequestMethod.GET)
    public ModelAndView xiaomi(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Xiaomi");
        modelAndView.addObject("url", "/apple/xiaomi");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByBrand(groupOfProducts, "Xiaomi");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/meizu"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/meizu"}, method = RequestMethod.GET)
    public ModelAndView lg(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Meizu");
        modelAndView.addObject("url", "/apple/meizu");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByBrand(groupOfProducts, "Meizu");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    private void groupByBrand(List<Product> groupOfProducts, String param) {
        for (Product product : productService.getAll()) {
            if (product.getOrder() == null && product.getBrand().equals(param)) {
                groupOfProducts.add(product);
            }
        }
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/tablet-pc"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/tablet-pc"}, method = RequestMethod.GET)
    public ModelAndView tablet(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Планшеты");
        modelAndView.addObject("url", "/tablet-pc");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByType(groupOfProducts, "Планшеты", "Акссесуары для планшетов");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/tablet-pc/accessories"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/tablet-pc/accessories"}, method = RequestMethod.GET)
    public ModelAndView tabletAccessories(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Акссесуары для планшетов");
        modelAndView.addObject("url", "/tablet-pc/accessories");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByType(groupOfProducts, "Акссесуары для планшетов");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/smartphones"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/smartphones"}, method = RequestMethod.GET)
    public ModelAndView smartphone(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Смартфоны");
        modelAndView.addObject("url", "/smartphones");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByType(groupOfProducts, "Смартфоны", "Акссесуары для смартфонов");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    /**
     * Возвращает cтраницу сайта "client/someProducts". Для формирования страницы с базы подгружаются
     * соответствующие товары.
     * URL запроса {"/smartphones/accessories"}, метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = {"/smartphones/accessories"}, method = RequestMethod.GET)
    public ModelAndView smartphoneAccessories(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Акссесуары для смартфонов");
        modelAndView.addObject("url", "/smartphones/accessories");
        List<Product> groupOfProducts = new ArrayList<>();
        groupByType(groupOfProducts, "Акссесуары для смартфонов");
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
    }

    private void groupByType(List<Product> groupOfProducts, String... param) {
        String param1 = param[0];
        String param2 = param.length > 1 ? param[1] : "";
        for (Product product : productService.getAll()) {
            if (product.getOrder() == null && (product.getType().equals(param1) || product.getType().equals(param2))) {
                groupOfProducts.add(product);
            }
        }
    }

    private void groupByType(String type, List<Product> groupOfProducts) {
        List<Product> groupByBrand = new ArrayList<>();
        for (Product product : groupOfProducts) {
            if (product.getOrder() == null && (product.getType().equals(type))) {
                groupByBrand.add(product);
            }
        }
        groupOfProducts.clear();
        groupOfProducts.addAll(groupByBrand);
    }

    /**
     * Возвращает страницу "client/product" с 1-м товаром с уникальним URL, который
     * совпадает с входящим параметром url. URL запроса "/product_{url}", метод GET.
     * В запросе в параметре url можно передавать как URL так и артикль товара.
     *
     * @param id           URL или id товара, который нужно вернуть на страницу.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/product-{id}", method = RequestMethod.GET)
    public ModelAndView viewProduct(@PathVariable("id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        Product product = productService.getById(id);
        modelAndView.addObject("title", product.getProductTitle());
        modelAndView.addObject("url", "product-" + id);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("client/product");
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
     * Возвращает страницу "client/someProducts" - страница описания товаров находящихся на распродаже.
     * URL запроса "/sales", метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public ModelAndView onSales(ModelAndView modelAndView) {
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("title", "Акции компании МАНГО");
        modelAndView.addObject("url", "/sales");
        List<Product> groupOfProducts = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (product.getOrder() == null && (product.getFullPrice() != product.getSalePrice())) {
                groupOfProducts.add(product);
            }
        }
        modelAndView.addObject("groupOfProducts", groupOfProducts);
        modelAndView.setViewName("client/someProducts");
        return modelAndView;
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

    /**
     * Возвращает страницу "client/cart" - страница корзины с торговыми позициями, которие сделал клиент.
     * URL запроса "/cart", метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView viewCart(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Моя корзина");
        modelAndView.addObject("cart_size", shoppingCartService.getSize());
        modelAndView.addObject("cart_price", shoppingCartService.getFormatPrice());
        modelAndView.addObject("productsInCart", shoppingCartService.getSalePositions());
        modelAndView.addObject("priceOfCart", shoppingCartService.getPrice());
        modelAndView.addObject("url", "/cart");
        modelAndView.setViewName("client/cart");
        return modelAndView;
    }

    /**
     * Добавляет товар с уникальным кодом id в корзину и перенаправляет по запросу "/cart".
     * URL запроса "/cart_add", метод POST.
     *
     * @param id           Код товара, который нужно добавить в корзину.
     * @param url          URL запроса для перенаправления.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/cart_add", method = RequestMethod.POST)
    public ModelAndView addProductToCart(@RequestParam long id, @RequestParam("url") String url,
                                           ModelAndView modelAndView) {
        SalePosition salePosition = new SalePosition(productService.getById(id), 1);
        shoppingCartService.add(salePosition);
        modelAndView.setViewName("redirect:" + url);
        return modelAndView;
    }

/**
 * Добавляет товар с уникальным кодом id в корзину и перенаправляет по запросу "/cart".
 * URL запроса "/cart_remove_position", метод POST.
 *
 * @param id           Код товара, который нужно добавить в корзину.
 * @param url          URL запроса для перенаправления.
 * @param modelAndView Объект класса {@link ModelAndView}.
 * @return Объект класса {@link ModelAndView}.
 */
    @RequestMapping(value = "/cart_remove_position", method = RequestMethod.POST)
    public ModelAndView removeProductFromCart(@RequestParam long id, @RequestParam("url") String url,
                                           ModelAndView modelAndView) {
        SalePosition salePosition = new SalePosition(productService.getById(id), 1);
        shoppingCartService.remove(salePosition);
        modelAndView.setViewName("redirect:" + url);
        return modelAndView;
    }
}


