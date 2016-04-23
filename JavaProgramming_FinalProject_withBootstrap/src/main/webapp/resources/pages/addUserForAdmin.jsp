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

    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <style>
        body {
            /*D:\Oracle\JavaProgramming_FinalProject_withBootstrap\src\main\webapp\resources\images\bg.jpg*/
            background: #D5D6EC; /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
        }
        .colortext {
            background-color: #ffe; /* Цвет фона */
            color: #1D2BEC; /* Цвет текста */
        }
    </style>
</head>
<table>

    <tr>
        <td align="center" cellpadding="2">Форма для регистрации</td>
    </tr>
    <form name="regForm" method="POST" action="/addUserForAdmin">
        <tr>
            <td align="left">Логин</td>
            <td align="center"><input type="text" class="colortext"  name="login"></td>
        </tr>
        <tr>
            <td align="left">Пароль</td>
            <td align="center"><input type="password" class="colortext"  name="password"></td>
        </tr>
        <tr>
            <td align="left">Повторите пароль</td>
            <td align="center"><input type="password" class="colortext"  name="repeatPassword"></td>
        </tr>
        <tr>
            <td align="left">Имя</td>
            <td align="center"><input type="text" class="colortext"  name="firstName"></td>
        </tr>
        <tr>
            <td align="left">Фамилия</td>
            <td align="center"><input type="text" class="colortext"  name="lastName"></td>
        </tr>
        <tr>
            <td align="left">Возраст</td>
            <td align="center"><input type="number" class="colortext"  min="0" max="150" name="age">
            </td>
        </tr>
        <tr>
            <td align="left"><input type="submit" class="btn btn-success" value="Зарегистрировать"></td>
        </tr>
    </form>
    <form name="indexForm" method="POST" action="/resources/pages/adminPage.jsp">
        <td align="left"><input type="submit" class="btn btn-primary" value="Назад">
        </td>
    </form>

</table>
</html>
