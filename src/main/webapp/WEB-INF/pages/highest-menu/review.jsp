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
        <h3>Обзоры компании МАНГО</h3>
        <p>Пока что нету обзоров :(</p>
    </div>
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual images as needed -->
<script src="../js/bootstrap.js"></script>
</body>
</html>