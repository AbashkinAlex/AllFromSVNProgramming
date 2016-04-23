<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 28.03.2016
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<table>

    <tr>
        <td align="center" cellpadding="2">Форма для регистрации</td>
    </tr>
    <form name="regForm" method="POST" action="/addUserForAdmin">
        <tr>
            <td align="left">Логин</td>
            <td align="center"><input type="text" name="login"></td>
        </tr>
        <tr>
            <td align="left">Пароль</td>
            <td align="center"><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="left">Повторите пароль</td>
            <td align="center"><input type="password" name="repeatPassword"></td>
        </tr>
        <tr>
            <td align="left">Имя</td>
            <td align="center"><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td align="left">Фамилия</td>
            <td align="center"><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td align="left">Возраст</td>
            <td align="center"><input type="number" min="0" max="150" name="age">
            </td>
        </tr>
        <tr>
            <td align="left"><input type="submit" value="Зарегистрировать"></td>
        </tr>
    </form>
    <form name="indexForm" method="POST" action="/resources/pages/adminPage.jsp">
        <td align="left"><input type="submit" value="Назад">
        </td>
    </form>

</table>
</html>
