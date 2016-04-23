<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>Список учреждений</title>
</head>

<body>

<div class="block1">
    <table border="1" cellspacing="0" cellpadding="12">
        <table border="1" cellspacing="0" cellpadding="12">
            <caption><b>Таблица учреждений</b></caption>


            <tr>
                <td align="center" width="5%" cellspacing="0" cellpadding="4"><b>ID</b></td>
                <td align="center" width="30%" cellspacing="0" cellpadding="4"><b>Имя</b></td>
                <td align="center" colspan="3"><b>Кнопки </b></td>
            </tr>
            <c:forEach var="department" items="${departments}">
            <tr>
                <td align="center"><b>${department.id}</b></td>
                <td align="left"><b>${department.name}</b></td>

                <td>
                    <form:form method="post" action="/depEdit">
                        <table>
                            <tr>
                                    <%--<td>Name:</td>--%>
                                    <%--<td><input type="text" name="name" value="${addedDepartment.name}"/></td>--%>
                                <td><input type="hidden" name="id" value="${department.id}"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">

                                    <%--<p><input type="image" src="resources/assets/img/button/button-yellow.png" alt="Переименовать"></p>--%>

                                    <%--<input type="submit" class="b1" value="Переименовать"/>--%>
                                    <input type="submit" class="button" value="Переименовать"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
                <td>
                    <form:form method="post" action="/depDeletePost">
                        <table>
                            <tr>
                                    <%--<td>Name:</td>--%>
                                    <%--<td><input type="text" name="name" value="${addedDepartment.name}"/></td>--%>
                                <td><input type="hidden" name="id" value="${department.id}"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" class="button" value="Удалить"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>

                <td>

                    <form:form method="post" action="/empDep">
                        <table>
                            <tr>
                                <td><input type="hidden" name="id" value="${department.id}"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" class="button" value="Посмотреть список работников"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>

                </td>


                </c:forEach>
            </tr>

            <tr>
        </table>
        <form:form method="post" action="/depAdd">
            <table>

                <tr>
                    <td colspan="2">
                        <input type="submit" class="button"  value="Добавить еще один"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </table>
</div>

</body>
</html>