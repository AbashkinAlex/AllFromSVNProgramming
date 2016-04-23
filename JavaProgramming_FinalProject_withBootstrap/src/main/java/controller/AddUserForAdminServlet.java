package controller;

import dao.Dao;
import dao.impl.RoleDao;
import dao.impl.UserDao;
import model.Role;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Abashkin Aleksandr on 28.03.2016.
 */
@WebServlet(name = "addUserForAdmin")
public class AddUserForAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Dao<User> userDao = new UserDao();
        Dao<Role> roleDao = new RoleDao();
        //Проверка что все поля заполнены
        if ((req.getParameter("login").equals("")) || (req.getParameter("password").equals("")) ||
                (req.getParameter("repeatPassword").equals("")) || (req.getParameter("firstName").equals("")) ||
                (req.getParameter("lastName").equals("")) || (req.getParameter("age").equals(""))) {
            System.out.println("Одно из полей было не заполнено!");
            resp.sendRedirect("/resources/pages/wrongInput.jsp");
            return;
        }
        String login = req.getParameter("login");
        //Проверка что такого логина нет в базе
        for (User user : userDao.getAll()) {
            if (user.getLogin().equals(login)) {
                System.out.println("Юзер с таким логином уже есть в базе");
                resp.sendRedirect("/resources/pages/wrongLogin.jsp");
                return;
            }
        }
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        //Проверка что пароли одинаковые
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
        user.setRole(roleDao.getById(3));//создали с ролью Mandator(ПО умолчанию создаю мандатора)
        userDao.create(user);


//        session.setAttribute(roleDao.getById(3).getRoleName(), user);//вошли под ролью Mandator!!!!
        RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/resources/pages/adminPage.jsp");
        Dispatcher.forward(req, resp);

    }


}
