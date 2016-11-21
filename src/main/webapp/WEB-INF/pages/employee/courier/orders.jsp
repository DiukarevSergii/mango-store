<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row admin-title">
    <h3>Список заказов:
        <c:if test="${fn:length(orders) eq 0}">
            <span style="color: red"> Пуст!</span>
        </c:if>
    </h3>
</div>

<div class="row">
    <div style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <c:if test="${fn:length(orders) gt 0}">
                <table class="table">
                    <tr>
                        <th>Номер</th>
                        <th>Статус</th>
                        <th>Дата и время</th>
                        <th>Город</th>
                        <th></th>
                    </tr>

                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.number}</td>
                            <td>${order.status.toString()}</td>
                            <td> ${order.dateCreated} ${order.timeCreated}</td>
                            <td>${order.customer.city}</td>
                            <form action="/courier/update" method="get">
                                <td align="left">
                                    <input type="hidden" name="id" value="${order.orderId}">
                                    <button class="btn" style="margin-top: 3px">
                                        Взять доставку
                                    </button>
                                </td>
                            </form>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>