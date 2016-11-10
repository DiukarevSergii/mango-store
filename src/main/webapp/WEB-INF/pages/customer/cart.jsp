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
    <h3>Моя корзина</h3>

<c:choose>
    <c:when test="${cart_size > 0}">
    <!-- PRODUCTS IN CART -->
    <jsp:include page="/WEB-INF/pages/template/products_in_cart.jsp"/>

    <!-- REGISTRATION ORDER-->
    <jsp:include page="/WEB-INF/pages/template/registration_order.jsp"/>
    </c:when>
    <c:otherwise>
        Ваша корзина все ещё пуста =(
    </c:otherwise>
</c:choose>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>