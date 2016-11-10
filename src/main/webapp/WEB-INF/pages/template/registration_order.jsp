<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setCharacterEncoding("UTF-8"); %>

<div class="registration_order" style="margin-left: 20px;">
    <form action="/checkout" method="post">
        <h4 style="color: #f6731c; font-size: 20px; text-decoration: none">Ваши данные</h4>

        <strong><p style="font-size: 16px">Имя</p></strong>
        <input type="text" class="form-control" name="name" autocomplete="on" pattern="[А-Яа-я]+"
               placeholder="Введите имя" required>
        <strong><p style="font-size: 16px;margin-top: 10px;">Фамилия</p></strong>
        <input type="text" class="form-control" name="surname" autocomplete="on" pattern="А-Яа-я]+"
               placeholder="Введите фамилию"
               required>
        <p class="help-block" style="font-size: 11px">Пример: Иван Франко. Только кирилица</p>

        <strong><p style="font-size: 16px">Ваш E-mail</p></strong>
        <input type="text" class="form-control" name="email" autocomplete="on"
               placeholder="Введите email" required>

        <strong><p style="font-size: 16px;margin-top: 10px;">Ваш номер телефона*</p></strong>
        <input type="text" class="form-control" name="phone" autocomplete="on"
               pattern="\+[0-9]{2}\(0[0-9]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}" placeholder="+38 (0__) ___-__-__" required>
        <p class="help-block" style="font-size: 11px">Пример: +38(050)123-45-67</p>

        <h4 style="color: #f6731c; font-size: 20px; text-decoration: none; margin-top: 20px; ">Доставка</h4>
        <strong><p style="font-size: 16px">Ваш город:</p></strong>
        <input type="text" class="form-control" name="city" autocomplete="on" pattern="[А-Яа-я]+"
               placeholder="Введите город" required>
        <p class="help-block" style="font-size: 11px">Пример: Киев. Только кирилица</p>

        <strong><p style="font-size: 16px">Ваш адресс:</p></strong>
        <input type="text" class="form-control" name="address" autocomplete="on"
               placeholder="Введите адресс">
        <p class="help-block" style="font-size: 11px">Поле не обязательно для заполнения</p>

        <strong><p style="font-size: 16px; margin-top: 15px">Способ доставки:</p></strong>
        <div class="radio">
            <label>
                <input type="radio" name="delivery_type" id="radio1" value="PICKUP">
                Самовывоз
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="delivery_type" id="radio2" value="COURIER">
                Доставка курьером
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="delivery_type" id="radio3" value="UNMANNED_AIRCRAFT">
                Доставка дроном
            </label>
        </div>
        <input class="btn btn-add" type="submit" value="Оформить заказ">

    </form>
</div>
