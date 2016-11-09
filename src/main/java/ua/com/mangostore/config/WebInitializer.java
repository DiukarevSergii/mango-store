package ua.com.mangostore.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import ua.com.mangostore.listener.SessionListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * Диспетчер cервлета, который отвечает за инициализацию Spring MVC и меппинг URL.
 * Класс реализует интерфейс WebApplicationInitializer.
 *
 * @author Diukarev Sergii
 * @see WebConfig
 * @see RootConfig
 * @see SecurityConfig
 * @see SecurityInitializer
 * @see SessionListener
 */
public class WebInitializer implements WebApplicationInitializer {

    /**
     * Настройка ссесии.
     *
     * @param servletContext Реализация интерфейса ServletContext.
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(RootConfig.class, WebConfig.class, SecurityConfig.class);

        /**
         * Управление жизненным циклом корневого контекста приложения
         */
        servletContext.addListener(new SessionListener());

        appContext.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        /**
         * Настройка параметров
         */
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    }
}