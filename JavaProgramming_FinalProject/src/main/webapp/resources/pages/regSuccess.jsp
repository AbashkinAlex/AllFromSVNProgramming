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
</head>
<body>
<br>

<h1>Регистрация прошла успешно!</h1>

<br>Привет, <b><%=((User)request.getAttribute("user")).getLogin()%> !
    <br>Теперь Вы можете зайти !
</b>
<form name="indexForm" method="POST" action="/index.jsp">
    <td align="left"><input type="submit" value="Зайти">
    </td>
</form>
</body>


</html>
