package services;

import dao.BookDao;
import dao.imp.BookDaoImp;
import model.Book;

import java.util.List;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class BookServices {
    private static long id = 1000;

    public boolean addBookInLibrary(String author, String title) {
        BookDao bookDao = new BookDaoImp();
        return bookDao.createBook(new Book(id++, author, title));
    }

    public boolean deleteUser(long id) {
        BookDao bookDao = new BookDaoImp();
        return bookDao.deleteBook(id);
    }

    public List<Book> readAllBook() {
        BookDao bookDao = new BookDaoImp();
        return bookDao.readAll();
    }

    public Book getBookById(long id){
        BookDao bookDao = new BookDaoImp();
        return bookDao.readBook(id);
    }

    public Book getBookByTitle(String title){
        BookDao bookDao = new BookDaoImp();
        return bookDao.getBookByTitle(title);
    }

    public boolean returnBookInLibrary(long bookId,String author, String title) {
        BookDao bookDao = new BookDaoImp();
        return bookDao.createBook(new Book(bookId, author, title));
    }

}
