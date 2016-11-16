<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <meta name="robots" content="noindex,nofollow">
    <meta name="title" content="Редактирование продукта ${product.productTitle} | MANGO STORE">
    <title>Редактирование продукта ${product.productTitle} | MANGO STORE</title>
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
            <form action="/admin/update-product" method="post">
                <table class="table">
                    <tr>
                        <th style="font-size: medium">Название:</th>
                        <td>
                            <input class="form-control" type="text" name="productTitle" value="${product.productTitle}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Тип:</th>
                        <td>
                            <input class="form-control" type="text" name="type" value="${product.type}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="font-size: medium">Бренд:</th>
                        <td>
                            <input class="form-control" type="text" name="brand" value="${product.brand}"
                                   minlength="5" maxlength="100" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Изображение товара:</th>
                        <td><img src="${product.imageURL}" alt="${product.productTitle}" height="320"
                                 style="float: left; padding: 0px; margin-right: -20px">
                        </td>
                    <tr>
                        <th>Ссылка:</th>
                        <td><input class="form-control" type="text" name="imageURL" value="${product.imageURL}"
                                   minlength="50" maxlength="400" style="width:700px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Полная стоимость:</th>
                        <td><input class="form-control" type="text" name="fullPrice" value="${product.fullPrice}"
                                   minlength="1" maxlength="10" style="width:90px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Цена со скидкой:</th>
                        <td><input class="form-control" type="text" name="salePrice" value="${product.salePrice}"
                                   minlength="1" maxlength="10" style="width:90px" required>
                        </td>
                    </tr>
                    <tr>
                        <th>На главной:</th>
                        <td>
                            <select class="form-control" name="onMain"  style="width:90px">
                                <c:choose>
                                    <c:when test="${product.onMain.name() eq 'ON_MAIN'}">
                                        <option value="ON_MAIN" selected>Да</option>
                                        <option value="NOT_ON_MAIN">Нет</option>
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
                                      maxlength="400" style="width:700px; height: 110px">${product.specification}
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>Описание товара:</th>
                        <td>
                            <textarea class="form-control" type="text" name="description"
                                      maxlength="400" style="width:700px; min-height: 240px">${product.description}
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="hidden" name="id" value="${product.productId}">
                            <button class="btn" style="width: 206px">
                                Обновить
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="margin-left: 195px; margin-top: -10px; margin-bottom: 20px">
                <form action="/admin/remove-product" method=post>
                    <td>
                        <input type="hidden" name="id" value="${product.productId}">
                        <button class="btn btn-danger" style="width: 206px">
                            Удалить товар
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
