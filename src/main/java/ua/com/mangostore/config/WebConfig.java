package ua.com.mangostore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.mangostore")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * Указывает Spring'у где находятся компоненты представления, и как их отображать.
     * Вьюшки будут лежать в директории /WEB-INF/pages/ и иметь разширение *.jsp.
     *
     * @return Реализация интерфейса ViewResolver с настройками для вьюшек.
     */
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    /**
     * Указывает где будут хранится ресурсы.
     *
     * @param resource Объект класса ResourceHandlerRegistry с настройками для ресурсов.
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry resource) {
        resource.addResourceHandler("/resources/" + "**").addResourceLocations("/resources/");
    }

//    @Bean
//    public UserDetailsService getCustomerDetailsService(){
//        return new CustomerDetailsServiceImpl();
//    }

    /**
     * Настройка логин-контроллера.
     * Оказывает помощь в регистрации простого автоматизированного логин-контроллера предварительно
     * сконфигурированных с кодом состояния и вьюшкой.
     *
     * @param viewController Объект класса ViewControllerRegistry.
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry viewController) {
//        viewController.addViewController(LOGIN_URL).setViewName(LOGIN_VIEW_NAME);
//        viewController.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }
}
