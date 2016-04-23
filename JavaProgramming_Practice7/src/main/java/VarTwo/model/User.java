package VarTwo.model;

import VarTwo.dao.AdressDao;
import VarTwo.dao.Dao;
import VarTwo.dao.MusicTypeDao;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private Adress adress;
    private Role role;
    private Set<MusicType> musicTypes = new HashSet<>();

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, int age, Role role) {
        setLogin(login);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adress getAdress() {
        Dao<Adress> adressDao = new AdressDao();
        return adressDao.getById(this.getId());
    }


    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<MusicType> getMusicTypes() {
//        Dao<MusicType> musicTypeDao = new MusicTypeDao();
//        musicTypeDao.getById()
        return musicTypes;
    }

    public void setMusicTypes(Set<MusicType> musicTypes) {
        this.musicTypes = musicTypes;
    }

    public boolean addMusicType(MusicType musicType) {
        return musicTypes.add(musicType);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
