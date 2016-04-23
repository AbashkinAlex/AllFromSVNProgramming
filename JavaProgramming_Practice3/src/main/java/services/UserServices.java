package services;

import dao.BookDao;
import dao.ReportDao;
import dao.UserDao;
import dao.imp.BookDaoImp;
import dao.imp.ReportDaoImpl;
import dao.imp.UserDaoImpl;
import model.Book;
import model.Report;
import model.User;

import java.util.Date;
import java.util.List;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class UserServices {
    private static long id = 1;

    public boolean addUser(String name, String login, String password, Date birthday) {
        UserDao userDao = new UserDaoImpl();
        return userDao.createUser(new User(id++, name, login, password, birthday));
    }

    public boolean deleteUser(long id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.deleteUser(id);
    }

    public User readUser(long id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.readUser(id);
    }

    public List<User> readAllUser() {
        UserDao userDao = new UserDaoImpl();
        return userDao.readAll();
    }

    public boolean takeBook(String title, User user, Date rentDate) {
        BookDao bookDao = new BookDaoImp();
        ReportServices reportServices = new ReportServices();
        reportServices.addReport(bookDao.getBookByTitle(title), user, rentDate);
        user.addBooksInList(bookDao.getBookByTitle(title));
        return bookDao.deleteBook(bookDao.getBookByTitle(title).getId());
    }

    public boolean returnBook(String title, User user, Date returnsDate) {
        BookDao bookDao = new BookDaoImp();
        ReportDao reportDao = new ReportDaoImpl();
        for (Report report : reportDao.readAll()) {
            if (report.getBook().getTitle().equals(title)){
                report.setReturns(returnsDate);
            }
        }
        BookServices bookServices = new BookServices();

        for (Book userBook : user.getBooks()) {
            if (userBook.getTitle().equals(title)) {
                long bookId = userBook.getId();
                String bookAuthor = userBook.getAuthor();
                String bookTitle = userBook.getTitle();
                user.removeBookInList(bookDao.getBookByTitle(title));
                return bookServices.returnBookInLibrary(bookId, bookAuthor, bookTitle);
            }
        }
        return false;
    }
}
