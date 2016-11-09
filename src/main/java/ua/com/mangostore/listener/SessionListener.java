package ua.com.mangostore.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Класс реализует методы интерфейс {@link HttpSessionListener} для получения уведомления
 * об изменениях событий жизненного цикла HttpSession.
 *
 * @author Diukarev Sergii
 */
public class SessionListener implements HttpSessionListener {

    /**
     * Интервал времени.
     */
    private static final int INTERVAL = 30 * 24 * 60 * 60;

    /**
     * Получает уведомление о том, что был создан сеанс.
     * Максимальный интервал активности 1 день.
     *
     * @param sessionEvent Объект класса HttpSessionEvent, содержащий сессию.
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        sessionEvent.getSession().setMaxInactiveInterval(INTERVAL);
    }

    /**
     * Получает уведомление о том, что сессия вскоре будет признана недействительной.
     *
     * @param sessionEvent Объект класса HttpSessionEvent, содержащий сессию.
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        sessionEvent.getSession().invalidate();
    }
}
