<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Добавление сотрудника | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <meta name="robots" content="noindex,nofollow">
    <meta name="title" content="Добавление сотрудника | MANGO STORE">
</head>
<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/admin/login-header.jsp"/>
    <!-- ADMIN MENU -->
    <jsp:include page="/WEB-INF/pages/employee/admin/admin-general-menu.jsp"/>

    <div class="row admin-main-title">
        <h3 style="font-size: 30px">Категория: Добавление сотрудника</h3>
    </div>

    <div class="product block" style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <c:if test="${message ne null}">
                <p style="color: red">${message}</p>
            </c:if>
            <form action="/admin/add-employee" method="post">
                <table class="table">
                    <tr>
                        <th style="font-size: medium">ФИО:</th>
                        <td>
                            <input class="form-control" type="text" name="fullName" pattern="[А-Яа-я ]+"
                                   minlength="10" maxlength="100" style="width:700px"
                                   placeholder="Введите ФИО сотрудника" required>
                            <p class="help-block" style="font-size: 11px;margin-left: 5px">Пример: Иван Франко. Только кирилица</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Телефон:</th>
                        <td>
                            <input class="form-control" type="text" name="phone"
                                   minlength="8" maxlength="100" style="width:700px" autocomplete="on"
                                   pattern="\+[0-9]{2}\(0[0-9]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}"
                                   placeholder="+38 (0__) ___-__-__" required>
                            <p class="help-block" style="font-size: 11px; margin-left: 5px">Пример: +38(050)123-45-67</p>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Почта</th>
                        <td>
                            <input class="form-control" type="text" name="email"
                                   minlength="10" maxlength="100" style="width:700px" autocomplete="on"
                                   placeholder="Введите email сотрудника" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Пароль</th>
                        <td>
                            <input class="form-control" type="text" name="password"
                                   minlength="6" maxlength="100" style="width:700px"
                                   placeholder="Установите пароль для сотрудника" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Должность:</th>
                        <td>
                            <select class="form-control" name="position" style="width:200px" required>
                                <option value="">Выберите должность</option>
                                <option value="ADMIN">Админ</option>
                                <option value="MANAGER">Менеджер</option>
                                <option value="COURIER">Курьер</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button class="btn" style="width: 206px">
                                Добавить сотрудника
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="margin-left: 127px; margin-top: -10px; margin-bottom: 20px">
                <form action="/admin/add-employee" method=get>
                    <td>
                        <button class="btn btn-danger" style="width: 206px">
                            Сбросить все
                        </button>
                    </td>
                </form>
            </div>
        </div>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>
</div>

</body>
</html>
