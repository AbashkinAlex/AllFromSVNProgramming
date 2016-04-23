<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Please login</title>
</head>
<body>
<p>Please login</p>


<table>
    <form name="loginForm" method="post" action="/login">


        <tr>
            <td align="center">Login:</td>
            <td align="center"><input type="text" name="login"/></td>

        </tr>
        <tr>
            <td align="center">Password:</td>
            <td align="center"><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" class="button" value="Войти"/></td>
    </form>
    <td align="center">
        <form name="registerForm" method="post" action="resources/pages/registration.jsp">
            <input type="submit" class="button" value="Зарегистрироваться"/>
        </form>
    </td>
    </tr>
</table>
</body>
</html>
