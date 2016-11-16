<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row admin-title">
    <h3>Список курьеров:</h3>
</div>
<div class="row">
    <div style="margin-top: 12px">
        <div class="col-lg-12" style="margin-top: 12px">
            <div class="row section-name text-shadow">
                <b>
                    <c:if test="${fn:length(couriers) eq 0}">
                        <span class="color-red"> - список пуст!</span>
                        <br>
                        <a href="/admin/add_user" title="Добавить нового курьера">
                            <button class="btn" type="submit">Добавить нового курьера</button>
                        </a>
                    </c:if>
                </b>
            </div>
            <c:if test="${fn:length(couriers) gt 0}">
                <table class="table">
                    <tr>
                        <th >Имя</th>
                        <th >Должность</th>
                        <th >Телефон</th>
                        <th >Почта</th>
                        <th ></th>
                        <th ></th>
                    </tr>

                    <c:forEach items="${couriers}" var="employee">
                        <tr>
                            <td > ${employee.fullName} </td>
                            <td >${employee.position.name()}</td>
                            <td >${employee.phone}</td>
                            <td >${employee.email}</td>
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
            <table class="table">
                <tr>
                    <td>
                        <a href="" title="Добавить нового курьера">
                            <button class="btn" type="submit">Добавить нового курьера</button>
                        </a>
                        <c:if test="${fn:length(couriers) gt 0}">
                            <a href="" title="Удалить всех менеджеров">
                                <button class="btn btn-remove-all-employee" type="submit">Удалить всех курьеров</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
