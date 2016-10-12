package ua.com.mangostore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MyController {

//    static ResourceBundle res = ResourceBundle.getBundle("db");
//    static Connection connection;
//    static PreparedStatement preparedStatement;
//    static boolean flag = true;

    @RequestMapping("/")
    public String onIndex() {
        return "index";
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


