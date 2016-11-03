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
            <c:forEach items="${productsInBasket}" var="position">
                <tr>
                    <td>
                        <pre><img src="${position.product.imageURL}" alt="${position.product.productTitle}"
                                  height="100"></pre>
                    </td>
                    <td>
                        <p style="margin-top: 10px; margin-bottom: 0px">
                            <strong><a class="title-review" href="/product-${position.product.productId}">
                                <span style="font-size: 16px; color: #7eb105">${position.product.productTitle}</span>
                            </a></strong></p>
                        <p><span
                                style="font-size: 12px; color: darkgrey; ">Код товара: ${position.product.productId}</span>
                        </p>
                    </td>
                    <td></td>
                    <td style="text-align: right;">
                        <form action="/basket_remove_position" method=post>
                            <input type="hidden" name="id" value="${position.product.productId}">
                            <input type="hidden" name="url" value="${url}">
                            <input type="submit" value="" alt="Удалить товар"/>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Цена</span>
                            <span style="color:black;"><strong><p>${position.product.getFormatFullPrice()} ₴</p></strong></span>
                        </div>
                    </td>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Цена со скидкой</span>
                            <span style="color:black;"><strong><p>${position.product.getFormatSalePrice()} ₴</p></strong></span>
                        </div>
                    </td>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Количество</span>
                            <span class="mini-sum"
                                  style="text-align: center;"><strong><p>${position.number}</p></strong></span>
                                <%--<div>--%>
                                <%--<input type="number" value="${position.number}" min="1" max="10"/>--%>
                                <%--</div>--%>
                        </div>
                    </td>
                    <td>
                        <div class="basket-review">
                            <span style="color:gray;">Сумма</span>
                            <strong><p class="mini-sum"><span>${position.getPrice()}</span> ₴
                            </p></strong>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <div class="basket-review">
                        <span style="color:gray;text-align: right;">Итого к оплате</span>
                        <strong><p class="mini-sum"><span>${basket_price}</span> ₴
                        </p></strong>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>