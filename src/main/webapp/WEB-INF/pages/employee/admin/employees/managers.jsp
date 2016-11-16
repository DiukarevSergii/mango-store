<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row admin-title">
    <h3>Список менеджеров:
        <c:if test="${fn:length(managers) eq 0}">
            <span style="color: red"> Пуст!</span>
            <div style="margin-top: 10px">
                <a href="/admin/add-employee" title="Добавить нового менеджера">
                    <button class="btn" type="submit">Добавить нового менеджера</button>
                </a>
            </div>
        </c:if>
    </h3>

</div>
<div class="row">
    <div style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <c:if test="${fn:length(managers) gt 0}">
                <table class="table">
                    <tr>
                        <th>Имя</th>
                        <th>Должность</th>
                        <th>Телефон</th>
                        <th>Почта</th>
                        <th></th>
                        <th></th>

                    </tr>

                    <c:forEach items="${managers}" var="employee">
                        <tr>
                            <td> ${employee.fullName} </td>
                            <td>${employee.position.name()}</td>
                            <td>${employee.phone}</td>
                            <td>${employee.email}</td>
                            <td>
                                <form action="/admin/update-employee" method=post>
                                    <input type="hidden" name="id" value="${employee.employeeId}">
                                    <button class="btn btn-change-employee" type="submit">Редактировать</button>
                                </form>
                            </td>
                            <td align="left">
                                <form action="/admin/remove-employee" method=post>
                                    <input type="hidden" name="id" value="${employee.employeeId}">
                                    <button class="btn btn-remove-employee" type="submit">Удалить</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${fn:length(managers) gt 0}">
                <table class="table">
                    <tr>
                        <td>

                            <a href="" title="Добавить нового менеджера">
                                <button class="btn" type="submit">Добавить нового менеджера</button>
                            </a>

                            <a href="" title="Удалить всех менеджеров">
                                <button class="btn btn-remove-all-employee" type="submit">Удалить всех менеджеров
                                </button>
                            </a>

                        </td>
                    </tr>
                </table>
            </c:if>
        </div>
    </div>
</div>