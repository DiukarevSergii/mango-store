<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Вы успешно ${message} | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <meta name="robots" content="noindex,nofollow">
    <meta name="title" content="Редактирование продукта ${product.productTitle} | MANGO STORE">

</head>
<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/template/login-header.jsp"/>
    <!-- ADMIN MENU -->
    <jsp:include page="/WEB-INF/pages/employee/admin/admin-general-menu.jsp"/>

    <div class="row admin-main-title">
        <h3 style="font-size: 30px">Категория: Редактирование продукта</h3>
    </div>
    <div class="product block" style="margin-top: 40px" align="center">
        <h3>Вы успешно ${message}</h3>
    </div>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>
</div>

</body>
</html>
