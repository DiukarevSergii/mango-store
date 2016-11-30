package ua.com.mangostore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ua.com.mangostore.service.impl.UserDetailsServiceImpl;

/**
 * Класс конфигурации Spring компонентов представления , настройка MVC.
 * Указывает Spring где находятся компоненты представления, и как их отображать.
 * Помечен аннотацией @Configuration - класс является источником определения бинов;
 * помечен аннотацией @EnableWebMvc - позволяет проекту использовать MVC;
 * помечен аннотацией @ComponentScan - указываем фреймворку Spring, что компоненты надо искать внутри
 * пакета "ua.com.mangostore".
 *
 * @author Diukarev Sergii
 * @see WebInitializer
 * @see RootConfig
 */
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
}
