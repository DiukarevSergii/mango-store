<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/right-block-1.jsp"/>
    <h3>Моя корзина</h3>
    <div class="text">
        <table>
            <tbody>
            <c:forEach items="${productsInBasket}" var="product">
                <tr>
                    <td>
                        <pre><img src="${product.imageURL}" alt="${product.productTitle}" height="100"></pre>
                    </td>
                    <td>
                        <p style="margin-top: 10px; margin-bottom: 0px">
                            <strong><a class="title-review" href="/product-${product.productId}">
                                <span style="font-size: 16px; color: #7eb105">${product.productTitle}</span>
                            </a></strong></p>
                        <p><span style="font-size: 12px; color: darkgrey; ">Код товара: ${product.productId}</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Цена</span>
                            <span style="color:black;"><strong><p>${product.getFormatFullPrice()} ₴</p></strong></span>
                        </div>
                    </td>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Цена со скидкой</span>
                            <span style="color:black;"><strong><p>${product.getFormatSalePrice()} ₴</p></strong></span>
                        </div>
                    </td>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Количество: ${product.getQuantity()}</span>
                            <div class="section  number-plus-minus">
                                <input class="qnt" type="number" value="${product.quantity}" min="1" max="10"/>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Сумма</span>
                            <strong><p class="mini-sum"><span>${product.salePrice * product.quantity}</span> ₴
                            </p></strong>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>