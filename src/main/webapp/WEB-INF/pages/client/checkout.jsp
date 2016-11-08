<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block-1.jsp"/>

    <div class="main-block" style="height: 350px">
        <h3><strong>${name}</strong>, cпасибо за заказ!</h3>
        <br><br>
        <p>Менеджер по продажам свяжется с Вами в ближайшее время!</p>
        <p>Номер вашего заказа: <b>${order.number}</b></p>
        <p>Будем рады видеть Вас снова!</p>
        <p>Телефон для связи с нами:</p>
        <p>+38(093)539-53-05</p>
        <br>
        <p>С уважением, ваш <b>МАНГО</b></p>
    </div>

    <h4 style="color: orange;">Вы заказали:</h4>
    <!-- PRODUCTS IN CART -->
    <jsp:include page="/WEB-INF/pages/template/products_in_cart.jsp"/>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>