package ua.com.mangostore.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Класс основных конфигураций для Spring: DataSource, JpaVendorAdapter, JpaTransactionManager,
 * BeanPostProcessor, CommonsMultipartResolver.
 * Помечен аннотацией @Configuration - класс является источником определения бинов;
 * помечен аннотацией @EnableTransactionManagement - активирует возможности Spring транзакции через @Transactional;
 * помечен аннотацией @EnableJpaRepositories - активирует Spring Data JPA, который будет создавать конкретную
 * реализацию для репозитория из пакета "ua.com.mangostore.repository" и настраивать на взаимодействие
 * с БД в памяти, используя JPA;
 * аннотацией @ComponentScan - указываем фреймворку Spring, что компоненты надо искать внутри
 * пакета "ua.com.mangostore".
 *
 * @author Diukarev Sergii
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ua.com.mangostore.repository")
@ComponentScan("ua.com.mangostore")
public class RootConfig extends WebMvcConfigurerAdapter {

    /**
     * Драйвер для подключение к базе данных.
     */
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * Путь к базе данных.
     */
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/mangodb";

    /**
     * Логин для подключение к базе данных.
     */
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";

    /**
     * Пароль для подключение к базе данных.
     */
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "password";

    /**
     * Диалект.
     */
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";

    /**
     * Отображение SQL запросов.
     */
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";

    /**
     * Пакет сканирования для фабрики EntityManager.
     */
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "ua.com.mangostore.entity";

    /**
     * Создание схема БД каждый раз при запуске приложения
     */
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "create";

    /**
     * Создает фабрику EntityManager, может быть передана в JPA с помощью инъекции зависимостей.
     *
     * @return Объект класса LocalContainerEntityManagerFactoryBean.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
        properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
        properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO);
        return properties;
    }

    /**
     * Возвращает менеджера транзакций, который  подходит для приложений, использующих единую
     * JPA EntityManagerFactory для транзакционного доступа к данным.
     *
     * @param factory Реализация интерфейса EntityManagerFactory.
     * @return Объект класса JpaTransactionManager с входящей фабрикой ентети менеджера factory.
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

    /**
     * Возвращает объект класса DataSource с настройками подключения к базе данных.
     * Нужен для получения физического соединения с базой данных.
     *
     * @return Объект класса DataSource - настройки для базы данных.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
        dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
        dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

        return dataSource;
    }

    /**
     * Переводит (перехватывает) любые JPA или Hibernate исключения в Spring исключения.
     *
     * @return Реализация интерфейса PersistenceExceptionTranslationPostProcessor.
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * Возвращает объект класса CommonsMultipartResolver, который сохраняет временные файлы
     * во временный каталог сервлет контейнера.
     *
     * @return Объект класса CommonsMultipartResolver для временного сохранения файлов.
     */
    @Bean
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }

}
