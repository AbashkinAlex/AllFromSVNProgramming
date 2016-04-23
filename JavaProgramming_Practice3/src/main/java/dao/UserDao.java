package dao;

import model.User;

import java.util.List;

/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public interface UserDao {

    boolean createUser(User user);
    User readUser(long id);
    List<User> readAll();
    boolean updateUser(User user);
    boolean deleteUser(long id);

}
