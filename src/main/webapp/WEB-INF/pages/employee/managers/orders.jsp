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
                        <th></th>
                        <th>Статус</th>
                        <th></th>
                        <th>Дата и время</th>
                        <th></th>
                        <th></th>
                    </tr>

                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.number} </td>
                            <td></td>
                            <td>${order.status.toString()}</td>
                            <td></td>
                            <td> ${order.dateCreated} ${order.timeCreated}</td>
                            <td align="center">
                                <a href="/managers/order-${order.orderId}" method=get>
                                    <button class="btn btn-change-order" style="margin-top: 3px">
                                        Смотреть и редактировать
                                    </button>
                                </a>
                            </td>
                            <td>
                                <form action="/managers/remove-order" method="post">
                                    <input type="hidden" name="id" value="${order.orderId}">
                                    <button class="btn btn-remove-order" type="submit">Удалить</button>
                                </form>
                            </td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${fn:length(managers) gt 0}">
                <table class="table">
                    <tr>
                        <a href="/manager/remove-all-orders" title="Удалить все заказы">
                            <button class="btn btn-remove-all-order" type="submit">Удалить все заказы
                            </button>
                        </a>
                        </td>
                    </tr>
                </table>
            </c:if>
        </div>
    </div>
</div>