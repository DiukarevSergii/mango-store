<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <h3 style="font-size: 30px">Категория: Редактировать информацию о заказе</h3>
    </div>
    <div class="product block" style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <c:if test="${message ne null}">
                <p style="color: red">${message}</p>
            </c:if>
            <form action="/manager/update-order" method="post">
                <table class="table">
                    <tr>
                        <th style="font-size: medium;">Номер заказа:</th>
                        <td>
                            <p style="width: 600px">${order.number}</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Дата и время создания заказа:</th>
                        <td>
                            <p>${order.dateCreated} ${order.timeCreated}</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Статус заказа:</th>
                        <td>
                            <select class="form-control" name="status" style="width:150px">
                                <c:choose>
                                    <c:when test="${order.status.name() eq 'NEW'}">
                                        <option value="NEW" selected>Новый</option>
                                        <option value="WORK">В работе</option>
                                        <option value="DELIVERY">Идет доставка</option>
                                        <option value="CLOSED">Закрыт</option>
                                        <option value="DELETED">Удален</option>
                                    </c:when>
                                    <c:when test="${order.status.name() eq 'WORK'}">
                                        <option value="NEW">Новый</option>
                                        <option value="WORK" selected>В работе</option>
                                        <option value="DELIVERY">Идет доставка</option>
                                        <option value="CLOSED">Закрыт</option>
                                        <option value="DELETED">Удален</option>
                                    </c:when>
                                    <c:when test="${order.status.name() eq 'DELIVERY'}">
                                        <option value="NEW">Новый</option>
                                        <option value="WORK">В работе</option>
                                        <option value="DELIVERY" selected>Идет доставка</option>
                                        <option value="CLOSED">Закрыт</option>
                                        <option value="DELETED">Удален</option>
                                    </c:when>
                                    <c:when test="${order.status.name() eq 'CLOSED'}">
                                        <option value="NEW">Новый</option>
                                        <option value="WORK">В работе</option>
                                        <option value="DELIVERY">Идет доставка</option>
                                        <option value="CLOSED" selected>Закрыт</option>
                                        <option value="DELETED">Удален</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="NEW">Новый</option>
                                        <option value="WORK">В работе</option>
                                        <option value="DELIVERY">Идет доставка</option>
                                        <option value="CLOSED">Закрыт</option>
                                        <option value="DELETED" selected>Удален</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Общая стоимость заказа</th>
                        <td>
                            <input class="form-control" type="text" name="email" value="${order.orderPrice}"
                                   minlength="5" maxlength="100" style="width:150px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Тип доставки:</th>
                        <td>
                            <p>${order.delivery.deliveryType.toString()}</p>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="hidden" name="id" value="${order.orderId}">
                            <button class="btn" style="width: 206px">
                                Редактировать информацию
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="margin-left: 300px; margin-top: -10px; margin-bottom: 20px">
                <a href="/manager/order-${order.orderId}" method=get>
                    <td>
                        <button class="btn btn-danger" style="width: 206px">
                            Сбросить все
                        </button>
                    </td>
                </a>
            </div>
        </div>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>
</div>

</body>
</html>
