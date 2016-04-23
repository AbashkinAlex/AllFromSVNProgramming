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

<%--<br>Привет,<b>--%>
<%--<td><%=((User) session.getAttribute("admin")).getLogin()%>--%>
<%--</td>--%>
<%--!--%>
</b>

<div class="h3" align="center">Привет,
    <td><%=((User) session.getAttribute("admin")).getLogin()%>
    </td>
    !
    <div class="table">
        <table class="table table-hover">
            <%--<div class="row">--%>
            <%--<div class="col-sm-4">ID</div>--%>
            <%--<div class="col-sm-4">Login</div>--%>
            <%--<div class="col-sm-4">Password</div>--%>
            <%--<div class="col-sm-4">First name</div>--%>
            <%--<div class="col-sm-4">Last name</div>--%>
            <%--<div class="col-sm-4">Age</div>--%>
            <%--<div class="col-sm-4">Role</div>--%>
            <%--<div class="col-sm-4">Action</div>--%>
            <%--</div>--%>
            <tr>
                <td width="5%" cellspacing="0"><b>ID</b></td>
                <td width="15%" cellspacing="0"><b>Login</b></td>
                <td width="15%" cellspacing="0"><b>Password</b></td>
                <td width="15%" cellspacing="0"><b>First name</b></td>
                <td width="15%" cellspacing="0"><b>Last name</b></td>
                <td width="15%" cellspacing="0"><b>Age</b></td>
                <td width="15%" cellspacing="0"><b>Role</b></td>
                <td width="30%" cellspacing="0" colspan="2" align="center"><b>Action</b></td>
            </tr>

            <%--//я знаю что здесь выполнять логику по работе с БД не хорошо, но у меня не получилось передать в JSP объект листа юзеров.--%>

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
                <td>
                    <table>
                        <form name="userId" method="POST" action="/beforeUserUpdate">
                            <input type="hidden" name="userId" value="<%=user.getId()%>"/>
                            <button type="submit" class="btn btn-warning">Изменить</button>
                            <%--<input type="submit" class="button" value="Изменить"/>--%>
                        </form>
                    </table>
                </td>
                <td>
                    <table>
                        <form name="userId" method="POST" action="/userDelete">
                            <input type="hidden" name="userId" value="<%=user.getId()%>"/>
                            <button type="submit" class="btn btn-danger">Удалить</button>
                            <%--<input type="submit" class="button" value="Удалить"/>--%>
                        </form>
                    </table>
                </td>
            </tr>
            <%--</c:forEach>--%>
            <%}%>
        </table>
    </div>

    <div class="table">

        <div class="table" align="left">
            <tr>
                <td>
                    <form name="indexForm" method="POST" action="/resources/pages/addUserForAdmin.jsp">
                        <button type="submit" class="btn btn-success">Добавить юзера</button>
                        <%--<td align="left"><input type="submit" value="Добавить юзера">--%>
                    </form>
                </td>
                <td align="left">
                    <form name="indexForm" method="POST" action="/logout">
                        <button type="submit" class="btn btn-primary">Покинуть сессию</button>
                        <%--<td align="left"><input type="submit" value="Покинуть сессию">--%>
                    </form>
                </td>
            </tr>
        </div>
    </div>


    <%--НЕ РАБОТАЮЩИЙ ФОР ИЧ --%>
    <%--<table>--%>
    <%--<c:forEach var="user" items="${requestScope.list}">--%>
    <%--<tr>--%>
    <%--<td><c:out value="${user.id} " /></td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</table>--%>

</body>


</html>
