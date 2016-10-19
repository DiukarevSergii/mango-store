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
        <%@include file="../../bootstrap/css/bootstrap.css" %>
        <%@include file="../../bootstrap/css/style.css" %>
        <%@include file="../../bootstrap/css/bootstrap-theme.css" %>
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

    <jsp:include page="/WEB-INF/pages/template/right-block-2.jsp"/>

    <div class="main-block" style="height: 700px">
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
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual images as needed -->
<script src="../js/bootstrap.js"></script>
</body>
</html>