<!DOCTYPE html>
<html>
<head>
    <title>Please login</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <style>
        body {
            /*D:\Oracle\JavaProgramming_FinalProject_withBootstrap\src\main\webapp\resources\images\bg.jpg*/
            background: #c7b39b url(resources/images/bg.jpg); /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
        }
        .colortext {
            background-color: #ffe; /* Цвет фона */
            color: #1D2BEC; /* Цвет текста */
        }
    </style>
</head>
<body>
<p>Please login</p>

<table>
    <form name="loginForm" method="post" action="/login">


        <tr>
            <td align="center">Login:</td>
            <td align="center"><input type="text" class="colortext" name="login"/></td>

        </tr>
        <tr>
            <td align="center">Password:</td>
            <td align="center"><input type="password" class="colortext" name="password"/></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" class="btn btn-primary btn-md" value="Войти"/></td>
    </form>
    <td align="center">
        <form name="registerForm" method="post" action="resources/pages/registration.jsp">
            <input type="submit" class="btn btn-primary btn-md" value="Зарегистрироваться"/>
        </form>
    </td>
    </tr>
</table>
</body>
</html>
