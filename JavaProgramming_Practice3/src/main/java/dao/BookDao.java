package dao;

import model.Book;

import java.util.List;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public interface BookDao {
    boolean createBook(Book book);
    Book readBook(long id);
    List<Book> readAll();
    Book getBookByTitle(String title);
    boolean updateBook(Book book);
    boolean deleteBook(long id);
}
