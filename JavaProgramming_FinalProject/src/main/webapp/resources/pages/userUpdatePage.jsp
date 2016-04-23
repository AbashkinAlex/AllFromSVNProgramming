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
    <title>Страничка </title>
</head>
<body>


<%
    User user = (User) request.getAttribute("user");
%>

<table>

    <tr>
        <td align="center" cellpadding="2">Страничка по изменению данных пользователя
            <b><%=((User) request.getAttribute("user")).getLogin()%> ! </b>
        </td>
    </tr>
    <form name="regForm" method="POST" action="/afterUserUpdate">
        <tr>
            <td align="left">Логин</td>
            <td align="center"><input type="text" name="login" value="<%=user.getLogin()%>"></td>
        </tr>
        <tr>
            <td align="left">Пароль</td>
            <td align="center"><input type="text" name="password" value="<%=user.getPassword()%>"></td>
        </tr>
        <tr>
            <td align="left">Имя</td>
            <td align="center"><input type="text" name="firstName" value="<%=user.getFirstName()%>"></td>
        </tr>
        <tr>
            <td align="left">Фамилия</td>
            <td align="center"><input type="text" name="lastName" value="<%=user.getLastName()%>"></td>
        </tr>
        <tr>
            <td align="left">Возраст</td>
            <td align="center"><input type="text" name="age" value="<%=user.getAge()%>"></td>
            </td>
        </tr>
        <tr>
            <td align="left">Роль</td>

            <%--ЕСЛИ АДМИНА ВЫБРАЛИ--%>

            <%
                if (user.getRole().getId()==1){
            %>
            <td align="center">
                <select name="role">
                    <option selected value="admin">Admin</option>
                </select>
            </td>
            <%
                }
            %>
            <%--ЕСЛИ ЮЗЕРА ВЫБРАЛИ--%>

            <%
                if (user.getRole().getId()==2){
            %>
            <td align="center">
                <select name="role">
                    <option value="admin">Admin</option>
                    <option selected value="user">User</option>
                    <option value="mandator">Mandator</option>
                </select>
            </td>
            <%
                }
            %>
            <%--ЕСЛИ МАНДАТОРА ВЫБРАЛИ--%>

            <%
                if (user.getRole().getId()==3){
            %>
            <td align="center">
                <select name="role">
                    <option value="admin">Admin</option>
                    <option value="user">User</option>
                    <option selected value="mandator">Mandator</option>
                </select>
            </td>
            <%
                }
            %>
        </tr>


        <tr>
            <input type="hidden" name="userId" value="<%=user.getId()%>"/>
            <td align="left"><input type="submit" value="Изменить данные"></td>
        </tr>

    </form>
    <form name="indexForm" method="POST" action="/resources/pages/adminPage.jsp">
        <td align="left"><input type="submit" value="Назад">
        </td>
    </form>

</table>
</body>
</html>
