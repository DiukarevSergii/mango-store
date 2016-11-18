<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <title>Редактировать информацию о заказе | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <meta name="robots" content="noindex,nofollow">
    <meta name="title" content="Редактировать информацию о заказе | MANGO STORE">
</head>
<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/managers/login-header.jsp"/>
    <!-- manager MENU -->
    <jsp:include page="/WEB-INF/pages/employee/managers/manager-general-menu.jsp"/>

    <div class="row admin-main-title">
        <h3 style="font-size: 30px">Категория: Обработка заказа</h3>
    </div>

    <div class="row">
        <div style="margin-top: 12px; height: 600px">
            <div class="col-lg-12" style="margin-top: 12px">
                <table class="table">
                    <tr>
                        <th>Номер заказа</th>
                        <td style="width: 700px">${order.number} </td>
                    </tr>
                    <tr>
                        <th>Статус заказа</th>
                        <td>${order.status.toString()}</td>
                    </tr>
                    <tr>
                        <th>Тип доставки</th>
                        <td><select class="form-control" name="deliveryType" style="width:200px">
                            <c:choose>
                                <c:when test="${delivery.deliveryType.name() eq 'COURIER'}">
                                    <option value="PICKUP">Самовывоз</option>
                                    <option value="COURIER" selected>Доставка курьером</option>
                                    <option value="UNMANNED_AIRCRAFT">Доставка дроном</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="PICKUP">Самовывоз</option>
                                    <option value="COURIER">Доставка курьером</option>
                                    <option value="UNMANNED_AIRCRAFT" selected>Доставка дроном</option>
                                </c:otherwise>
                            </c:choose>
                        </select></td>
                    </tr>
                    <tr>
                        <th>Стоимость доставки</th>
                        <td> ${delivery.cost}</td>
                    </tr>
                    <tr>
                        <th>Дата и время создания</th>
                        <td> ${order.dateCreated} ${order.timeCreated}</td>
                    </tr>
                    <tr>
                        <th>Дата доставки</th>
                        <td> ${delivery.deliveryDate}</td>
                    </tr>
                    <tr>
                        <th>Время доставки</th>
                        <td style="width: 700px"> ${delivery.deliveryTime}</td>
                    </tr>
                    <tr>
                        <th></th>
                        <td style="width: 700px"></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>
                            <form action="/courier/updated">
                                <input type="hidden" name="id" value="${order.orderId}">
                                <button class="btn" style="margin-top: -10px; margin-left: 8px">
                                    Взять доставку
                                </button>
                            </form>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
    </div>
</div>