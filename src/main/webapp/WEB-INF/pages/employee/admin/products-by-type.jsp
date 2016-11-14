<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="product-by-brand">
    <div class="row admin-title">
        <h3>По типам</h3>
    </div>
    <div class="row">
    <c:forEach items="${groupOfProductsByType}" var="product">
        <div class="col-lg-3" id="products">
            <div class="cell-on-main" id="cell-1-1" style="height: 310px    ">
                <div class="in-cell" id="in-cell-1">
                    <div class="image-on-main">
                        <a href="#">
                            <img src="${product.imageURL}" alt="${title}" height="240">
                        </a>
                    </div>
                    <a class="title-review" href="#" style="font-size: 24px">${product.type}</a>
                </div>
            </div>
        </div>
    </c:forEach>
    </div>
</div>