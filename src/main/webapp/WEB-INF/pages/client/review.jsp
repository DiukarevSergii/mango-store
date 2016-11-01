<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Review | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block-1.jsp"/>

    <h3>Обзоры компании МАНГО</h3>
    <div class="main-block" style="padding-left: 15px; padding-bottom: 30px">
        <div>
            <h4>Видеообзор:&nbsp; Meizu M3s 16GB Grey</h4>
            <h5>Видео распаковки от покупателей</h5>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/PxbCTEpM-cw" frameborder="0"
                    allowfullscreen></iframe>
        </div>
        <br>
        <div>
            <h4>Видеообзор:&nbsp; Apple iPhone 7 Plus 32GB Black</h4>
            <h5>Полноценный видеообзор</h5>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/k5FSje29Idc" frameborder="0"
                    allowfullscreen></iframe>
        </div>
        <br>
        <div>
            <h4>Видеообзор:&nbsp; Apple iPad Air</h4>
            <h5>Распаковка и первое впечатление</h5>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/EUWKDss2xjY" frameborder="0"
                    allowfullscreen></iframe>
        </div>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>

</body>
</html>