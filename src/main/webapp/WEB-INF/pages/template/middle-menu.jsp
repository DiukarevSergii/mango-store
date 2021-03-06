<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row middle">
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 logo">
        <a href="/">
            <img src="/resources/img/logo.png" style="width: 250px;">
        </a>
    </div>
    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        <div class="middle-menu-centr">
            <p class="order">Оформить заказ:</p>
            <p class="phone">0 800 00 71 20</p>
            <p class="order">Служба поддержки клиентов:</p>
            <p class="phone">0 800 00 71 30</p>
        </div>
    </div>
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 pull-right">
        <div class=" cart">
            <img src="/resources/img/cart.png" alt="cart">
            &nbsp; <a href="/cart"> Корзина: ${cart_size}<c:if test="${cart_size == null}">0</c:if></a>
        </div>
    </div>
</div>
