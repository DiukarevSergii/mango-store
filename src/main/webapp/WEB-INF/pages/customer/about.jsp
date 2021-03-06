<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>О нас | MANGO STORE</title>
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
        <h3>О магазине МАНГО</h3>
        <p>Компания «МАНГО» — первая украинская специализированная сеть магазинов гаджетов и аксессуаров. Компания
            создана в 2016 году. </p>

        <p>Как и Стив Джобс* который однажды в своем выступлении призвал выпускников следовать их мечтам и несмотря
            на неудачи никогда не сдаваться (он дал этот совет, который искренне принял близко к сердцу) - так и мы
            следуем за нашими мечтами!

        <p>Мечтами сделать повседневную жизнь наших клиентов как можно более счастливой и комфортной!</p>

        <p>Мы здесь только ради Вас, Друзья! </p>

        <p>* - Стив Джобс был одним из основателей и долгое время главным исполнительным директором Apple.
            </br>12 июня 2005 года Стив выступил в Стэнфордском университете.</p>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>

</body>
</html>