package VarOne.dao;
import java.util.*;
/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public interface Dao<E> {
    public E create(E object);
    public List<E> getAll();
    public E getById(int id);
    public boolean update(E object);
    public boolean delete(E object);
}