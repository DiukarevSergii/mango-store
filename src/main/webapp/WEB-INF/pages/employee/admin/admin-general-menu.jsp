<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row bottom-menu">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <ul class="nav nav-pills bmenu" id="bmenu">
            <li class="dropdown">
                <a href="/admin/main">Товары</a>
                <ul class="dropdown-menu">
                    <li><a href="/admin/add-product"><b>Добавить товар</b></a></li>
                    <li class="divider"></li>
                    <li class="divider"></li>
                    <li><a href="/admin/type"><b>По типам</b></a></li>
                    <li class="divider"></li>
                    <c:forEach items="${groupOfProductsByType}" var="product">
                        <li><a href="/admin/type/${product.type}">${product.type}</a></li>
                    </c:forEach>
                    <li class="divider"></li>
                    <li><a href="/admin/brand"><b>По брендам</b></a></li>
                    <li class="divider"></li>
                    <c:forEach items="${groupOfProductsByBrand}" var="product">
                        <li><a href="/admin/brand/${product.brand}">${product.brand}</a></li>
                    </c:forEach>
                    <li class="divider"></li>
                    <li><a href="/admin/on-main"><b>На главной</b></a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#">Персонал</a>
                <ul class="dropdown-menu">
                    <li><a href="#"><b>Добавить работника</b></a></li>
                    <li class="divider"></li>
                    <li class="divider"></li>
                    <li><a href="#">Менеджеры</a></li>
                    <li><a href="#">Курьеры</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>