package dao.imp;

import dao.BookDao;
import model.Book;
import utils.GenericStorage;

import java.util.List;

/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class BookDaoImp implements BookDao {

    final private static GenericStorage<Long, Book> bookGenericStorage = new GenericStorage<Long, Book>();

    @Override
    public boolean createBook(Book book) {
        return bookGenericStorage.put(book.getId(), book);
    }

    @Override
    public Book readBook(long id) {
        return bookGenericStorage.get(id);
    }

    @Override
    public Book getBookByTitle(String title) {
        for (Book book : bookGenericStorage.getAll()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> readAll() {
        return bookGenericStorage.getAll();
    }

    @Override
    public boolean updateBook(Book book) {
        if (readBook(book.getId()) != null) {
            Book tempUser = bookGenericStorage.get(book.getId());
            deleteBook(book.getId());
            if (!createBook(book)) {
                createBook(tempUser);
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBook(long id) {
        return bookGenericStorage.delete(id);
    }
}
