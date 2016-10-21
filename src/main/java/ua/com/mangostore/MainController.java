package ua.com.mangostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.model.ProductOnMain;
import ua.com.mangostore.service.OrderService;
import ua.com.mangostore.service.ProductService;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public MainController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setZeroDigit('0');
        decimalFormatSymbols.setGroupingSeparator(' ');

        df.setDecimalFormatSymbols(decimalFormatSymbols);

        modelAndView.addObject("cart_size", orderService.getSize());

        List<ProductOnMain> productOnMains = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (product.getOnMain() != null) {
                ProductOnMain productOnMain = new ProductOnMain();
                productOnMain.setProductTitle(product.getProductTitle());
                productOnMain.setImageURL(product.getImageURL());
                productOnMain.setType(product.getType());
                productOnMain.setBrand(product.getBrand());
                productOnMain.setSalePrice(df.format(product.getSalePrice()));
                productOnMain.setFullPrice(df.format(product.getFullPrice()));
                productOnMains.add(productOnMain);
            }
        }
        modelAndView.addObject("modelList", productOnMains);
        modelAndView.setViewName("index");
                return modelAndView;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String onAbout() {
        return "highest-menu/about";
    }

    @RequestMapping(value = "/stores_addresses", method = RequestMethod.GET)
    public String onAddresses() {
        return "highest-menu/stores_addresses";
    }

    @RequestMapping(value = "/shares", method = RequestMethod.GET)
    public String onShares() {
        return "highest-menu/shares";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String onPayment() {
        return "highest-menu/payment";
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.GET)
    public String onDelivery() {
        return "highest-menu/delivery";
    }

    @RequestMapping(value = "/service-center", method = RequestMethod.GET)
    public String onService() {
        return "highest-menu/service-center";
    }

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String onSupport() {
        return "highest-menu/support";
    }

    @RequestMapping(value = "/firmware", method = RequestMethod.GET)
    public String onFirmware() {
        return "highest-menu/firmware";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String onNews() {
        return "highest-menu/news";
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String onReview() {
        return "highest-menu/review";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String onLogin() {
        return "highest-menu/login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String onLogin(Model model, @RequestParam String login, @RequestParam String password) throws SQLException {
//        String log = login;
//        String pas = password;
//        if (flag) {
//            try {
//                initDB();
//                flag = false;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ok");
//        }
//        preparedStatement.setString(1, log);
//        preparedStatement.setString(2, pas);
//        preparedStatement.executeUpdate();
//        return "result";
//    }
//
//    private static void initDB() throws SQLException {
//        connection = DriverManager.getConnection(
//                res.getString("db.url"), res.getString("db.user"), res.getString("db.password"));
//        Statement statement = connection.createStatement();
//        statement.execute("DROP TABLE IF EXISTS LogPas");
//        statement.execute("CREATE TABLE LogPas " +
//                "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
//                "login VARCHAR (10) NOT NULL," +
//                "password VARCHAR (10) NOT NULL,");
//
//        preparedStatement = connection.prepareStatement("INSERT INTO Apartments " +
//                "(login, password) VALUES (?,?)");
//    }
}


