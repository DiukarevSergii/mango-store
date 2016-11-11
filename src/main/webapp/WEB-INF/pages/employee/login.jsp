<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Login page</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/template/login-header.jsp"/>

    <h4 style="color: #f6731c; font-size: 20px; text-decoration: none; margin-top: 20px;">Вход в админ панель</h4>
    <div class="registration_order" style="margin-left: 20px;height: 700px">
        <form action="/j_spring_security_check" method="POST">
            <strong><p style="font-size: 16px">Ваш email:</p></strong>

            <input class="form-control" type="text" name="j_login" placeholder="Введите email"><br/>
            <strong><p style="font-size: 16px">Ваш пароль:</p></strong>

            <input class="form-control" type="password" name="j_password" placeholder="Введите email"
                   style="width: 440px;">

            <input class="btn btn-add" type="submit" value="Вход"/>

            <c:if test="${param.error ne null}">
                <p>Неправильный логин или пароль!</p>
            </c:if>

            <c:if test="${param.logout ne null}">
                <p>Вы вышли из системы.</p>
            </c:if>
        </form>
    </div>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>