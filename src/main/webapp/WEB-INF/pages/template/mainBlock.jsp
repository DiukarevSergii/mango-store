<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main block" style="margin-bottom: 47px">
    <h3 style="padding-left: 5px;"><c:out value="${title}"/></h3>
    <c:forEach items="${groupOfProducts}" var="product">
        <div class="col-lg-3" id="cell-1">
            <div class="cell-on-main" id="cell-1-1">
                <div class="in-cell" id="in-cell-1">
                    <div class="image-on-main">
                        <a href="#"><img src="<c:out value="${product.imageURL}"/>" alt="" height="240">
                        </a>
                    </div>
                    <p class="font-review"><c:out value="${product.type}"/> <c:out value="${product.brand}"/></p>
                    <a class="title-review" href="#"><c:out value="${product.productTitle}"/></a>
                    <p class="main-review">
                        <span style='color:#f6731c;text-decoration:line-through'>
                            <span style='color:gray;'><c:out value="${product.fullPrice}"/></span>
                        </span>
                        &nbsp;<c:out value="${product.salePrice}"/>
                        <sup style="font-size:12px; margin-left:-5px;">грн</sup>
                        <a class="btn small btn_in_section" href="#"
                           onclick="">Купить</a>
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div class="col-lg-12">&nbsp;</div>

