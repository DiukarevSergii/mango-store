<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Вход в систему | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block-1.jsp"/>
    <!-- AUTHORIZATION -->
    <div class="main-block" style="height: 700px">
        <form action="/j_spring_security_check" method="POST">

            <c:if test="${param.error ne null}">
                <br>
                <p>Неправильный логин или пароль!</p>
            </c:if>

            <c:if test="${param.logout ne null}">
                <br>
                <p>Вы вышли из системы.</p>
            </c:if>

            <h3>Пожалуйста выполните вход в систему:</h3>
            Ваш E-mail:<br/><input type="text" name="j_login"><br/>
            Ваш пароль:<br/><input type="password" name="j_password" style="width: 440px" autocomplete="on">
            <br/>
            <input type="submit" class="btn btn-add" value="Войти" />
            <p class="help-block" style="font-size: 14px">Войдите или <a href="/new_user">зарегестрируйтесь.</a></p>

        </form>

    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>

</body>
</html>