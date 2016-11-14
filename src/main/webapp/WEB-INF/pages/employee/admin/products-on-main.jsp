<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div class="product-by-brand">
    <div class="row admin-title">
        <h3>На главной</h3>
    </div>
    <div class="row" style="margin-bottom: 20px">
        <c:forEach items="${groupOfProductsOnMain}" var="product">
            <div class="col-lg-3" id="products">
                <div class="cell-on-main" id="cell-1-1" style="height: 320px">
                    <div class="in-cell" id="in-cell-1">
                        <div class="image-on-main">
                            <a href="#">
                                <img src="${product.imageURL}" alt="${title}" height="240">
                            </a>
                        </div>
                        <p style="width: 200px"><a class="title-review" href="#"
                                                   style="font-size: 18px;">${product.productTitle}</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>