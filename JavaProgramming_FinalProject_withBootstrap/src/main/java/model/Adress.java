package model;

import dao.Dao;
import dao.impl.UserDao;

/**
 * Created by Alexandr Abashkin on 3/22/2016.
 */
public class Adress {
    private int id;
    private String country;
    private String street;
    private int zipCode;
    private User user;

    public Adress() {
    }

    public Adress(String country, String street, int zipCode, User user) {
        setCountry(country);
        setStreet(street);
        setZipCode(zipCode);
        setUser(user);
        setId(user.getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        Dao<User> userDao = new UserDao();
        return userDao.getById(this.getId());
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
