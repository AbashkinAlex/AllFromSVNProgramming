<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>Список работников</title>
</head>
<body>
<div class="block1">

    <table border="1" cellspacing="0" cellpadding="12">
        <table border="1" cellspacing="0" cellpadding="12">
            <caption><span class="letter"><b>Список работников</b></span></caption>

            <tr>
            <tr>
                <td align="center" width="5%" cellspacing="0" cellpadding="4"><b>ID</b></td>
                <td align="center" width="30%" cellspacing="0" cellpadding="4"><b>Фамилия</b></td>
                <td align="center" width="30%" cellspacing="0" cellpadding="4"><b>Имя</b></td>
                <td align="center" colspan="3"><b>Кнопки </b></td>
            </tr>
            <c:forEach var="employee" items="${department.employees}">
            <tr>
                <td align="center"><b>${employee.id}</b></td>
                <td align="left"><b>${employee.secondName}</b></td>
                <td align="left"><b>${employee.firstName}</b></td>
                <td>
                    <form:form method="post" action="/empEdit">
                        <table>
                            <tr>
                                    <%--<td>Name:</td>--%>
                                    <%--<td><input type="text" name="name" value="${addedempartment.name}"/></td>--%>
                                <td><input type="hidden" name="id" value="${employee.id}"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" class="button" value="Переименовать"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
                <td>
                    <form:form method="post" action="/empDeletePost">
                        <table>
                            <tr>

                                <td><input type="hidden" name="empId" value="${employee.id}"/></td>
                                <td><input type="hidden" name="depId" value="${employee.department.id}"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" class="button" value="Удалить"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>

                </td>

                </c:forEach>
            </tr>

            <%--<td colspan="5">--%>
            <%--<a href="/empAdd">Add new one </a>--%>
            <%--</td>--%>

        </table>
        <form:form method="post" action="/empAdd">
            <table>

                <tr>
                    <td colspan="2">
                        <input type="submit" class="button" value="Добавить еще одного работника"/>
                        <input type="hidden" name="id" value="${department.id}"/>
                    </td>
                </tr>
            </table>
        </form:form>

        <form:form method="get" action="/dep">
            <table>

                <tr>
                    <td colspan="2">
                        <input type="submit" class="button" value="Вернуться на список учреждений"/>

                    </td>
                </tr>
            </table>
        </form:form>
    </table>
</div>
</body>
</html>