package VarTwo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexandr Abashkin on 3/22/2016.
 */
public class MusicType {
    private int id;
    private String typeName;
    Set<User> users  = new HashSet<>();;

    public MusicType() {
    }

    public MusicType(String typeName) {
        setTypeName(typeName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean addSet(User user){
        return users.add(user);
    }
//    public int generateId(){
//        int myId = (int)++this.id;
//        setId(myId);
//        return myId;
//    }
    @Override
    public String toString() {
        return "MusicType{" +
                "typeName='" + typeName + '\'' +
                ", id=" + id +
                '}';
    }
}
