<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Переименовать</title>
</head>
<body>

<body>

<div class="block1">
    <form:form method="post" action="/depSaveEdit">
        <table>
            <tr>
                <td>Имя:</td>
                <td><input type="text" class="colortext" name="name" value="${addedDepartment.name}"/></td>
                <td>Фамилия:</td>
                <td><input type="hidden" class="colortext" name="id" value="${addedDepartment.id}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" class="button" value="Переименовать"/>
                    <%--<input type="submit" value="Переименовать"/>--%>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
