import model.Book;
import model.Report;
import model.User;
import services.BookServices;
import services.ReportServices;
import services.UserServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class App {
    public static void main(String[] args) throws ParseException {
        String date = "JANUARY 4 2020";
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date currentTime = format.parse(date);
        UserServices userService = new UserServices();
        BookServices bookServices = new BookServices();
        ReportServices reportServices = new ReportServices();

        System.out.println("~~~~~~~~~~~~~~~~~~Добавить пользователя~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(userService.addUser("Саша", "Мой логин", "Мой пароль", currentTime));
        System.out.println(userService.addUser("Саша", "Мой логин", "Мой пароль", currentTime));
        System.out.println(userService.addUser("Саша", "Мой логин", "Мой пароль", currentTime));
        System.out.println(userService.addUser("Саша", "Мой логин", "Мой пароль", currentTime));
        System.out.println(userService.addUser("Саша", "Мой логин", "Мой пароль", currentTime));
        for (User user : userService.readAllUser()) {
            System.out.println(user);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~Удалить пользователя~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(userService.deleteUser(4));

        for (User user : userService.readAllUser()) {
            System.out.println(user);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~Добавить книгу~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        bookServices.addBookInLibrary("Лев Толстой", "111");
        bookServices.addBookInLibrary("Лев Толстой", "222");
        bookServices.addBookInLibrary("Лев Толстой", "333");
        bookServices.addBookInLibrary("Лев Толстой", "444");
        bookServices.addBookInLibrary("Лев Толстой", "555");
        for (Book book : bookServices.readAllBook()) {
            System.out.println(book);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~Удалить книгу~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        bookServices.deleteUser(1001);
        for (Book book : bookServices.readAllBook()) {
            System.out.println(book);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~Найти книгу~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(bookServices.getBookById(1003));
        System.out.println(bookServices.getBookByTitle("555"));

        System.out.println("~~~~~~~~~~~~~~~~~~Взять книгу~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Перечень книг в библиотеке до");
        for (Book book : bookServices.readAllBook()) {
            System.out.println(book);
        }

        System.out.println(userService.takeBook("111", userService.readUser(1),currentTime));
        for (User user : userService.readAllUser()) {
            System.out.println(user);
        }
        System.out.println(userService.takeBook("333", userService.readUser(1),currentTime));
        for (User user : userService.readAllUser()) {
            System.out.println(user);
        }

        System.out.println("Перечень книг в библиотеке после");
        for (Book book : bookServices.readAllBook()) {
            System.out.println(book);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~Вернуть книгу~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Перечень книг в библиотеке до");
        for (Book book : bookServices.readAllBook()) {
            System.out.println(book);
        }

        System.out.println(userService.returnBook("111", userService.readUser(1),currentTime));

        System.out.println("Перечень книг в библиотеке после");
        for (Book book : bookServices.readAllBook()) {
            System.out.println(book);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~История по книге~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Report report : reportServices.getHistoryBook("111")) {
            System.out.println(report);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~История по пользователю~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Report report : reportServices.getHistoryUser(userService.readUser(1))) {
            System.out.println(report);
        }

    }
}
