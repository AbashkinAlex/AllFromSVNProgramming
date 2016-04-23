package Task2;

import Task2.dao.Dao;
import Task2.dao.GroupDao;
import Task2.dao.StudentDao;
import Task2.model.MyGroup;
import Task2.model.Student;
import java.sql.SQLException;
/*
 * Task 2. Создать простое CRUD приложение
 *
 * ­ Использовать паттерн DAO
 */

/**
 * Created by Администратор on 09.03.2016.
 */
public class CRUD_Application {
    public static void main(String[] args) throws SQLException {
        Student student = new Student("Bob", "Marlee", "1980-01-31", 2);
        Dao<Student> studentDao = new StudentDao();
        System.out.println("~~~~~~~~~Students~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~CREATE~~~~~~~~~~~~~");

        studentDao.create(student);
        System.out.println(student);

        System.out.println("~~~~~~~~~~~READ~~~~~~~~~~~~~");
        System.out.println("GetAll");
        for (int i = 0; i < studentDao.getAll().size(); i++) {
            System.out.println(studentDao.getAll().get(i));
        }
        System.out.println("GetById");
        System.out.println(studentDao.getById(6));
        System.out.println("~~~~~~~~~~~UPDATE~~~~~~~~~~~~~");
        Student newStudent = new Student(7, "Филлип", "Киркоров", "1980-01-31", 2);
        System.out.println(studentDao.update(newStudent));
        System.out.println(studentDao.getById(7));
        System.out.println("~~~~~~~~~~~DELETE~~~~~~~~~~~~~");
        System.out.println(studentDao.delete(newStudent));
        System.out.println("getById(2) :" + studentDao.getById(2));
        System.out.println("~~~~~~~~~~~~Group~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~CREATE~~~~~~~~~~~~~");
        MyGroup myGroup= new MyGroup(69, "НТУ ХПИ");
        Dao<MyGroup> myGroupDao = new GroupDao();
        myGroupDao.create(myGroup);
        System.out.println(myGroup);
        System.out.println("~~~~~~~~~~~READ~~~~~~~~~~~~~");
        System.out.println("GetAll");
        for (int i = 0; i < myGroupDao.getAll().size(); i++) {
            System.out.println(myGroupDao.getAll().get(i));
        }
        System.out.println("GetById");
        System.out.println(myGroupDao.getById(3));
        System.out.println("~~~~~~~~~~~UPDATE~~~~~~~~~~~~~");
        MyGroup newMyGroup = new MyGroup(2,"ХАИ");
        System.out.println(myGroupDao.update(newMyGroup));
        System.out.println(myGroupDao.getById(2));
        System.out.println("~~~~~~~~~~~DELETE~~~~~~~~~~~~~");

        System.out.println(myGroupDao.delete(myGroupDao.getById(3)));
        System.out.println("getById(2) :" + myGroupDao.getById(3));

    }
}

