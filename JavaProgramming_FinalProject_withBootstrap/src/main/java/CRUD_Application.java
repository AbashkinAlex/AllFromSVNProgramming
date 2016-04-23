import dao.Dao;
import dao.impl.AdressDao;
import dao.impl.MusicTypeDao;
import dao.impl.RoleDao;
import dao.impl.UserDao;
import model.Adress;
import model.MusicType;
import model.Role;
import model.User;

import java.sql.SQLException;
/**
 Комплексное задание.

 Первая часть.

 Создать 4 сущности(User, Address, Role, MusicType).
 - создать таблицы и связи между таблицами Role:User(1:M), User
 :Address(1:1), User:MusicType (M:M)
 - заполнить таблицы Role(к примеру USER,MANDATOR,ADMIN) и
 MusicType(к примеру RAP, ROCK …. )
 - Реализовать DAO для каждой из сущностей, в которых должны
 находится CRUD операции
 - Для User реализовать операцию получения всех связанных с ним
 сущностей

 Вторая часть.

 Создать web – приложение. Первая страничка логина, на которой два поля
 ввода, и две кнопки. Поля “Login”, “Password”.Кнопки “Войти”,
 “Зарегистрироваться” . При нажатии на кнопку зарегистрироваться попадаем на
 форму, которую нужно заполнить логином, паролем и повторным введением
 пароля, и всеми данными которые имеются у нас в моделях(Кроме роли), при
 submit форма отсылается на сервер где проверяется что пользователем с
 таким логином не существует, и пароли одинаковы. При удачной регистрации
 пользователь должен попасть на страничку где будет написано «Hello
 имя_пользователя», . При неудачно регистрации должно появится
 сообщение о том что “такой логин уже существует”, или же не правильно
 повторили пароли.

 В системе будет существовать три вида пользователей
 (USER,MANDATOR,ADMIN).

 USER при удачном входе попадает на страничку где написано «Hello
 имя_пользователя" , и он не должен попадать на страницы
 предназначенные для MANDATOR и ADMIN.

 MANDATOR попадает на страничку, где отображены все данные о всех
 пользователях в таблице.

 ADMIN попадает на страничку, где отображены все данные о всех
 пользователях в таблице + у него есть возможность добавлять новых, удалять
 и редактировать пользователей. Кнопки удаления и редактирования должны
 стоять в конце каждой строки таблицы.
 */

/**
 * Created by Администратор on 09.03.2016.
 */
