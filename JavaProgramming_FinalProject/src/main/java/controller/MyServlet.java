package controller;

import dao.Dao;
import dao.impl.RoleDao;
import dao.impl.UserDao;
import model.Role;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dmitr on 26.12.2015.
 */

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Dao<Role> roleDao = new RoleDao();
        Dao<User> userDao = new UserDao();
        //Проверяю кто с какой ролью зашел и отправляю по нужным страничкам
        if (!(session.getAttribute("admin") == null)) {
            User admin = (User) session.getAttribute(roleDao.getById(1).getRoleName());
//            request.setAttribute("userList",userDao.getAll());//не работает
            request.setAttribute("admin",admin);
            getServletContext().getRequestDispatcher("/resources/pages/adminPage.jsp").forward(request, response);
            return;
        }
        if (!(session.getAttribute("user") == null)) {
            User user = (User) session.getAttribute(roleDao.getById(2).getRoleName());
            request.setAttribute("user",user);
            RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/resources/pages/userPage.jsp");
            Dispatcher.forward(request, response);
            return;
        }
        if (!(session.getAttribute("mandator") == null)) {
            User mandator = (User) session.getAttribute(roleDao.getById(3).getRoleName());
            request.setAttribute("mandator",mandator);
            getServletContext().getRequestDispatcher("/resources/pages/mandatorPage.jsp").forward(request, response);
            return;
        }
    }
}
