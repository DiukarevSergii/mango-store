package ua.com.mangostore.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ua.com.mangostore.entity.Order;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.service.OrderService;
import ua.com.mangostore.service.ProductService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@ComponentScan("ua.com.mangostore")
public class InitDatabase implements ApplicationListener<ContextRefreshedEvent> {
    @PersistenceContext
    protected EntityManager em;
    @Resource
    private ProductService productService;
    @Resource
    private OrderService orderService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Start init!");

        Product product1 = new Product("iPhone 7 Plus 32GB ", "Смартфоны", "Apple", 35_000, 17_999);
        product1.setImageURL("http://localhost:8080/resources/img/apple_iphone-7_400x480.jpg");
        product1.setOnMain("Y");
        product1.setDescription(
                "<h3 style=\"margin-top: 10px; margin-bottom: -5px\">Новое поколение легенды</h3>" +
                        "<p align=\"justify\">" +
                        "<br>" +
                        "В iPhone 7 все важнейшие аспекты iPhone значительно улучшены. Это принципиально новая система " +
                        "камер для фото- и видеосъёмки. Максимально мощный и экономичный аккумулятор iPhone. " +
                        "Стереодинамики с богатым звучанием. Самый яркий и разноцветный из всех дисплеев iPhone. " +
                        "Защита от брызг и воды. И его внешние данные впечатляют не менее, чем внутренние возможности. " +
                        "Всё это iPhone 7." +
                        "<br><br>" +
                        "iPhone 7 выходит на новый уровень инноваций и точности. Уникальный цвет «чёрный оникс». " +
                        "Корпус с защитой от брызг и воды. Полностью переработанная кнопка «Домой» и новый цельный дизайн " +
                        "unibody. С первого взгляда и первого прикосновения вы понимаете, насколько он великолепен." +
                        "<br><br>" +
                        "Два размера. Пять цветов." +
                        "<br><br>" +
                        "iPhone 7 и iPhone 7 Plus представлены в двух новых цветовых вариантах: благородный матовый чёрный" +
                        " и роскошный глубокий глянцевый «чёрный оникс». Обе модели — 4,7 и 5,5 дюйма — сделаны из " +
                        "невероятно прочного алюминия серии 7000 и доступны также в фирменных цветах «розовое золото», " +
                        "серебристый и золотой." +
                        "<br><br>" +
                        "Новый корпус глубокого чёрного цвета изготовлен из гладкого матированного алюминия. " +
                        "А для достижения глянцевого эффекта корпус цвета «чёрный оникс» подвергается высокоточному " +
                        "девятиступенчатому процессу анодирования и полировки.2 В результате получается настолько " +
                        "глубокий и равномерный чёрный цвет, что граница между стеклом и алюминием практически " +
                        "неразличима. Практически чёрная магия." +
                        "</p>");
        product1.setSpecification(
                "iOS", "Четырехъядерный Apple A10 Fusion с 64-битной архитектурой",
                "158.2 x 77.9 x 7.3 мм", "188 г", "5.5\"", "1920 x 1080",
                "двойная камера 12 Мп с широкоугольным и телеобъективом", "7 Мп");

        Product product2 = new Product("Samsung Galaxy A7", "Смартфоны", "Samsung", 11_199, 7_999);
        product2.setImageURL("http://localhost:8080/resources/img/samsung_a710f_galaxy_a7_400x480.jpg");
        product2.setSpecification("");
        product2.setOnMain("Y");

