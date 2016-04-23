package Item1; /**
 * Created by Abashkin Aleksandr on 25.01.2016.
 */

/**
 * 1. Необходимо создать класс Item1.Book с полями
 title - строковое
 author - строковое
 year - целочисленое
 */
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    @Override
    public String toString() {
        return "Item1.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
