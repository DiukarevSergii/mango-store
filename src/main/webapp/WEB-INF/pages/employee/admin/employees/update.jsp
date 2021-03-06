<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Редактировать информацию о сотруднике | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <meta name="robots" content="noindex,nofollow">
    <meta name="title" content="Редактировать информацию о сотруднике | MANGO STORE">
</head>
<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/admin/login-header.jsp"/>
    <!-- ADMIN MENU -->
    <jsp:include page="/WEB-INF/pages/employee/admin/admin-general-menu.jsp"/>

    <div class="row admin-main-title">
        <h3 style="font-size: 30px">Категория: Редактировать информацию о сотруднике</h3>
    </div>
    <div class="product block" style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <c:if test="${message ne null}">
                <p style="color: red">${message}</p>
            </c:if>
            <form action="/admin/update-employee" method="post">
                <table class="table">
                    <tr>
                        <th style="font-size: medium">ФИО:</th>
                        <td>
                            <input class="form-control" type="text" name="fullName" value="${employee.fullName}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Телефон:</th>
                        <td>
                            <input class="form-control" type="text" name="phone" value="${employee.phone}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Почта</th>
                        <td>
                            <input class="form-control" type="text" name="email" value="${employee.email}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Пароль</th>
                        <td>
                            <input class="form-control" type="password" name="password" value="${employee.password}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Должность:</th>
                        <td>
                            <select class="form-control" name="position" style="width:100px">
                                <c:choose>
                                    <c:when test="${employee.position.name() eq 'ADMIN'}">
                                        <option value="ADMIN" selected>Админ</option>
                                        <option value="MANAGER">Менеджер</option>
                                        <option value="COURIER">Курьер</option>
                                    </c:when>
                                    <c:when test="${employee.position.name() eq 'MANAGER'}">
                                        <option value="ADMIN">Админ</option>
                                        <option value="MANAGER" selected>Менеджер</option>
                                        <option value="COURIER">Курьер</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="ADMIN">Админ</option>
                                        <option value="MANAGER">Менеджер</option>
                                        <option value="COURIER" selected>Курьер</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="hidden" name="id" value="${employee.employeeId}">
                            <button class="btn" style="width: 206px">
                                Редактировать информацию
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="margin-left: 127px; margin-top: -10px; margin-bottom: 20px">
                <a href="/admin/employee-${employee.employeeId}" method=get>
                    <td>
                        <button class="btn btn-danger" style="width: 206px">
                            Сбросить все
                        </button>
                    </td>
                </a>
            </div>
        </div>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>
</div>

</body>
</html>