        Product product3 = new Product("Meizu MX6", "Смартфоны", "Meizu", 7_099, 5_299);
        product3.setImageURL("http://localhost:8080/resources/img/meizu_mx6_400x480.jpg");
        product3.setDescription(
                "<h3 style=\"margin-top: 10px; margin-bottom: -5px\">Камерофон</h3>" +
                        "<p align=\"justify\">" +
                        "<br>Компания Meizu представила свой новый цельнометаллический фото флагман – смартфон Meizu MX6, " +
                        "который имеет полностью металлический корпус, с минимальным пространством, выделенным для " +
                        "вывода антенн, впитав в себя лучшее из дизайна невероятно красивого Meizu Pro 6. При создании " +
                        "корпуса использовались новые технологии обработки металла, позволившие добиться столь " +
                        "впечатляющего и элегантного внешнего вида, сохранив при этом прочность конструкции и удобство " +
                        "использования смартфона. Традиционно, для пользователей доступна многофункциональная сенсорно-" +
                        "механическая кнопка mTouch, включающая в себя быстрый и сверхточный сканер отпечатков пальцев. " +
                        "Смартфон имеет поддержку двух Nano-Sim карт." +
                        "<br><br>" +
                        "Основной акцент в Meizu MX6 сделан на камере. В смартфоне установлен новейший 12 Мп модуль Sony " +
                        "IMX386 для получения снимков невероятного качества! 6 линз, фазовая фокусировка, апертура " +
                        "f/2.0, тонкая настройка в специальных лабораториях, новые улучшенные алгоритмы обработки " +
                        "изображения - позволяют обеспечить четкие и детальные снимки даже в условиях низкой " +
                        "освещенности. Фронтальная камера получила новый модуль на 5 Мп с широким углом съемки и " +
                        "апертурой f/2.0, позволяющей получать отличные сэлфи даже в темноте." +
                        "<br><br>" +
                        "Meizu MX6 работает на базе 10-ядерного процессора MediaTek Helio X20, предлагающего пользователю " +
                        "максимальную производительность при высокой энергоэффективности. 4 Гб быстрой RAM-памяти позволят " +
                        "без проблем переключаться между приложениями без потери производительности. Смартфон оснащен " +
                        "ярким и контрастным 5.5\" FullHD дисплеем от Sharp с TDDI матрицей и защищен прочным стеклом с " +
                        "эффектом 2.5D. Экран имеет контрастность 1500:1 и яркость 500 кд, а его цветопередача " +
                        "охватывает 85% цветового пространства NTSC. Meizu MX6 имеет защищающий глаза ночной режим " +
                        "работы дисплея и очень быструю и точную настройку автояркости." +
                        "</p>");
        product3.setSpecification(
                "Android", "Десятиядерный MediaTek Helio X20 (MT6797) (4 x 1.5 ГГц + 4 x 1.9 ГГц + 2 x 2.3 ГГц)",
                "153.6 x 75.2 x 7.25 мм", "155 г", "5.5\"", "1920 x 1080",  "(Sony IMX 386) 12 Мп", "5 Мп");

        Product product4 = new Product("Apple iPad Air 2", "Планшеты", "Apple", 12_000, 10_999);
        product4.setImageURL("http://localhost:8080/resources/img/apple_ipad_air-2_400x480.jpg");
        product4.setSpecification("");
        product4.setOnMain("Y");

        Product product5 = new Product("Xiaomi MiPad 2", "Планшеты", "Xiaomi", 4_700, 3_999);
        product5.setImageURL("http://localhost:8080/resources/img/xiaomi_mipad_2_16Gb_400x480.jpg");
        product5.setSpecification("");
        product5.setOnMain("Y");

        Product product6 = new Product("Samsung Galaxy Tab S2", "Планшеты", "Samsung", 5_000, 3_999);
        product6.setImageURL("http://localhost:8080/resources/img/samsung_galaxy_tab_s2_400x480.jpg");
        product6.setSpecification("");
        product6.setOnMain("Y");
        product6.setSpecification("this is on main page");

