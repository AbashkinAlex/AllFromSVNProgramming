package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class User {
    private long id;
    private String name;
    private String login;
    private String password;
    private Date birthday;
    private ArrayList<Book> books = new ArrayList<Book>();
//    private ArrayList<Long> booksIdInLibrary = new ArrayList<Long>();


    public User(long id, String name, String login, String password, Date birthday) {
        setId(id);
        setName(name);
        setLogin(login);
        setPassword(password);
        setBirthday(birthday);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean addBooksInList(Book book) {
        return books.add(book);
    }

    public boolean removeBookInList(Book book) {
        return books.remove(book);
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", books=" + books +
                '}';
    }
}
