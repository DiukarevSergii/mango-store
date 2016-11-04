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

    <div class="main-block" style="height: 700px">
        <p><b>${title}</b>, cпасибо за заказ!</p>
        <br><br>
        <p>Менеджер по продажам свяжется с Вами в течение часа!</p>
        <p>Номер заказа: <b></b></p>
        <p>Будем рады видеть Вас снова!</p>
        <p>Телефон для связи с нами:</p>
        <p>+38(093)123-45-67</p>
        <p>С уважением, ваш <b>МАНГО</b></p>
        ${title1}
    </div>

    <!-- PRODUCTS IN CART -->
    <%--<jsp:include page="/WEB-INF/pages/template/products_in_cart.jsp"/>--%>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>