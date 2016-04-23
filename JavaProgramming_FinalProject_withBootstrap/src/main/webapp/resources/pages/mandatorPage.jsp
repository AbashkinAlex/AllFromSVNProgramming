<%@ page import="model.User" %>
<%@ page import="java.util.*" %>
<%@ page import="controller.*" %>
<%@ page import="dao.impl.UserDao" %>
<%@ page import="dao.Dao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<div class="h3" align="center">

    <br>Привет,<b>
    <td><%=((User) session.getAttribute("mandator")).getLogin()%>
    </td>
    !
</b>

    <div class="table">
        <table class="table table-hover">
            <tr>
                <td width="5%" cellspacing="0" cellpadding="4"><b>ID</b></td>
                <td width="15%" cellspacing="0" cellpadding="4"><b>Login</b></td>
                <td width="15%" cellspacing="0" cellpadding="4"><b>Password</b></td>
                <td width="15%" cellspacing="0" cellpadding="4"><b>First name</b></td>
                <td width="15%" cellspacing="0" cellpadding="4"><b>Last name</b></td>
                <td width="15%" cellspacing="0" cellpadding="4"><b>Age</b></td>
                <td width="15%" cellspacing="0" cellpadding="4"><b>Role</b></td>
            </tr>
            <%

                Dao<User> userDao = new UserDao();
                List<User> userList = userDao.getAll();
                for (User user : userList) {


            %>


            <tr>
                <td><%=user.getId()%>
                </td>
                <td><%=user.getLogin()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <td><%=user.getFirstName()%>
                </td>
                <td><%=user.getLastName()%>
                </td>
                <td><%=user.getAge()%>
                </td>
                <td><%=userDao.getById(user.getId()).getRole().getRoleName()%>
                </td>
            </tr>
            <%--</c:forEach>--%>
            <%}%>
        </table>
    </div>

    <br>

    <form name="indexForm" method="POST" action="/logout">
        <td align="left"><input type="submit" class="btn btn-primary" value="Покинуть сессию">
        </td>
    </form>

</body>


</html>
