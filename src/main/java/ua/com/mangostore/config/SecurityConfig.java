package ua.com.mangostore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.com.mangostore.service.impl.UserDetailsServiceImpl;

/**
 * Класс настройки безопасности Spring Security. Класс расширяет класс WebSecurityConfigurerAdapter.
 * Аннотация @EnableWebSecurity в связке с WebSecurityConfigurerAdapter классом работает над обеспечением
 * аутентификации.
 * Помечен аннотацией @ComponentScan - указываем фреймворку Spring, что компоненты надо
 * искать внутри пакета "ua.com.mangostore".
 *
 * @author Diukarev Sergii
 * @see UserDetailsServiceImpl
 * @see SecurityInitializer
 */
@Configuration
@EnableWebSecurity
@ComponentScan("ua.com.mangostore")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Объект сервиса для работы с зарегистрированными пользователями.
     * Поле помечано аннотацией @Autowired, которая позволит Spring автоматически инициализировать объект.
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Регистрируем нашу реализацию UserDetailsService,
     * а также PasswordEncoder для приведения пароля в формат SHA1
     */
    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getShaPasswordEncoder());
    }

    /**
     * Настройка правил доступа пользователей к страницам сайта. Указываем адреса ресурсов с
     * ограниченным доступом, ограничение задано по ролям.
     * К страницам, URL которых начинается на "/admin/**", имеют доступ только пользователи с ролью - администратор.
     * К страницам, URL которых начинается на "/managers/**", имеют доступ только пользователи с ролью - менеджер.
     * К страницам, URL которых начинается на "/courier/**", имеют доступ только пользователи с ролью - курьер .
     * Чтобы попасть на эти страницы, нужно пройти этам авторизации.
     *
     * @param httpSecurity Объект класса HttpSecurity для настройки прав доступа к страницам.
     * @throws Exception Исключение методов класса HttpSecurity.
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/courier/**").hasRole("COURIER")
                .antMatchers("/managers/**").hasRole("MANAGER")
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_login")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }

    /**
     * Указываем Spring контейнеру, что надо инициализировать ShaPasswordEncoder
     */
    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }
}