public class CRUD_Application {
    public static void main(String[] args) throws SQLException {
        System.out.println("##################################################################");
        //CREATE DAO OBJECT
        Dao<MusicType> musicTypeDao = new MusicTypeDao();
        Dao<User> userDao = new UserDao();
        Dao<Adress> adressDao = new AdressDao();
        Dao<Role> roleDao = new RoleDao();


        System.out.println("~~~~~~~~~~~CREATE~~~~~~~~~~~~~");

        //CREATE ENTITY ROLE
        Role roleAdmin = new Role("role_admin");
        Role roleUser = new Role("role_user");
        Role roleMandator = new Role("role_mandator");

        // CREATE ROLE
        roleDao.create(roleAdmin);
        roleDao.create(roleUser);
        roleDao.create(roleMandator);

        //CREATE ENTITY USER
        User user_Admin = new User("myLogin1", "myPassword1", "MyFirstName1", "MyLastName1", 25, roleDao.getById(1));
        User user_User1 = new User("myLogin2", "myPassword2", "MyFirstName2", "MyLastName2", 25, roleDao.getById(2));
        User user_User2 = new User("myLogin3", "myPassword3", "MyFirstName3", "MyLastName3", 25, roleDao.getById(2));
        User user_Mandator = new User("myLogin4", "myPassword4", "MyFirstName4", "MyLastName4", 25, roleDao.getById(3));

        // CREATE USER
        userDao.create(user_Admin);
        userDao.create(user_User1);
        userDao.create(user_User2);
        userDao.create(user_Mandator);

        // CREATE ENTITY ADRESS
        Adress adress1 = new Adress("Ukraine", "Sumska1", 61118, userDao.getById(1));
        Adress adress2 = new Adress("Ukraine", "Sumska2", 61118, userDao.getById(2));
        Adress adress3 = new Adress("Ukraine", "Sumska3", 61118, userDao.getById(3));
        Adress adress4 = new Adress("Ukraine", "Sumska4", 61118, userDao.getById(4));
        adressDao.create(adress1);
        adressDao.create(adress2);
        adressDao.create(adress3);
        adressDao.create(adress4);

        //CREATE ENTITY MusicType
        MusicType musicType1 = new MusicType("Rock");
        MusicType musicType2 = new MusicType("Pop");
        MusicType musicType3 = new MusicType("Rap");
        MusicType musicType4 = new MusicType("Hip Hop");

        // CREATE MUSIC TYPE
        musicTypeDao.create(musicType1);
        musicTypeDao.create(musicType2);
        musicTypeDao.create(musicType3);
        musicTypeDao.create(musicType4);

        // ADD MUSIC TYPE FOR USER
        User myNewUser = userDao.getById(2);
        myNewUser.addMusicType(musicTypeDao.getById(1));
        myNewUser.addMusicType(musicTypeDao.getById(2));
        myNewUser.addMusicType(musicTypeDao.getById(3));
        userDao.update(myNewUser);


        System.out.println("~~~~~~~~~~~READ~~~~~~~~~~~~~~~");
        System.out.println("read ALL ADRESS");
        for (Adress adress : adressDao.getAll()) {
            System.out.println(adress);
        }
        System.out.println("read ADRESS BY ID");
        System.out.println(adressDao.getById(1));
        System.out.println(adressDao.getById(2));
        System.out.println(adressDao.getById(3));

        System.out.println("read ALL MusicType");
        for (MusicType musicType : musicTypeDao.getAll()) {
            System.out.println(musicType);
        }
        System.out.println("read MusicType BY ID");
        System.out.println(musicTypeDao.getById(1));
        System.out.println(musicTypeDao.getById(2));
        System.out.println(musicTypeDao.getById(3));

        System.out.println("read ALL Role");
        for (Role role : roleDao.getAll()) {
            System.out.println(role);
        }
        System.out.println("read Role BY ID");
        System.out.println(roleDao.getById(1));
        System.out.println(roleDao.getById(2));
        System.out.println(roleDao.getById(3));

        System.out.println("read ALL User");
        for (User user : userDao.getAll()) {
            System.out.println(user);
        }
        System.out.println("read User BY ID");
        System.out.println(userDao.getById(1));
        System.out.println(userDao.getById(2));
        System.out.println(userDao.getById(3));

        System.out.println("read ALL MUSIC OWNED User BY ID ");
        for (MusicType musicType : userDao.getById(2).getMusicTypes()) {
            System.out.println(musicType);
        }
        System.out.println("read adress OWNED User BY ID ");
        System.out.println(userDao.getById(2).getAdress());
        System.out.println("read role OWNED User BY ID ");
        System.out.println(userDao.getById(2).getRole());


//        System.out.println("~~~~~~~~~~~UPDATE~~~~~~~~~~~~~");
//        //UPDATE ENTITY ROLE
//        Role newRoleGuest = new Role("role_guest_22222");
//        newRoleGuest.setId(2);
//        System.out.println(roleDao.update(newRoleGuest));
//
//
//        //UPDATE ENTITY USER
//        User new_Admin = new User("myLogin222", "myPassword222", "MyFirstName1", "MyLastName1", 25, roleDao.getById(1));
//        System.out.println(userDao.update(new_Admin));
//
//
//        // UPDATE ENTITY ADRESS
//        Adress new_adress = new Adress("USA", "22 Ave", 61118, userDao.getById(3));
//        System.out.println(adressDao.update(new_adress));
//
//
//        //UPDATE ENTITY MusicType
//        MusicType new_musicType = new MusicType("Instrumental");
//        System.out.println(musicTypeDao.update(new_musicType));
//
//        System.out.println("~~~~~~~~~~~~~DELETE~~~~~~~~~~~~~~~~~");
//        //DELETE ENTITY USER
//        System.out.println(userDao.delete(userDao.getById(3)));
//
//        //DELETE ENTITY ROLE
//        System.out.println(roleDao.delete(roleDao.getById(1)));
//
//        //DELETE ENTITY MusicType
//        System.out.println(musicTypeDao.delete(musicTypeDao.getById(1)));
//
//        // DELETE ENTITY ADRESS
//        System.out.println(adressDao.delete(adressDao.getById(2)));
        
    }
}

