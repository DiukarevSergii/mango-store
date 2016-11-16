<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row admin-title">
    <h3>Список аминов:
        <c:if test="${fn:length(admins) eq 0}">
            <span style="color: red"> Пуст!</span>
            <div style="margin-top: 10px">
                <a href="/admin/add-employee" title="Добавить нового админа">
                    <button class="btn" type="submit">Добавить нового админа</button>
                </a>
            </div>
        </c:if>
    </h3>
</div>

<div class="row">
    <div style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <c:if test="${fn:length(admins) gt 0}">
                <table class="table">
                    <tr>
                        <th>Имя</th>
                        <th>Должность</th>
                        <th>Телефон</th>
                        <th>Почта</th>
                        <th></th>
                        <th></th>
                    </tr>

                    <c:forEach items="${admins}" var="employee">
                        <tr>
                            <td> ${employee.fullName} </td>
                            <td>${employee.position.name()}</td>
                            <td>${employee.phone}</td>
                            <td>${employee.email}</td>
                            <td>
                                <a href="/admin/employee-${employee.employeeId}" method=get>
                                    <button class="btn btn-change-employee" style="margin-top: 3px">Редактировать
                                    </button>
                                </a>
                            </td>
                            <td>
                                <c:if test="${fn:length(admins) gt 1}">
                                <form action="/admin/remove-employee" method=post>
                                    <input type="hidden" name="id" value="${employee.employeeId}">
                                    <button class="btn btn-remove-employee" type="submit">Удалить</button>
                                </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${fn:length(admins) gt 0}">
                <table class="table">
                    <tr>
                        <td>
                            <a href="/admin/add-employee" title="Добавить нового админа">
                                <button class="btn" type="submit">Добавить нового админа</button>
                            </a>
                        </td>
                    </tr>
                </table>
            </c:if>
        </div>
    </div>
</div>
