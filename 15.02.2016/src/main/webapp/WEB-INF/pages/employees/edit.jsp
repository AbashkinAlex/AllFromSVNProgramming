<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Переименовать работника</title>
</head>
<body>
<div class="block1">
<form:form method="post" action="/empSaveEdit">
    <table>
        <tr>
            <td><b>Имя:</b></td>
            <td><input type="text" class="colortext" name="firstName" value="${employee.firstName}"/></td>
            <td><b>Фамилия:</b></td>
            <td><input type="text" class="colortext" name="secondName" value="${employee.secondName}"/></td>
            <td><input type="hidden" name="empId" value="${employee.id}"/></td>
            <td><input type="hidden" name="depId" value="${employee.department.id}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="button" value="Переименовать"/>
            </td>
        </tr>
    </table>
</form:form>
</div>

</body>
</html>
