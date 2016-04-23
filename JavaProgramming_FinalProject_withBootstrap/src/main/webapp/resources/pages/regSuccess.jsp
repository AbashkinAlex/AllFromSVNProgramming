<%@ page import="model.User" %>
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
    <title>Вы зарегистрированы!</title>
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
    </style>
</head>
<body>
<br>

<h1>Регистрация прошла успешно!</h1>

<br>Привет, <b><%=((User)request.getAttribute("user")).getLogin()%> !
    <br>Теперь Вы можете зайти !
</b>
<form name="indexForm" method="POST" action="/index.jsp">
    <td align="left"><input type="submit"  class="btn btn-primary"  value="Зайти">
    </td>
</form>
</body>


</html>
