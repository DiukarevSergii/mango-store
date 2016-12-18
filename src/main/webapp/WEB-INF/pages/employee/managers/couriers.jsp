<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Заказы | Админ панель</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/managers/login-header.jsp"/>
    <!-- MANAGER MENU -->
    <jsp:include page="/WEB-INF/pages/employee/managers/manager-general-menu.jsp"/>

    <div class="admin-page">
        <div class="row admin-main-title">
            <h3 style="font-size: 30px">Категория: Курьеры</h3>
        </div>
        <!-- ALL ORDERS -->
        <div class="row admin-title">
            <h3>Список курьеров:
                <c:if test="${fn:length(couriers) eq 0}">
                    <span style="color: red"> Пуст!</span>
                </c:if>
            </h3>
        </div>

        <div class="row">
            <div style="margin-top: 12px; height: 700px">
                <div class="col-lg-12" style="margin-top: 12px">
                    <c:if test="${fn:length(couriers) gt 0}">
                        <table class="table">
                            <tr>
                                <th>ФИО</th>
                                <th></th>
                                <th>Телефон</th>
                                <th></th>
                                <th>Почта</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <c:forEach items="${couriers}" var="courier">
                                <tr>
                                    <td>${courier.fullName} </td>
                                    <td></td>
                                    <td>${courier.phone}</td>
                                    <td></td>
                                    <td> ${courier.email}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
        <!-- BASEMENT -->
        <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

    </div>
</div>
</body>
</html>