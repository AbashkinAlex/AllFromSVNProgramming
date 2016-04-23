package model;

import java.util.Date;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class Report {

    private long id;
    private Book book;
    private User user;
    private Date rent;
    private Date returns;

    public Report(long id, Book book, User user, Date rent) {
        setId(id);
        setBook(book);
        setUser(user);
        setRent(rent);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRent() {
        return rent;
    }

    public void setRent(Date rent) {
        this.rent = rent;
    }

    public Date getReturns() {
        return returns;
    }

    public void setReturns(Date returns) {
        this.returns = returns;
    }


    @Override
    public String toString() {
        return "Report{" + "\n" +
                "id=" + id + "\n" +
                "book=" + book + "\n" +
                "user=" + user + "\n" +
                "rent=" + rent + "\n" +
                "returns=" + returns +
                '}';
    }
}
