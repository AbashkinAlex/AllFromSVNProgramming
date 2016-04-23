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

    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


    <style>
        body {
            background: #D5D6EC; /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
        }
        .colortext {
            background-color: #ffe; /* Цвет фона */
            color: #1D2BEC; /* Цвет текста */
        }
    </style>
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
            <td align="center"><input type="text" name="login" class="colortext" value="<%=user.getLogin()%>"></td>
        </tr>
        <tr>
            <td align="left">Пароль</td>
            <td align="center"><input type="text" name="password" class="colortext" value="<%=user.getPassword()%>"></td>
        </tr>
        <tr>
            <td align="left">Имя</td>
            <td align="center"><input type="text" name="firstName" class="colortext" value="<%=user.getFirstName()%>"></td>
        </tr>
        <tr>
            <td align="left">Фамилия</td>
            <td align="center"><input type="text" name="lastName" class="colortext" value="<%=user.getLastName()%>"></td>
        </tr>
        <tr>
            <td align="left">Возраст</td>
            <td align="center"><input type="text" name="age" class="colortext" value="<%=user.getAge()%>"></td>
            </td>
        </tr>
        <tr>
            <td align="left">Роль</td>

            <%--ЕСЛИ АДМИНА ВЫБРАЛИ--%>

            <%
                if (user.getRole().getId()==1){
            %>
            <td align="center">
                <select name="role" class="form-control">
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
                <select name="role" class="form-control">
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
                <select name="role" class="form-control">
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
            <td align="left"><input type="submit"  class="btn btn-success" value="Изменить данные"></td>
        </tr>

    </form>
    <form name="indexForm" method="POST" action="/resources/pages/adminPage.jsp">
        <td align="left"><input type="submit"  class="btn btn-primary" value="Назад">
        </td>
    </form>

</table>
</body>
</html>
