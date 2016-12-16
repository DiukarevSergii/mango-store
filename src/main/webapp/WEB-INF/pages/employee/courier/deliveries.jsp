<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Доставки | Админ панель</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/courier/login-header.jsp"/>
    <!-- COURIER MENU -->
    <jsp:include page="/WEB-INF/pages/employee/courier/courier-general-menu.jsp"/>

    <div class="admin-page">
        <div class="row admin-main-title">
            <h3 style="font-size: 30px">Категория: Все ваши доставки</h3>
        </div>

        <!-- ALL DELIVERIES -->
        <div class="row admin-title">
            <h3>Список ваших доставок:
                <c:if test="${fn:length(deliveries) eq 0}">
                    <span style="color: red"> Пуст!</span>
                </c:if>
            </h3>
        </div>

        <div class="row">
            <div style="margin-top: 12px">
                <div class="col-lg-12" style="margin-top: 12px">
                    <c:if test="${fn:length(deliveries) gt 0}">
                        <table class="table">
                            <tr>
                                <th>Номер</th>
                                <th>Статус</th>
                                <th>Дата и время</th>
                                <th></th>
                                <th></th>
                            </tr>

                            <c:forEach items="${deliveries}" var="delivery">
                                <tr>
                                    <td>${delivery.getOrder().number} </td>
                                    <td>${delivery.getOrder().status.toString()}</td>
                                    <td> ${delivery.getOrder().dateCreated} ${delivery.order.timeCreated}</td>
                                    <form action="/courier/update" method="get">
                                        <td align="left">
                                            <input type="hidden" name="id" value="${delivery.order.orderId}">
                                            <button class="btn" style="margin-top: 3px">
                                                Смотреть и редактировать доставку
                                            </button>
                                        </td>
                                    </form>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>