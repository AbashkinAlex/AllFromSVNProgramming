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

</head>
<body>

<br>Привет,<b>
    <td><%=((User) session.getAttribute("admin")).getLogin()%>
    </td>
    !
</b>

<table border="1" cellspacing="0" cellpadding="12">
    <tr>
        <td align="center" width="5%" cellspacing="0" ><b>ID</b></td>
        <td align="center" width="15%" cellspacing="0"><b>Login</b></td>
        <td align="center" width="15%" cellspacing="0"><b>Password</b></td>
        <td align="center" width="15%" cellspacing="0"><b>First name</b></td>
        <td align="center" width="15%" cellspacing="0"><b>Last name</b></td>
        <td align="center" width="15%" cellspacing="0"><b>Age</b></td>
        <td align="center" width="15%" cellspacing="0"><b>Role</b></td>
        <td align="center" width="30%" cellspacing="0" colspan="2" align="center"><b>Action</b></td>
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
                    <input type="submit" class="button" value="Изменить"/>
                </form>
            </table>
        </td>
        <td>
            <table>
                <form name="userId" method="POST" action="/userDelete">
                    <input type="hidden" name="userId" value="<%=user.getId()%>"/>
                    <input type="submit" class="button" value="Удалить"/>
                </form>
            </table>
        </td>
    </tr>
    <%--</c:forEach>--%>
    <%}%>
</table>


<br>
<form name="indexForm" method="POST" action="/resources/pages/addUserForAdmin.jsp">
    <td align="left"><input type="submit" value="Добавить юзера">
    </td>
</form>
<br>
<form name="indexForm" method="POST" action="/logout">
    <td align="left"><input type="submit" value="Покинуть сессию">
    </td>
</form>

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
