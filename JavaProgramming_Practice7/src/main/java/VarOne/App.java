package VarOne; /**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */

import VarOne.dao.Dao;
import VarOne.dao.HumanDao;
import VarOne.model.Human;

import java.sql.SQLException;

/**
 * Создать 4 сущности(User, Address, Role, MusicType). Обязательные поля
 для User – id,login, password. Реализовать DAO для каждой из сущностей, в
 которых должны находится CRUD операции (создать, выбрать все сущности,
 выбор сущности по id, редактировать сущность, удалить сущность).

 - создать таблицы и связи между таблицами Role:User(1:M), User
 :Address(1:1), User:MusicType (M:M)

 - заполнить таблицы Role(к примеру USER,MANDATOR,ADMIN) и
 MusicType(к примеру RAP, ROCK …. )

 - Реализовать DAO для каждой из сущностей, в которых должны
 находится CRUD операции

 - Для User реализовать операцию получения всех связанных с ним
 сущностей
 */

public class App {
    public static void main(String[] args) throws SQLException {
        //SqlHelper.init();
        Human vasya = new Human("Vasya", 30);
        Dao<Human> humanDao = new HumanDao();
        humanDao.create(vasya);
        System.out.println(vasya);
    }
}
