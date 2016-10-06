<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ru">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>MANGO STORE</title>

    <!-- Bootstrap -->
    <script type="text/javascript">
        $(document).ready(function () {
            $(".dropdown-toggle").dropdown('toggle');
        });
    </script>

    <style type="text/css">
        <%@include file="css/bootstrap.css" %>
        <%@include file="css/style.css" %>
        <%@include file="css/bootstrap-theme.css" %>
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>

<body>
<div class="container">
    <div class="row">
        <h1>MANGO STORE</h1>
        <div class="row topmenu">
            <div class="col-lg-8" id="mango_top_menu">
                <%--<ul class="nav nav-pills">--%>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Messages <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Inbox</a></li>
                            <li><a href="#">Drafts</a></li>
                            <li><a href="#">Sent Items</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Trash</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Admin <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Settings</a></li>
                        </ul>
                    </li>
                <%--</ul>--%>
            </div>
        </div>

        <div class="bs-example">
            <div class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
        <%--<div class='item'>--%>
        <%--<div class="dropdown"><a href="/about/" class="ltitle">Компания</a></div>--%>
        <%--<div class="smitem smitem0" style="">--%>
        <%--<div class="ritem" style="">--%>
        <%--<div class=""><a href="/about/" class="">О нас</a></div>--%>
        <%--<div class=""><a href="/about/vacancy/" class="">Вакансии</a></div>--%>
        <%--<div class=""><a href="/stores_addresses/" class="">Магазины</a></div>--%>
        <%--<div class=""><a href="/company/warehouse/" class="">Оптовым клиентам</a></div>--%>
        <%--<div class=""><a href="/company/corporative/" class="">Корпоративным клиентам</a></div>--%>
        <%--<div class=""><a href="/support/" class="">Отдел развития сети</a></div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>
        <%--<a href="/about/vacancy/" class="item">Карьера</a><a href="/stores_addresses/" class="item">Магазины</a><a--%>
        <%--href="/shares/" class="item">Акции</a>--%>
        <%--<div class='item'><a href="/pages/garantiya_i_servis/" class="ltitle">Клиентам</a>--%>
        <%--<div class="smitem smitem4" style="">--%>
        <%--<div class="ritem" style="">--%>
        <%--<div class=""><a href="/pages/oplata/" class="">Оплата</a></div>--%>
        <%--<div class=""><a href="/pages/dostavka/" class="">Доставка</a></div>--%>
        <%--<div class=""><a href="/service-center-citrus/" class="">Сервисный центр Цитрус</a></div>--%>
        <%--<div class=""><a href="/pages/garantiya_i_servis/" class="">Условия гарантии и возврата</a>--%>
        <%--</div>--%>
        <%--<div class=""><a href="/academy/" class="">Обучение в "Цитрус Академии"</a></div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class='item'><a href="/support/" class="ltitle">Поддержка</a>--%>
        <%--<div class="smitem smitem5" style="">--%>
        <%--<div class="ritem" style="">--%>
        <%--<div class=""><a href="/support/" class="">Служба поддержки клиентов</a></div>--%>
        <%--<div class=""><a href="/promo/firmware/" class="">Прошивки для смартфонов</a></div>--%>
        <%--<div class=""><a href="/promo/instructions/?q=1" class="">Инструкции</a></div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class='item'><a href="/news/" class="ltitle">Пресс-центр</a>--%>
        <%--<div class="smitem smitem6" style="">--%>
        <%--<div class="ritem" style="">--%>
        <%--<div class=""><a href="/news/" class="">Новости</a></div>--%>
        <%--<div class=""><a href="/press-center/for-press/" class="">Для СМИ</a></div>--%>
        <%--<div class=""><a href="//www.citrus.ua/reviews/" class="">Обзоры</a></div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class='item'><a href="/pages/citrus-services/" class="ltitle">Цитрус Сервисы</a>--%>
        <%--<div class="smitem smitem7" style="">--%>
        <%--<div class="ritem" style="">--%>
        <%--<div class=""><a href="/promo/gift_card/" class="">Подарочная карта Цитрус</a></div>--%>
        <%--<div class=""><a href="/master/" class="" target="_blank">Цитрус Мастер</a></div>--%>
        <%--<div class=""><a href="/shop/goods/apps/2046/" class="">Программное&nbsp;обеспечение</a>--%>
        <%--</div>--%>
        <%--<div class=""><a href="https://my.citrus.ua/uk/tradein" class="">Цитрус Обмен</a></div>--%>
        <%--<div class=""><a href="/insurance/" class="">Цитрус Защита</a></div>--%>
        <%--<div class=""><a href="/pages/kupit-v-kredit/" class="">Цитрус Кредиты</a></div>--%>
        <%--<div class=""><a href="https://my.citrus.ua/club" class="">Цитрус Клуб</a></div>--%>
        <%--<div class=""><a href="/academy/" class="" target="_blank">Цитрус Академия</a></div>--%>
        <%--<div class=""><a href="//tunein.com/radio/Citrusua-Radio-s252784/" class="">Цитрус Радио</a>--%>
        <%--</div>--%>
        <%--<div class=""><a href="/service-center-citrus/" class="">Цитрус Сервис</a></div>--%>
        <%--<div class=""><a href="/promopages/citrus-prokat/" class="">Цитрус / Прокат</a></div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

    </div>
</div>

<%--<div class="navbar navbar-default">--%>
<%--<div class="dropdown">--%>
<%--<button class="btn btn-info btn-sm dropdown-toggle" type="button" data-toggle="dropdown">--%>
<%--Смартфоны &nbsp;<span class="caret"></span>--%>
<%--</button>--%>
<%--<ul class="dropdown-menu">--%>
<%--<li><a href="#">Smartphones</a></li>--%>
<%--<li><a href="#">Tables</a></li>--%>
<%--<li><a href="#">Watch</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="col-lg-6">--%>
<%--<div class="row">--%>
<%--<div class="col-lg-6">--%>
<%--<div class='item'><a href="/about/" class="ltitle">Компания</a>--%>
<%--<div class="smitem smitem0" style="">--%>
<%--<div class="ritem" style="">--%>
<%--<div class=""><a href="/about/" class="">О нас</a></div>--%>
<%--<div class=""><a href="/about/vacancy/" class="">Вакансии</a></div>--%>
<%--<div class=""><a href="/stores_addresses/" class="">Магазины</a></div>--%>
<%--<div class=""><a href="/company/warehouse/" class="">Оптовым клиентам</a></div>--%>
<%--<div class=""><a href="/company/corporative/" class="">Корпоративным клиентам</a></div>--%>
<%--<div class=""><a href="/support/" class="">Отдел развития сети</a></div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="col-lg-6"></div>--%>
<%--</div>--%>
<%--</div>--%>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
</body>
</html>