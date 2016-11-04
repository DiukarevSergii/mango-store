<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setCharacterEncoding("UTF-8"); %>

<div class="registration_order" style="margin-left: 20px;">

    <form action="/checkout" method="post">
        <h4 style="color: #f6731c; font-size: 20px; text-decoration: none">Ваши данные</h4>

        <strong><p style="font-size: 16px">Имя</p></strong>
        <%--<input class="form-control" type="text" name="user_name" placeholder=" Введите имя"--%>
        <%--minlength="2" maxlength="50" required autofocus>--%>
        <input type="text" class="form-control" name="user_name" autocomplete="on" pattern="[А-Яа-я]+"
               placeholder="Введите имя" required>
        <%--<strong><p style="font-size: 16px;margin-top: 10px;">Фамилия</p></strong>--%>
        <%--<input type="text" class="form-control" name="сustomer_surname" autocomplete="on" pattern="А-Яа-я]+"--%>
        <%--placeholder="Введите фамилию"--%>
        <%--required>--%>
        <%--<p class="help-block" style="font-size: 11px">Пример: Иван Франко. Только кирилица</p>--%>

        <%--<strong><p style="font-size: 16px">Ваш E-mail</p></strong>--%>
        <%--<input type="text" class="form-control" name="сustomer_email" autocomplete="on"--%>
        <%--placeholder="Введите email" required>--%>

        <%--<strong><p style="font-size: 16px;margin-top: 10px;">Ваш номер телефона*</p></strong>--%>
        <%--<input type="text" class="form-control" name="сustomer_phone" autocomplete="on"--%>
        <%--pattern="\+[0-9]{2}\(0[0-9]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}" placeholder="+38 (0__) ___-__-__" required>--%>
        <%--<p class="help-block" style="font-size: 11px">Пример: +38(050)123-45-67</p>--%>

        <%--<h4 style="color: #f6731c; font-size: 20px; text-decoration: none; margin-top: 20px; ">Доставка</h4>--%>
        <%--<strong><p style="font-size: 16px">Ваш город:</p></strong>--%>
        <%--<input type="text" class="form-control" name="сustomer_city" autocomplete="on" pattern="[А-Яа-я]+"--%>
        <%--placeholder="Введите город" required>--%>
        <%--<p class="help-block" style="font-size: 11px">Пример: Киев. Только кирилица</p>--%>

        <%--<strong><p style="font-size: 16px; margin-top: 15px">Способ доставки:</p></strong>--%>
        <%--<div class="radio">--%>
        <%--<label>--%>
        <%--<input type="radio" name="optionsRadios" id="radio1" value="pickup">--%>
        <%--Самовывоз--%>
        <%--</label>--%>
        <%--</div>--%>
        <%--<div class="radio">--%>
        <%--<label>--%>
        <%--<input type="radio" name="optionsRadios" id="radio2" value="courier">--%>
        <%--Доставка курьером--%>
        <%--</label>--%>
        <%--</div>--%>
        <%--<div class="radio">--%>
        <%--<label>--%>
        <%--<input type="radio" name="optionsRadios" id="radio3" value="unmanned_aircraft">--%>
        <%--Доставка дроном--%>
        <%--</label>--%>
        <%--</div>--%>
        <input class="btn btn-add" type="submit" value="Оформить заказ">

    </form>
</div>

<%--<div class="row">--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<form action="/checkout" method="post">--%>
<%--<div class="col-xs-12 col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 col-lg-2 col-lg-offset-2 col-xl-2 col-xl-offset-2 input-padding text-center">--%>
<%--<input class="input" type="text" name="user_name" placeholder=" Введите имя"--%>
<%--minlength="2" maxlength="50" required autofocus>--%>
<%--</div>--%>
<%--<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-xl-2 input-padding text-center">--%>
<%--<input id="phone" class="input" type="text" name="user_phone" placeholder=" Введите телефон"--%>
<%--required>--%>
<%--</div>--%>
<%--<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-xl-2 input-padding text-center">--%>
<%--<input class="input" type="email" name="user_email" placeholder=" Введите Email"--%>
<%--minlength="5" maxlength="50">--%>
<%--</div>--%>
<%--<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-xl-2 input-padding text-center">--%>
<%--<input type="submit" class="btn btn-success" value="Оформить заказ" width="80px">--%>
<%--</div>--%>
<%--</form>--%>
<%--</div>--%>
