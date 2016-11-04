<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="registration_order" style="margin-left: 20px;">
    <form action="/checkout" method="POST">
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
        <input type="text" class="form-control" name="city" autocomplete="on" pattern="[A-Za-z]+"
               placeholder="Введите email" required>

        <strong><p style="font-size: 16px;margin-top: 10px;">Ваш номер телефона*</p></strong>
        <input type="text" class="form-control" name="city" autocomplete="on" pattern="[A-Za-z]+"
               placeholder="+38 (0__) ___-__-__" required>

        <h4 style="color: #f6731c; font-size: 20px; text-decoration: none; margin-top: 20px; ">Доставка</h4>
        <strong><p style="font-size: 16px">Ваш город:</p></strong>
        <input type="text" class="form-control" name="city" autocomplete="on" pattern="[А-Яа-я]+"
               placeholder="Введите город" required>
        <p class="help-block" style="font-size: 11px">Пример: Киев. Только кирилица</p>

        <strong><p style="font-size: 16px; margin-top: 15px">Способ доставки:</p></strong>
        <div class="radio">
            <label>
                <input type="radio" name="optionsRadios" id="radio1" value="option3">
                Самовывоз
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="optionsRadios" id="radio2" value="option3">
                Доставка курьером
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="optionsRadios" id="radio3" value="option3">
                Доставка дроном
            </label>
        </div>
        <button class="btn btn-add" type="submit">Оформить заказ</button>

    </form>
</div>