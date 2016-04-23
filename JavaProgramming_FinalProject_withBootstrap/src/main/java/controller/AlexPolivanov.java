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
@WebServlet(name = "/alex")
public class AlexPolivanov extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Dao<User> userDao = new UserDao();
//        Dao<Role> roleDao = new RoleDao();
        //Проверка что все поля заполнены

//            System.out.println("Одно из полей было не заполнено!");
//            resp.sendRedirect("/resources/pages/wrongInput.jsp");
//            return;

        RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/resources/pages/ALEXPOLIVANOV.jsp");
        Dispatcher.forward(req, resp);

    }


}
