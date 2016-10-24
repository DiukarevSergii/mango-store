<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="ru">
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>MANGO STORE</title>

    <!-- Bootstrap -->

    <style type="text/css">
        <%@include file="../bootstrap/css/bootstrap.css" %>
        <%@include file="../bootstrap/css/style.css" %>
        <%@include file="../bootstrap/css/bootstrap-theme.css" %>
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="container">
    <jsp:include page="/WEB-INF/pages/template/top-menu.jsp"/>

    <jsp:include page="/WEB-INF/pages/template/middle-menu.jsp"/>

    <jsp:include page="/WEB-INF/pages/template/bottom-menu.jsp"/>


    <div class="slider">
        <a href="#">
            <img src="https://raw.githubusercontent.com/DiukarevSergii/MangoStore/master/src/main/webapp/WEB-INF/img/meizu-mx6-slider-1000x343.jpg" alt="">
        </a>
    </div>

    <jsp:include page="/WEB-INF/pages/template/right-block.jsp"/>

    <div class="main block">
        <h3>Лидеры продаж</h3>

        <c:forEach items="${productsOnMain}" var="product">
            <div class="col-lg-3" id="cell-1">
                <div class="cell-on-main" id="cell-1-1">

                    <div class="in-cell" id="in-cell-1">
                        <a href="#"><img src="<c:out value="${product.imageURL}"/>" alt="" height="240">
                        </a>
                        <p class="font-review"><c:out value="${product.type}"/> <c:out value="${product.brand}"/></p>
                        <a class="title-review" href="#"><c:out value="${product.productTitle}"/></a>
                        <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'><c:out value="${product.fullPrice}"/></span>
                        </span>
                            &nbsp;<c:out value="${product.salePrice}"/>
                            <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                            <a class="btn small btn_in_section" href="#"
                               onclick="">Купить</a>
                        </p>

                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
    <div class="bottom-block">
        <p>В своем выступлении Стив призвал выпускников следовать их мечтам и несмотря на неудачи никогда не сдаваться
            —
            совет, который он искренне принял близко к сердцу.</p>
        <p>Стив Джобс был одним из основателей и долгое время главным исполнительным директором Apple. 12 июня 2005 года
            Стив выступил в Стэнфордском университете.</p>
        <p>В своем выступлении Стив призвал выпускников следовать их мечтам и несмотря на неудачи никогда не сдаваться —
            совет, который он искренне принял близко к сердцу.</p>
        <p>Стив Джобс был одним из основателей и долгое время главным исполнительным директором Apple. 12 июня 2005 года
            Стив выступил в Стэнфордском университете.</p>

        <p>В своем выступлении Стив призвал выпускников следовать их мечтам и несмотря на неудачи никогда не сдаваться —
            совет, который он искренне принял близко к сердцу.</p>
    </div>

    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual images as needed -->
<script src="js/bootstrap.js"></script>
</body>
</html>