        Product product7 = new Product("Meizu M3s", "Смартфоны", "Meizu", 5_000, 3_999);
        product7.setImageURL("http://localhost:8080/resources/img/meizu_m3s_400x480.jpg");
        product7.setOnMain("Y");
        product7.setDescription(
                "<h3 style=\"margin-top: 10px; margin-bottom: -5px\">Металлическое совершенство</h3>" +
                        "<p align=\"justify\">" +
                        "<br>Meizu M3s и M3 Note - это любовь в одно касание. Металлический корпус, объемное 2.5 D " +
                        "стекло и лёгкость - а что ещё нужно супер-смартфону?" +
                        "<br>" +
                        "<br>Крутая начинка. И она здесь есть! Функциональности этих смартфонов может" +
                        "позавидовать любое устройство в этом ценовом сегменте." +
                        "<br>" +
                        "<br>Высокая производительсность, крутая камера, великолепная графика и всё это в стильном," +
                        "тончайшем металлическом корпусе." +
                        "<br>" +
                        "<br>Meizu M3s работает на 8-ми ядерном процессоре фирмы MediaTek MT6750 с максимальной " +
                        "частотой в 1,5 ГГц." +
                        "<br>" +
                        "<br>Meizu M3 Note, в свою очередь, оснащён 8-ми ядерным процессором MediaTek Helio P10 " +
                        "с максимальной частотой в 1,8 ГГц.\n" +
                        "<br>" +
                        "<br>С таким железом оба смартфона под оболочкой Flyme работают ещё быстрей." +
                        " Сканер отпечатков пальцев mTouch 2.1 защитит твой Meizu M3s или Meizu M3 Note от любых " +
                        "посягательств." +
                        "<br><br>" +
                        "Теперь твои персональные данные находяться под реальной защитой. Смело храни свои финансовые " +
                        "операции, деловые переписки и пароли. " +
                        "<br><br>" +
                        "Надёжнее только в швейцарском банке. И то не факт." +
                        "</p>");
        product7.setSpecification(
                "Android", "Восьмиядерный MediaTek MT6750 (4 x 1.5 ГГц + 4 x 1 ГГц)", "5\"", "1280 x 720",
                "141.9 x 69.9 x 8.3 мм", "138 г", "13 Мп ", "5 Мп");

        Product product8 = new Product("Meizu M3 Note 16GB Grey", "Смартфоны", "Meizu", 3_000, 3_000);
        product8.setImageURL("http://localhost:8080/resources/img/meizu_m3s_400x480.jpg");
        product8.setDescription(
                "<h3 style=\"margin-top: 10px; margin-bottom: -5px\">Металлическое совершенство</h3>" +
                        "<p align=\"justify\">" +
                        "<br>Meizu M3s и M3 Note - это любовь в одно касание. Металлический корпус, объемное 2.5 D " +
                        "стекло и лёгкость - а что ещё нужно супер-смартфону?" +
                        "<br>" +
                        "<br>Крутая начинка. И она здесь есть! Функциональности этих смартфонов может" +
                        "позавидовать любое устройство в этом ценовом сегменте." +
                        "<br>" +
                        "<br>Высокая производительсность, крутая камера, великолепная графика и всё это в стильном," +
                        "тончайшем металлическом корпусе." +
                        "<br>" +
                        "<br>Meizu M3s работает на 8-ми ядерном процессоре фирмы MediaTek MT6750 с максимальной " +
                        "частотой в 1,5 ГГц." +
                        "<br>" +
                        "<br>Meizu M3 Note, в свою очередь, оснащён 8-ми ядерным процессором MediaTek Helio P10 " +
                        "с максимальной частотой в 1,8 ГГц.\n" +
                        "<br>" +
                        "<br>С таким железом оба смартфона под оболочкой Flyme работают ещё быстрей." +
                        " Сканер отпечатков пальцев mTouch 2.1 защитит твой Meizu M3s или Meizu M3 Note от любых " +
                        "посягательств." +
                        "<br><br>" +
                        "Теперь твои персональные данные находяться под реальной защитой. Смело храни свои финансовые " +
                        "операции, деловые переписки и пароли. " +
                        "<br><br>" +
                        "Надёжнее только в швейцарском банке. И то не факт." +
                        "</p>");
        product8.setSpecification(
                "Android", "Восьмиядерный MediaTek Helio P10 (4 x 1.8 ГГц + 4 x 1 ГГц)", "5.5\"", "1920 x 1080",
                "153.6 х 75.5 х 8.2 мм", "163 г", "13 Мп ", "5 Мп");


//                String os, String processor, String display, String size
//                String weight, String mainCamera, String frontCamera

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product7);
        productService.addProduct(product3);
        productService.addProduct(product4);
        productService.addProduct(product5);
        productService.addProduct(product6);
        productService.addProduct(product8);

        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.addProduct(product5);
        order1.addProduct(product5);
        order1.addProduct(product5);
        orderService.addOrder(order1);

        Order order2 = new Order();
        order2.addProduct(product1);
        order2.addProduct(product2);
        orderService.addOrder(order2);

        System.out.println("Finish!");
    }


}
