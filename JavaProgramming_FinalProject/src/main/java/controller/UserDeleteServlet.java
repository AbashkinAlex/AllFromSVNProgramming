package controller;

import dao.Dao;
import dao.impl.RoleDao;
import dao.impl.UserDao;
import model.Role;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/userDelete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao<User> userDao = new UserDao();
        System.out.println("DELETE!!!!!!!!!!!!!!!!!!!!!!!!");
        int userId = Integer.parseInt(req.getParameter("userId"));
        System.out.println("userId==>" + userId);
        User user = userDao.getById(userId);
        System.out.println("userDeleted==>  " + user);
        //Админа я не хочу чтобы удаляли, потому что есть верояность что Админ удалит сам себя
        if (user.getRole().getRoleName().equals("admin")){
            resp.sendRedirect("/resources/pages/notDeleteAdmin.jsp");
            return;
        }
        userDao.delete(user);
        getServletContext().getRequestDispatcher("/resources/pages/adminPage.jsp").forward(req, resp);
        return;
    }
}