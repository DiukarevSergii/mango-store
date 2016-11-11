<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row topmenu">
</div>
<div class="row middle">
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 logo">
        <a href="/">
            <img src="/resources/img/logo.png" style="width: 250px; margin-top: 10px">
        </a>
    </div>
    <div style="float: right; height: 100px; margin-top: 10px; ">
        <h4 style="font-size: 14px; color: floralwhite">Добрый день, ${admin.fullName}</h4>
        <h4 style="line-height: 0.7; text-decoration: none; margin-top: 0px; margin-right:15px;font-size: 14px; color: floralwhite">
            <p>Вы вошли как: ${admin.email}</p>
            <p>Ваш уровень доступа: ${admin.getPosition()}</p>
            <c:url value="/logout" var="logoutUrl"/>
            <span style="text-decoration: blink; margin-top: 0px; font-size: 14px;  color: floralwhite">
                <a href="${logoutUrl}" style="font-size: 14px;  color: floralwhite">>Нажмите для выхода</a>
            </span>
        </h4>
        <div class="registration_order" style="margin-left: 20px;height: 700px">
        </div>
    </div>
</div>
<div class="row bottom-menu">
</div>

