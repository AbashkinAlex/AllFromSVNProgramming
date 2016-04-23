package dao.imp;

import dao.UserDao;
import model.User;
import utils.GenericStorage;

import java.util.List;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class UserDaoImpl implements UserDao {
    final private static GenericStorage<Long, User> users = new GenericStorage<Long, User>();

    @Override
    public boolean createUser(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public User readUser(long id) {
        return users.get(id);
    }

    @Override
    public List<User> readAll() {
        return users.getAll();
    }

    @Override
    public boolean updateUser(User user) {
        if(readUser(user.getId()) != null){
            User tempUser = users.get(user.getId());
            deleteUser(user.getId());
            if(!createUser(user)){
                createUser(tempUser) ;
            }else{
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(long id) {
        return users.delete(id);
    }
}
