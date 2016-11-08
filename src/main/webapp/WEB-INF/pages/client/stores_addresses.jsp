<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>Адреса магазинов | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block-1.jsp"/>

    <div class="main-block" style="height: 700px">
        <h3 style="text-decoration: none">Адреса магазинов компании МАНГО</h3>
        <p><b>город:</b> Киев</p>
        <p><b>адрес:</b> ул. Владимировская</p>
        <p><b>телефон:</b> 0 800 00 71 20</p>
        <p><b>время работы:</b> 10:00 - 17:00</p>
        <iframe src="https://www.google.com/maps/embed?pb=!1m21!1m12!1m3!1d2540.979267433131!2d30.511891665086356!3d50.44148683558517!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m6!3e0!4m0!4m3!3m2!1d50.442715199999995!2d30.512750299999997!5e0!3m2!1sru!2sua!4v1476259220753"
                width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
        </br>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>

</body>
</html>