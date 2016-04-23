package Task2.dao;
import java.util.List;
/**
 * Created by Администратор on 09.03.2016.
 */
public interface Dao<E> {
    public E create(E object);
    public List<E> getAll();
    public E getById(int id);
    public boolean update(E object);
    public boolean delete(E object);
}
