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

@WebServlet(name = "/afterUserUpdate")
public class AfterUserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("afterUserUpdate");
        HttpSession session = req.getSession();
        Dao<User> userDao = new UserDao();
        Dao<Role> roleDao = new RoleDao();
        int userId = Integer.parseInt(req.getParameter("userId"));
        String role = req.getParameter("role");
        //Проверяю что все поля заполнены
        if ((req.getParameter("login").equals("")) || (req.getParameter("password").equals("")) ||
                (req.getParameter("firstName").equals("")) || (req.getParameter("lastName").equals("")) ||
                (req.getParameter("age").equals(""))) {
            System.out.println("Одно из полей было не заполнено!");
            resp.sendRedirect("/resources/pages/wrongInput.jsp");
            return;
        }
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        User user = new User();
        user.setId(userId);
        user.setLogin(login.toString());
        user.setPassword(password.toString());
        user.setFirstName(firstName.toString());
        user.setLastName(lastName.toString());
        user.setAge(Integer.parseInt(age.toString()));
        //Считываю ответ из раскрывающегося списка
        if (role.equals(roleDao.getById(1).getRoleName())){
            user.setRole(roleDao.getById(1));//создали с ролью Admin
        }
        if (role.equals(roleDao.getById(2).getRoleName())){
            user.setRole(roleDao.getById(2));//создали с ролью User
        }
        if (role.equals(roleDao.getById(3).getRoleName())){
            user.setRole(roleDao.getById(3));//создали с ролью Mandator
        }
        System.out.println(user);
        userDao.update(user);


//        session.setAttribute(roleDao.getById(3).getRoleName(), user);//!!!!
        RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/resources/pages/adminPage.jsp");
        Dispatcher.forward(req, resp);
    }
}