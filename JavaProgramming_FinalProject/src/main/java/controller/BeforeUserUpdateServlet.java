package controller;

import dao.Dao;
import dao.impl.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/beforeUserUpdate")
public class BeforeUserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("beforeUserUpdate");

        HttpSession session = req.getSession();
        int userId = Integer.parseInt(req.getParameter("userId"));
        Dao<User> userDao = new UserDao();
        //Достаю из базы юзера по его Id переданного сюда из JSP
        User user = userDao.getById(userId);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/resources/pages/userUpdatePage.jsp").forward(req, resp);
        return;
    }
}