<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Все доступные заказы | Админ панель</title>
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
            <h3 style="font-size: 30px">Категория: Все доступные заказы</h3>
        </div>
        <!-- ALL ORDERS -->
        <jsp:include page="/WEB-INF/pages/employee/courier/orders.jsp"/>
    </div>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>