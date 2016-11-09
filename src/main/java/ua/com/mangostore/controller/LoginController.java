package ua.com.mangostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.mangostore.exception.ForbiddenException;

/**
 * Класс-контроллер для страницы авторизация и страниц предназначеных для персонала.
 * К даному контроллеру и соответствующим страницам может обращатся только персонал магазина.
 * Аннотация @Controller служит для сообщения Spring'у о том, что данный класс
 * является bean'ом и его необходимо подгрузить при старте приложения.
 * Методы класса работают с объектом, возвращенным handleRequest методом, является
 * типом {@link ModelAndView}, который агрегирует все параметры модели и имя отображения.
 * Этот тип представляет Model and View в MVC шаблоне.
 *
 * @author Diukarev Sergii
 */
@Controller
public class LoginController {
    /**
     * Возвращает страницу "manager/login" - страница описания входа в личный кабинет.
     * URL запроса "/login", метод GET.
     *
     * @param modelAndView Объект класса {@link ModelAndView}.
     * @return Объект класса {@link ModelAndView}.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView onLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("manager/login");
        return modelAndView;
    }

    /**
     * Возвращает исключение ForbiddenException, если пользователь обращается к запросам, к которым
     * он не имеет права доступа (роли).
     *
     * @throws ForbiddenException Бросает исключение в случае отсутствия прав доступа.
     */
    @RequestMapping(value = "/forbidden_exception", method = RequestMethod.GET)
    public void getForbiddenException() throws ForbiddenException {
        throw new ForbiddenException("У вас недостаточно прав для доступа к этой странице!");
    }
}
