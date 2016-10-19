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
            <img src="http://urlid.ru/auco" alt="">
        </a>
    </div>

    <jsp:include page="/WEB-INF/pages/template/right-block-1.jsp"/>

    <div class="main block">
        <h3>Лидеры продаж</h3>
        <div class="col-lg-3" id="cell-1">
            <div class="cell-on-main" id="cell-1-1">
                <div class="in-cell" id="in-cell-1">
                    <a href="#"><img src="http://urlid.ru/audh" alt="" height="240">
                    </a>
                    <p class="font-review">Смартфоны Apple</p>
                    <a class="title-review" href="#">iPhone 7 (Jet Black)</a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'>35 000</span>
                        </span>
                        &nbsp;17 999 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>

                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-2">
            <div class="cell-on-main">
                <div class="in-cell" id="in-cell-2-1">
                    <a href="#"><img src="http://urlid.ru/audg" alt="" height="240"></a>
                </div>
                <div class="in-cell" id="in-cell-2-2">
                    <p class="font-review">Смартфоны Samsung</p>
                    <a class="title-review" href="#">Samsung Galaxy S6</a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'>18 000</span>
                        </span>
                        &nbsp;11 199 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-3">
            <div class="cell-on-main">
                <div class="in-cell" id="in-cell-3">
                    <a href="#"><img src="http://urlid.ru/audi" alt="" height="240"></a>
                    <p class="font-review">Смартфоны Meizu</p>
                    <a class="title-review" href="#">Meizu M3 Note</a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'>4 099</span>
                        </span>
                        &nbsp;2 299 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-4">
            <div class="cell-on-main">
                <div class="in-cell" id="cell-4-1">
                    <a href="#"><img src="http://urlid.ru/audk" alt="" height="240"></a>
                    <p class="font-review">Планшеты Apple</p>
                    <a class="title-review" href="#">Apple iPad Air 2</a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'>12 000</span>
                        </span>
                        &nbsp;10 999 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-5">
            <div class="cell-on-main">
                <div class="in-cell" id="cell-4-2">
                    <a href="#"><img src="http://urlid.ru/audl" alt="" height="240"></a>
                    <p class="font-review">Планшеты Xiaomi</p>
                    <a class="title-review" href="#">Xiaomi MiPad 2 </a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'>4 700</span>
                        </span>
                        &nbsp;3 999 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-6">
            <div class="cell-on-main">
                <div class="in-cell" id="cell-4-3">
                    <a href="#"><img src="http://urlid.ru/audm" alt="" height="240"></a>
                    <p class="font-review">Смартфоны Apple</p>
                    <a class="title-review" href="#">iPhone 7 (Jet Black)</a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'>35 000</span>
                        </span>
                        &nbsp;11 199 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>
                </div>
            </div>
        </div>
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