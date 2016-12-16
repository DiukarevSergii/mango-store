<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Access denied</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/admin/login-header.jsp"/>

    <h2 style="text-decoration: none; margin-top: 20px;">
        Недостаточно прав доступа для ${login}!
    </h2>
    <div>
        <c:url value="/logout" var="logoutUrl"/>
        <p>Нажмите для выхода: <a href="${logoutUrl}">LOGOUT</a></p>
    </div>
    <div class="registration_order" style="margin-left: 20px;height: 700px">
    </div>


    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>