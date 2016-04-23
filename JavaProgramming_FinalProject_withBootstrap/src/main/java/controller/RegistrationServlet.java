package controller;

import dao.Dao;
import dao.impl.RoleDao;
import dao.impl.UserDao;
import model.Role;
import model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 28.03.2016.
 */
@WebServlet(name = "registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Dao<User> userDao = new UserDao();
        Dao<Role> roleDao = new RoleDao();
        //Проверяю что все поля заполнены
        if ((req.getParameter("login").equals("")) || (req.getParameter("password").equals("")) ||
                (req.getParameter("repeatPassword").equals("")) || (req.getParameter("firstName").equals("")) ||
                (req.getParameter("lastName").equals("")) || (req.getParameter("age").equals(""))) {
            System.out.println("Одно из полей было не заполнено!");
            resp.sendRedirect("/resources/pages/wrongInput.jsp");
            return;
        }
        String login = req.getParameter("login");
        for (User user : userDao.getAll()) {
            if (user.getLogin().equals(login)) {
                System.out.println("Юзер с таким логином уже есть в базе");
                resp.sendRedirect("/resources/pages/wrongLogin.jsp");
                return;
            }
        }
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        if (!password.equals(repeatPassword)) {
            System.out.println("Неправильно введены пароли");
            resp.sendRedirect("/resources/pages/wrongPassword.jsp");
            return;
        }
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        User user = new User();
        user.setLogin(login.toString());
        user.setPassword(password.toString());
        user.setFirstName(firstName.toString());
        user.setLastName(lastName.toString());
        user.setAge(Integer.parseInt(age.toString()));
        user.setRole(roleDao.getById(2));//создали с ролью User
        userDao.create(user);

        req.setAttribute(roleDao.getById(2).getRoleName(), user);
//        session.setAttribute(roleDao.getById(3).getRoleName(), user);//вошли под ролью Mandator!!!!
        RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/resources/pages/regSuccess.jsp");
        Dispatcher.forward(req, resp);

    }


}
