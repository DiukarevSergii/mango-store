<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="products block" style="margin-bottom: 47px">
    <h3 style="padding-left: 5px;">${title}</h3>
    <c:forEach items="${groupOfProducts}" var="product">
        <div class="col-lg-3" id="products">
            <div class="cell-on-main" id="cell-1-1">
                <div class="in-cell" id="in-cell-1">
                    <div class="image-on-main">
                        <a href="/admin/product-${product.productId}" method=get >
                            <img src="<c:out value="${product.imageURL}"/>" alt="${title}" height="240">
                        </a>
                    </div>
                    <p class="font-review">${product.type} ${product.brand}</p>
                    <a class="title-review" href="/admin/product-${product.productId}" method=get ><c:out
                            value="${product.productTitle}"/></a>
                    <p class="main-review">
                        <c:choose>
                        <c:when test="${product.getFormatFullPrice() !=  product.getFormatSalePrice()}">
                        <span style='color:#f6731c;text-decoration:line-through'>
                                    <span style='color:gray;'>${product.getFormatFullPrice()}</span>
                                </span>
                        </c:when>
                        <c:otherwise>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:otherwise>
                        </c:choose>
                        &nbsp;${product.getFormatSalePrice()}
                        <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                    <a href="/admin/product-${product.productId}" method=get >
                        <button class="btn btn-change-product" style="margin-top: 3px">Редактировать товар</button>
                    </a>
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<c:choose>
    <c:when test="${groupOfProducts.size() == 0}">
        <div class="col-lg-12" style="height: 250px; font-size: medium">
            <p>Нет доступных товаров. </p>
        </div>
    </c:when>
    <c:otherwise>
        <div class="col-lg-12">&nbsp;</div>
    </c:otherwise>
</c:choose>