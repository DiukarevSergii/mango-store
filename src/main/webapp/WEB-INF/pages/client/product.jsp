<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
    <%--<meta name="robots" content="index,follow">--%>
    <%--<meta name="description" content="${product.description}"/>--%>
    <meta name="keywords" content="${product.productTitle}"/>
    <meta name="title" content="${product.productTitle} | MANGO STORE">
    <title>${product.productTitle} | MANGO STORE</title>
</head>
<body>
<div class="container">
    <!-- MENU -->
    <jsp:include page="/WEB-INF/pages/template/menu.jsp"/>

    <div class="product block" style="padding-left:5px">
        <h3>${product.productTitle}</h3>
        <h5>Артикул: ${product.productId}</h5>
        <div class="row">
            <div class="col-lg-4">

                <a href="${product.imageURL}">
                    <img src="${product.imageURL}" alt="${product.productTitle}" height="320"
                         style="float: left; padding: 0px; margin-right: -20px">
                </a>
            </div>
            <div class="col-lg-8" style="margin-left: -50px; padding-top: 10px;">
                    <span class="main-review">
                    <span style="background-color: #f5e79e ; padding-bottom: 4px">
                        &nbsp;
                        <c:if test="${product.getFormatFullPrice() !=  product.getFormatSalePrice()}">
                    <span style='color:#f6731c;text-decoration:line-through'>
                    <span style='color:gray;'>${product.getFormatFullPrice()}
                    </span>
                    </span>
                        </c:if>
                    &nbsp;&nbsp;${product.getFormatSalePrice()}&nbsp;
                    <sup style="font-size:12px; margin-left:-5px;">грн&nbsp;</sup>
                    </span>
                        <br>
                        <a class="btn btn_in_section" style="width: 206px" href="#" onclick="">
                            Купить
                        </a>
                    </span>

                <p style="font-size: medium">${product.specification}</p>

            </div>
        </div>
        <!-- RIGHT BLOCK -->
        <jsp:include page="/WEB-INF/pages/template/right-block-2.jsp"/>
        <div style="margin-left: 2px; margin-top: 0px;width: 720px; float: left;">
            ${product.description}
        </div>
    </div>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>
</body>
</html>
