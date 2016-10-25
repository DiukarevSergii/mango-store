<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- TOP MENU -->
    <jsp:include page="/WEB-INF/pages/template/top-menu.jsp"/>
    <!-- MIDDLE MENU -->
    <jsp:include page="/WEB-INF/pages/template/middle-menu.jsp"/>
    <!-- BOTTOM MENU -->
    <jsp:include page="/WEB-INF/pages/template/bottom-menu.jsp"/>
    <!-- SLIDER -->
    <jsp:include page="/WEB-INF/pages/template/slider.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block.jsp"/>

    <div class="main block">
        <h3>Лидеры продаж</h3>
        <c:forEach items="${productsOnMain}" var="product">
            <div class="col-lg-3" id="cell-1">
                <div class="cell-on-main" id="cell-1-1">
                    <div class="in-cell" id="in-cell-1">
                        <div class="image-on-main">
                            <a href="#"><img src="<c:out value="${product.imageURL}"/>" alt="" height="240">
                            </a>
                        </div>
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

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>