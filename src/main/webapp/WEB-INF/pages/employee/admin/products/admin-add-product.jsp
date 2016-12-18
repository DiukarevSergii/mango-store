<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Добавление продукта | MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <meta name="robots" content="noindex,nofollow">
    <meta name="title" content="Добавление продукта | MANGO STORE">
</head>
<body style="background-image: none; background-color: lightgrey">
<div class="container">
    <!-- LOGIN HEADER -->
    <jsp:include page="/WEB-INF/pages/employee/admin/login-header.jsp"/>
    <!-- ADMIN MENU -->
    <jsp:include page="/WEB-INF/pages/employee/admin/admin-general-menu.jsp"/>

    <div class="row admin-main-title">
        <h3 style="font-size: 30px">Категория: Редактирование продукта</h3>
    </div>
    <div class="product block" style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <form action="/admin/add-product" method="post">
                <table class="table">
                    <tr>
                        <th style="font-size: medium">Название:</th>
                        <td>
                            <input class="form-control" type="text" name="productTitle"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Тип:</th>
                        <td>
                            <input class="form-control" type="text" name="type"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Бренд:</th>
                        <td>
                            <input class="form-control" type="text" name="brand"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Ссылка на изображение товара:</th>
                        <td><input class="form-control" type="text" name="imageURL"
                                   minlength="50" maxlength="400" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Полная стоимость:</th>
                        <td><input class="form-control" type="text" name="fullPrice"
                                   minlength="1" maxlength="10" style="width:100px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Цена со скидкой:</th>
                        <td><input class="form-control" type="text" name="salePrice"
                                   minlength="1" maxlength="10" style="width:100px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>На главной:</th>
                        <td>
                            <select class="form-control" name="onMain"  style="width:90px">
                                <c:choose>
                                    <c:when test="${product.onMain.name() eq 'ON_MAIN'}">
                                        <option value="ON_MAIN">Да</option>
                                        <option value="NOT_ON_MAIN" selected>Нет</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="ON_MAIN">Да</option>
                                        <option value="NOT_ON_MAIN" selected>Нет</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Характеристики:</th>
                        <td>
                            <textarea class="form-control" type="text" name="specification"
                                      maxlength="400" style="width:700px; height: 110px"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>Описание товара:</th>
                        <td>
                            <textarea class="form-control" type="text" name="description"
                                      maxlength="400"
                                      style="width:700px; min-height: 240px"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button class="btn" style="width: 206px">
                                Добавить продукт
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="margin-left: 232px; margin-top: -10px; margin-bottom: 20px">
                <form action="/admin/add-product" method=get>
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
