<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить работника</title>
</head>
<body>
<div class="block1">
    <form:form method="post" action="/empSave">
        <table>
            <tr>
                <td><b>Имя:</b></td>
                <td><input type="text" class="colortext" name="firstName"/></td>
                <td><b>Фамилия:</b></td>
                <td><input type="text" class="colortext" name="secondName"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" class="button" value="Добавить работника"/>
                    <input type="hidden" name="id" value="${department.id}"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
