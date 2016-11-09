package ua.com.mangostore.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Класс наследующий AbstractSecurityWebApplicationInitializer.
 * Класс нужен для того, чтобы удостовериться, что настройки безопасности включены
 * в основной контекст приложения (Root Application Context).
 *
 * @author Diukarev Sergii
 * @see SecurityConfig
 * @see RootConfig
 * @see WebConfig
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
