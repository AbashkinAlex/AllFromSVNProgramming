<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить учреждение</title>
</head>
<body>

<div class="block1">
    <form:form method="post" action="/depSave">
        <table>
            <tr>
                <td><b>Имя:</b></td>
                <td><input type="text" class="colortext" name="name"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" class="button" value="Добавить"/>
                    <%--<input type="submit"/>--%>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
