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
<body style="background-image: none; background-color: lightgrey;">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/courier/login-header.jsp"/>
    <!-- COURIER MENU -->
    <jsp:include page="/WEB-INF/pages/employee/courier/courier-general-menu.jsp"/>

    <div class="row admin-main-title">
        <h3 style="font-size: 30px">Категория: Обработка заказа</h3>
    </div>

    <div class="row">
        <div style="margin-top: 12px; height: 700px">
            <div class="col-lg-12" style="margin-top: 12px">
                <form action="/courier/updated">
                    <table class="table">
                        <tr>
                            <th>Номер заказа</th>
                            <td style="width: 700px">${order.number} </td>
                        </tr>
                        <tr>
                            <th>Статус заказа</th>
                            <td>
                                <c:choose>
                                    <c:when test="${order.status.name() eq 'WORK'}">
                                        <input type="hidden" name="status" value="WORK">
                                        ${order.status.toString()}
                                    </c:when>
                                    <c:when test="${order.status.name() eq 'DELIVERY'}">
                                        <select class="form-control" name="status" style="width:200px">
                                            <option value="DELIVERY" selected>Идет доставка</option>
                                            <option value="CLOSED">Закрыт</option>
                                        </select>
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Адресс доставки</th>
                            <td>${order.customer.city}, ${order.customer.address}</td>
                        </tr>
                        <tr>
                            <th>Телефон покупателя</th>
                            <td>${order.customer.phone}</td>
                        </tr>
                        <tr>
                            <th>Фамилия и имя покупателя</th>
                            <td>${order.customer.surname} ${order.customer.name}</td>
                        </tr>
                        <tr>
                            <th>Тип доставки</th>
                            <td><select class="form-control" name="deliveryType" style="width:200px">
                                <c:choose>
                                    <c:when test="${delivery.deliveryType.name() eq 'COURIER'}">
                                        <option value="COURIER" selected>Доставка курьером</option>
                                        <option value="UNMANNED_AIRCRAFT">Доставка дроном</option>
                                    </c:when>
                                    <c:otherwise>
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
                            <td><input class="form-control" type="text" name="deliveryDate"
                                       minlength="5" maxlength="100" style="width:200px"
                                       value="${delivery.deliveryDate}"
                                       pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}"
                                       placeholder="Формат ввода: 01-12-2016">
                            </td>
                        </tr>
                        <tr>
                            <th>Время доставки</th>
                            <td><input class="form-control" type="text" name="deliveryTime"
                                       minlength="5" maxlength="100" style="width:200px"
                                       value="${delivery.deliveryTime}"
                                       pattern="([0-1]{1}[0-9]{1}|20|21|22|23):[0-5]{1}[0-9]{1}"
                                       placeholder="Формат ввода: 12:00">
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td style="width: 700px"></td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td>
                                <input type="hidden" name="orderId" value="${order.orderId}">
                                <input type="hidden" name="deliveryId" value="${order.orderId}">
                                <c:choose>
                                    <c:when test="${order.status.name() eq 'WORK'}">
                                        <button class="btn" style="margin-top: -10px; margin-left: 8px">
                                            Взять доставку
                                        </button>
                                    </c:when>
                                    <c:when test="${order.status.name() eq 'DELIVERY' or order.status.name() eq 'CLOSED'}">
                                        <button class="btn btn-change-order"
                                                style="margin-top: -10px; margin-left: 8px;
                                                height: 30px; padding-top: 5px">
                                            Редактировать заказ
                                        </button>
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>