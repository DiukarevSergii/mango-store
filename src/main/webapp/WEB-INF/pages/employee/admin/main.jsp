<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Админ панель</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/template/login-header.jsp"/>
    <!-- ADMIN MENU -->
    <jsp:include page="/WEB-INF/pages/employee/admin/admin-general-menu.jsp"/>

    <div class="admin-page">
        <div class="row admin-main-title">
            <h3 style="font-size: 30px">Категория: Товары</h3>
        </div>
        <!-- PRODUCTS BY TYPE -->
        <jsp:include page="/WEB-INF/pages/employee/admin/products-by-type.jsp"/>
        <!-- PRODUCTS BY BRAND -->
        <jsp:include page="/WEB-INF/pages/employee/admin/products-by-brand.jsp"/>
        <c:set var="count" value="0" scope="page"/>
        <!-- PRODUCTS ON MAIN PAGE -->
        <jsp:include page="/WEB-INF/pages/employee/admin/products-on-main.jsp"/>
        <!-- ADD PRODUCT -->
        <div class="row admin-title" style="height: 15px; margin-top: -10px">
        </div>
        <div align="center" style="margin-top: -15px; margin-bottom: 25px">
            <input class="btn btn-add-product" type="submit" value="Добавить товар">
        </div>
    </div>


    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>