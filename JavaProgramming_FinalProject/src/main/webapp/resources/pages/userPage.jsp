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
    <title>Вы зашли!</title>
</head>
<body>
<br>

<h1>Вы вошли!</h1>

<br>Привет,<b>
    <td><%=((User)session.getAttribute("user")).getLogin()%></td> !
</b></td>
<form name="indexForm" method="POST" action="/logout">
    <td align="left"><input type="submit" value="Покинуть сессию">
    </td>
</form>

</body>


</html>
