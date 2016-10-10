<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

</head>

<body>
<div class="container">
    <div class="row topmenu">
        <div class="col-lg-12">
            <ul class="nav nav-pills">
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Компания <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">О нас</a></li>
                        <li><a href="#">Магазины</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Резюме разработчика</a></li>
                    </ul>
                </li>
                <li class="topbutton">
                    <a href="#">Акции</a>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Клиентам<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Оплата</a></li>
                        <li><a href="#">Доставка</a></li>
                        <li><a href="#">Сервисный центр</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Поддержка<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Служба поддержки клиентов</a></li>
                        <li><a href="#">Прошивка смартфонов</a></li>
                    </ul>
                </li>
                <li class="topbutton">
                    <a href="#">Новости</a>
                </li>
                <li class="topbutton">
                    <a href="#">Обзоры</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Личный кабинет</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="row middle">
        <div class="col-lg-7 logo">
            <img src="http://urlid.ru/au3m">
        </div>
        <div class="col-lg-3">
            <div class="middle-menu-centr">
                <p class="order">Оформить заказ:</p>
                <p class="phone">0 800 00 71 20</p>
                <p class="order">Служба поддержки клиентов:</p>
                <p class="phone">0 800 00 71 30</p>
            </div>
        </div>
        <div class="col-lg-1 pull-right">
            <div class="basket">
                <img src="http://urlid.ru/aucg" alt="basket">
                &nbsp; <a href="#"> Пусто :( </a>
            </div>
        </div>
    </div>

    <div class="row bottom-menu">
        <div class="col-lg-12">
            <ul class="nav nav-pills bmenu" id="bmenu">
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Apple</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">О нас</a></li>
                        <li><a href="#">Магазины</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Резюме разработчика</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">LG</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Оплата</a></li>
                        <li><a href="#">Доставка</a></li>
                        <li><a href="#">Сервисный центр</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Xiaomi</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Оплата</a></li>
                        <li><a href="#">Доставка</a></li>
                        <li><a href="#">Сервисный центр</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Samsung</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">О нас</a></li>
                        <li><a href="#">Магазины</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Резюме разработчика</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Планшеты</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Оплата</a></li>
                        <li><a href="#">Доставка</a></li>
                        <li><a href="#">Сервисный центр</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Смартфоны</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Оплата</a></li>
                        <li><a href="#">Доставка</a></li>
                        <li><a href="#">Сервисный центр</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="slider">
        <a href="#">
            <img src="http://urlid.ru/auco" alt="">
        </a>
    </div>
    <div id="right-block">
        <a><img src="http://urlid.ru/aud5" alt=""></a>
    </div>
    <div class="main block">
        <h3 id="lider">Лидеры продаж</h3>
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
                        &nbsp;11 199 <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                    </p>

                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-2">
            <div class="cell-on-main">
                <div class="in-cell" id="in-cell-2">
                    <a href="#"><img src="http://urlid.ru/audg" alt="" height="240"></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-3">
            <div class="cell-on-main">
                <div class="in-cell" id="in-cell-3">
                    <a href="#"><img src="http://urlid.ru/audi" alt="" height="240"></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3" id="cell-4">
            <div class="cell-on-main" id="cell-4-1">
                <a href="#"><img src="http://urlid.ru/audk" alt="" height="240"></a>
            </div>
        </div>
        <div class="col-lg-3" id="cell-5">
            <div class="cell-on-main" id="cell-4-2">
                <a href="#"><img src="http://urlid.ru/audl" alt="" height="240"></a>
            </div>
        </div>
        <div class="col-lg-3" id="cell-6">
            <div class="cell-on-main" id="cell-4-3">
                <a href="#"><img src="http://urlid.ru/audm" alt="" height="240"></a>
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
    <div class="basement">
        <div class="col-lg-12">
            <div id="basement-0"></div>
            <div>
                <p id="basement-1">© Интернет-магазин Манго - гаджеты и аксессуары 2016</p>
            </div>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual images as needed -->
<script src="js/bootstrap.js"></script>
</body>
</html>