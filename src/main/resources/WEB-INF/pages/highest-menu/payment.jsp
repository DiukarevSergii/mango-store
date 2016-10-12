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
        <%@include file="../css/bootstrap.css" %>
        <%@include file="../css/style.css" %>
        <%@include file="../css/bootstrap-theme.css" %>
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
                    <a data-toggle="dropdown" class="dropdown-toggle">Компания <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/about">О нас</a></li>
                        <li><a href="/stores_addresses">Магазины</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Резюме разработчика</a></li>
                    </ul>
                </li>
                <li class="topbutton">
                    <a href="/shares">Акции</a>
                </li>
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle">Клиентам<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/payment">Оплата</a></li>
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
            <a href="/">
                <img src="http://urlid.ru/aug2" style="width: 250px;">
            </a>
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
    <div id="right-block-2">
        <a><img src="http://urlid.ru/aud5" alt=""></a>
    </div>
    <div class="main-block">
        <h3>Оплата</h3>
        <p>Для Вашего удобства, оплатить любые товары компании «МАНГО» Вы можете несколькими способами:</p>
        <div class="text">
            <table>
                <tbody>
                <tr>
                    <td style="width: 20px;">
                        <pre><img src="http://s61.radikal.ru/i174/1610/45/9ec46161b88f.png" alt="" width="45"
                                  height="31"></pre>
                    </td>
                    <td>
                        <p><strong><span
                                style="font-size: 12px;">Наличный расчет</span></strong></p>
                        <p><span style="font-size: 12px; ">В магазине или при доставке курьером</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td style="width: 20px;">
                    <pre style="margin-top: -18px"><br><img src="http://s015.radikal.ru/i332/1610/db/9f1a6e78b500.png" alt="" width="40"
                                  height="28"></pre>
                    </td>
                    <td>
                        <p><strong><span
                                style="font-size: 12px;">Безналичный расчет</span></strong>
                        </p>
                        <p><span style="font-size: 12px;">
                        В магазине компании «МАНГО» банковской платежной картой Visa или MasterCard. </span>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

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
<script src="../js/bootstrap.js"></script>
</body>
</html>