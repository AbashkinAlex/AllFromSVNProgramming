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
import java.util.List;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String psw = req.getParameter("password");
        List<User> users = new UserDao().getAll();
        Dao<User> userDao = new UserDao();
        //Проверяю что такой юзер есть в базе
        for (User user : users) {
            if (login.equals(user.getLogin()) && psw.equals(user.getPassword())) {
                session.setAttribute(userDao.getById(user.getId()).getRole().getRoleName(), user);
                resp.sendRedirect("/myservlet");
                return;
            }
        }
        req.getRequestDispatcher("/resources/pages/notAuth.jsp").forward(req, resp);
    }
}