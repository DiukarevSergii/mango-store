<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>MANGO STORE | News</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block.jsp"/>

    <div class="main-block" style="height: 700px">
        <h3>Новости компании МАНГО</h3>
        <p>Пока что нету новостей :(</p>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>

</body>
</html>