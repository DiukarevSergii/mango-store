<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="product-by-brand" style="margin-bottom: 20px">
    <div class="row admin-title">
        <h3>По брендам</h3>
    </div>
    <div class="row">
        <c:forEach items="${groupOfProductsByBrand}" var="product">
            <div class="col-lg-3" id="products">
                <div class="cell-on-main" id="cell-1-1" style="height: 300px    ">
                    <div class="in-cell" id="in-cell-1">
                        <div class="image-on-main">
                            <a href="/admin/brand/${product.brand}">
                                <img src="${product.imageURL}" alt="${title}" height="240">
                            </a>
                        </div>
                        <a class="title-review" href="/admin/brand/${product.brand}" style="font-size: 18px">${product.brand}</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

