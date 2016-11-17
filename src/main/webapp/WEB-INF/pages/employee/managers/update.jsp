<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <form action="/managers/update-order" method="post">
                <table class="table">
                    <tr>
                        <th style="font-size: medium;">Номер заказа:</th>
                        <td>
                            <p>${order.number}</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Дата и время создания заказа:</th>
                        <td>
                            <p>${order.dateCreated} ${order.timeCreated}</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium;">Имя покупателя:</th>
                        <td>
                            <input class="form-control" type="text" name="name" value="${customer.name}"
                                   minlength="5" maxlength="100" style="width:600px" pattern="[А-Яа-я]"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium;">Фамилия покупателя:</th>
                        <td>
                            <input class="form-control" type="text" name="name" value="${customer.surname}"
                                   minlength="5" maxlength="100" style="width:600px" pattern="[А-Яа-я]"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium;">Почта:</th>
                        <td>
                            <input class="form-control" type="text" name="name" value="${customer.email}"
                                   minlength="5" maxlength="100" style="width:600px"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium;">Телефон:</th>
                        <td>
                            <input class="form-control" type="text" name="name" value="${customer.phone}"
                                   minlength="5" maxlength="100" style="width:600px"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium;">Город:</th>
                        <td>
                            <input class="form-control" type="text" name="name" value="${customer.city}"
                                   minlength="5" maxlength="100" style="width:600px"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium;">Адресс:</th>
                        <td>
                            <input class="form-control" type="text" name="name" value="${customer.address}"
                                   minlength="5" maxlength="100" style="width:600px"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Статус заказа:</th>
                        <td>
                            <select class="form-control" name="status" style="width:200px">
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
                        <th>Тип доставки:</th>
                        <td>
                            <select class="form-control" name="deliveryType" style="width:200px">
                                <c:choose>
                                    <c:when test="${order.delivery.deliveryType.name() eq 'PICKUP'}">
                                        <option value="PICKUP" selected>Самовывоз</option>
                                        <option value="COURIER">Доставка курьером</option>
                                        <option value="UNMANNED_AIRCRAFT">Доставка дроном</option>
                                    </c:when>
                                    <c:when test="${order.delivery.deliveryType.name() eq 'COURIER'}">
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
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Общая стоимость заказа:</th>
                        <td>
                            <input class="form-control" type="text" name="orderPrice" value="${order.orderPrice}"
                                   minlength="1" maxlength="100" style="width:150px" pattern="(\d+)?([\.,]\d+)?"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Стоимость доставки:</th>
                        <td>
                            <p>${order.delivery.cost}</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Корзина заказа:</th>
                        <td></td>
                    </tr>
                </table>

                <table class="table">
                    <c:choose>
                        <c:when test="${fn:length(order.salePositions)gt 0}">
                            <tr>
                                <th>Изображение</th>
                                <th>Название товара</th>
                                <th>Код товара</th>
                                <th>Цена</th>
                                <th>Цена со скидкой</th>
                                <th>Количество</th>
                                <th>Сумма</th>
                                <th>Удалить</th>

                            </tr>
                            <c:forEach items="${order.salePositions}" var="position">
                                <tr>
                                    <td><a href="${position.product.imageURL}"> <img src="${position.product.imageURL}"
                                                                                     alt="${position.product.productTitle}"
                                                                                     height="50"></a></td>
                                    <td><a class="title-review"
                                           href="/product-${position.product.productId}">${position.product.productTitle}</a>
                                    </td>
                                    <td>${position.product.productId}</td>
                                    <td>${position.product.getFormatFullPrice()} ₴</td>
                                    <td>${position.product.getFormatSalePrice()} ₴</td>
                                    <td>${position.number}</td>
                                    <td>${position.getFormatPrice()} ₴</td>
                                    <td><label><input type="checkbox" value="${position.product.productId}"/></label>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p style="color: red">Корзина пуста</p>
                        </c:otherwise>
                    </c:choose>
                    </td>
                    </tr>
                </table>
                <table align="center">
                    <tr>
                        <td>
                            <input type="hidden" name="id" value="${order.orderId}">
                            <button class="btn btn-change-product" style="width: 220px; height: 30px; font-size: 14px">
                                Редактировать информацию
                            </button>
                        </td>
                        <td style="width: 20px"></td>
                        <td>
                            <input type="hidden" name="id" value="${order.orderId}">
                            <button class="btn btn-add-product" style="width: 220px">
                                Добавить товар
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
            <div align="center" style="margin-top: 20px; margin-bottom: 20px">
                <a href="/managers/order-${order.orderId}" method=get>
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
