package ua.com.mangostore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.entity.enums.OnMain;
import ua.com.mangostore.service.EmployeeService;
import ua.com.mangostore.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping(value = "/admin")
public class AdminProductController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView onMainProduct(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        List<Product> groupOfProductsOnMain = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (OnMain.ON_MAIN.equals(product.getOnMain())) {
                groupOfProductsOnMain.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsOnMain", groupOfProductsOnMain);
        modelAndView.setViewName("employee/admin/products/main");
        return modelAndView;
    }

    @RequestMapping(value = "/on-main", method = RequestMethod.GET)
    public ModelAndView onMain(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);
        modelAndView.addObject("title", "На главной");

        List<Product> groupOfProductsOnMain = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (OnMain.ON_MAIN.equals(product.getOnMain())) {
                groupOfProductsOnMain.add(product);
            }
        }
        modelAndView.addObject("groupOfProducts", groupOfProductsOnMain);
        modelAndView.setViewName("employee/admin/products/some_products");
        return modelAndView;
    }

    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public ModelAndView onType(@PathVariable("type") String type, ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);
        modelAndView.addObject("title", type);

        List<Product> groupOfProductsByType = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (product.getType().equals(type)) {
                groupOfProductsByType.add(product);
            }
        }
        modelAndView.addObject("groupOfProducts", groupOfProductsByType);
        modelAndView.setViewName("employee/admin/products/some_products");
        return modelAndView;
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ModelAndView mainType(ModelAndView modelAndView) {
        getUser(modelAndView);
        byBrand(modelAndView);
        modelAndView.addObject("title", "По типам");

        Set<String> types = new TreeSet<>();
        List<Product> groupOfProductsByType = new ArrayList<>();
        for (Product product : productService.getAll()) {
            String type = product.getType();
            if (!types.contains(type)) {
                types.add(type);
                groupOfProductsByType.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsByType", groupOfProductsByType);
        modelAndView.setViewName("employee/admin/products/type");
        return modelAndView;
    }

    @RequestMapping(value = "/brand/{brand}", method = RequestMethod.GET)
    public ModelAndView onBrand(@PathVariable("brand") String brand, ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);
        modelAndView.addObject("title", brand);

        List<Product> groupOfProductsByBrand = new ArrayList<>();
        for (Product product : productService.getAll()) {
            if (product.getBrand().equals(brand)) {
                groupOfProductsByBrand.add(product);
            }
        }
        modelAndView.addObject("groupOfProducts", groupOfProductsByBrand);
        modelAndView.setViewName("employee/admin/products/some_products");
        return modelAndView;
    }

    @RequestMapping(value = "/brand", method = RequestMethod.GET)
    public ModelAndView mainBrand(ModelAndView modelAndView) {
        getUser(modelAndView);
        byType(modelAndView);
        modelAndView.addObject("title", "По брендам");

        Set<String> brands = new TreeSet<>();
        List<Product> groupOfProductsByBrand = new ArrayList<>();
        for (Product product : productService.getAll()) {
            String brand = product.getBrand();
            if (!brands.contains(brand)) {
                brands.add(brand);
                groupOfProductsByBrand.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsByBrand", groupOfProductsByBrand);
        modelAndView.setViewName("employee/admin/products/brand");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/products/admin-update-product" с 1-м товаром с уникальним URL, который
     * совпадает с входящим параметром url. URL запроса "/product-{id}", метод GET.
     * В запросе в параметре id передается артикль товара.
     *
     * @param id           id товара, который нужно вернуть на страницу.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/product-{id}", method = RequestMethod.GET)
    public ModelAndView viewProduct(@PathVariable("id") long id, ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        Product product = productService.getById(id);
        modelAndView.addObject("title", product.getProductTitle());
        modelAndView.addObject("product", product);
        modelAndView.setViewName("employee/admin/products/admin-update-product");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/success" удаляя товар с выбранным id из баз.
     * URL запроса "/admin/remove-product", метод POST.
     *
     * @param id           id товара, который нужно удалить из базы.
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/remove-product", method = RequestMethod.POST)
    public ModelAndView removeProduct(@RequestParam("id") long id,
                                      ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        String productTitle = productService.getById(id).getProductTitle();
        productService.delete(id);
        modelAndView.addObject("title", "товары");
        modelAndView.addObject("message", "удалили продукт " + productTitle);
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/success"  и обновляет товар по входящим параметрам.
     * URL запроса "/admin/update-product", метод POST.
     *
     * @param id            Код товара для обновления.
     * @param productTitle  Название товара.
     * @param type          Тип товара.
     * @param brand         Бренд товара.
     * @param imageURL      Ссылка на изображения товара.
     * @param fullPrice     Цена товара без скидки.
     * @param salePrice     Цена товара cо скидкой.
     * @param specification Характеристики товара.
     * @param description   Описание товара.
     * @param modelAndView  Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/update-product", method = RequestMethod.POST)
    public ModelAndView updateProduct(@RequestParam long id,
                                      @RequestParam String productTitle,
                                      @RequestParam String type,
                                      @RequestParam String brand,
                                      @RequestParam String imageURL,
                                      @RequestParam double fullPrice,
                                      @RequestParam double salePrice,
                                      @RequestParam String onMain,
                                      @RequestParam String specification,
                                      @RequestParam String description,
                                      ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        Product product = productService.getById(id);
        product.setProductTitle(productTitle);
        product.setType(type);
        product.setBrand(brand);
        product.setImageURL(imageURL);
        product.setFullPrice(fullPrice);
        product.setSalePrice(salePrice);
        OnMain statusOnMain = OnMain.ON_MAIN.name().equals(onMain) ? OnMain.ON_MAIN : OnMain.NOT_ON_MAIN;
        product.setOnMain(statusOnMain);
        product.setSpecification(specification);
        product.setDescription(description);

        productService.editProduct(product);
        modelAndView.addObject("title", "товары");
        modelAndView.addObject("message", "обновили продукт " + product.getProductTitle());
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/products/admin-add-product".
     * URL запроса "/admin/add-product", метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public ModelAndView addProduct(ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        modelAndView.setViewName("employee/admin/products/admin-add-product");
        return modelAndView;
    }

    /**
     * Возвращает страницу "employee/admin/products/admin-add-product"  и добавляет товар по входящим параметрам в базу.
     * URL запроса "/admin/add-product", метод POST.
     *
     * @param productTitle  Название товара.
     * @param type          Тип товара.
     * @param brand         Бренд товара.
     * @param imageURL      Ссылка на изображения товара.
     * @param fullPrice     Цена товара без скидки.
     * @param salePrice     Цена товара cо скидкой.
     * @param specification Характеристики товара.
     * @param description   Описание товара.
     * @param modelAndView  Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ModelAndView addProduct(@RequestParam String productTitle,
                                   @RequestParam String type,
                                   @RequestParam String brand,
                                   @RequestParam String imageURL,
                                   @RequestParam double fullPrice,
                                   @RequestParam double salePrice,
                                   @RequestParam String onMain,
                                   @RequestParam String specification,
                                   @RequestParam String description,
                                   ModelAndView modelAndView) {
        getUserTypeBrand(modelAndView);

        Product product = new Product();
        product.setProductTitle(productTitle);
        product.setType(type);
        product.setBrand(brand);
        product.setImageURL(imageURL);
        product.setFullPrice(fullPrice);
        product.setSalePrice(salePrice);
        OnMain statusOnMain = OnMain.ON_MAIN.name().equals(onMain) ? OnMain.ON_MAIN : OnMain.NOT_ON_MAIN;
        product.setOnMain(statusOnMain);
        product.setSpecification(specification);
        product.setDescription(description);

        productService.addProduct(product);
        modelAndView.addObject("title", "товары");
        modelAndView.addObject("message", "добавили продукт " + product.getProductTitle());
        modelAndView.setViewName("employee/admin/success");
        return modelAndView;
    }

    private void getUserTypeBrand(ModelAndView modelAndView) {
        getUser(modelAndView);
        byType(modelAndView);
        byBrand(modelAndView);
    }

    private void getUser(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee admin = employeeService.getByEmail(user.getUsername());
        modelAndView.addObject("user", admin);
    }

    private void byType(ModelAndView modelAndView) {
        Set<String> types = new TreeSet<>();
        List<Product> groupOfProductsByType = new ArrayList<>();
        for (Product product : productService.getAll()) {
            String type = product.getType();
            if (!types.contains(type)) {
                types.add(type);
                groupOfProductsByType.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsByType", groupOfProductsByType);
    }

    private void byBrand(ModelAndView modelAndView) {
        Set<String> brands = new TreeSet<>();
        List<Product> groupOfProductsByBrand = new ArrayList<>();
        for (Product product : productService.getAll()) {
            String brand = product.getBrand();
            if (!brands.contains(brand)) {
                brands.add(brand);
                groupOfProductsByBrand.add(product);
            }
        }
        modelAndView.addObject("groupOfProductsByBrand", groupOfProductsByBrand);
    }
}
