package ua.com.mangostore.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ua.com.mangostore.entity.Product;
import ua.com.mangostore.service.impl.ProductServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

//        appContext.refresh();
//        ProductServiceImpl productService = appContext.getBean(ProductServiceImpl.class);
//        Product product = new Product();
//        product.setBrandName("LG");
//        product.setPrice(12);
//        product.setType("smartphone");
//        product.setProductTitle("LG 7689");
//
//        productService.addProduct(product);
    }
}
