package ua.org.oa.metalfan0991; /**
 * Created by Aleksandr Abashkin on 22.12.2015.
 */

import java.util.Arrays;

/**
 * Создать Generic хранилище данных(ua.org.oa.metalfan0991.GenericStorage). В качестве хранилища использовать массив.
 * Должно быть реализовано CRUD(create read update delete — «Создание чтение обновление удаление») операций.
 * <p>
 * Детальное описание:
 * 1.+	Создать конструктор без параметров. При вызове такого конструктора должен инициализироваться массив длиной 10.
 * 2.+	Создать конструктор с параметром (int size). Size - размер массива.
 * 3.+	Метод add(T obj), который добавит новый элемент в хранилище в конец
 * 4.+	Метод T get(int index), который возвратит элемент по индексу в масиве.
 * 5.+	Метод T[] getAll(), который вернет массив элементов. (Распечатать массив при помощи Arrays.toString(<-Ваш массив->))
 * 6.+	Метод update(int index, T obj), который подменит объект по заданной позиции только, если на этой позиции уже есть элемент.
 * 7.+	Meтод delete(int index), который удалит элемент по индексу и захлопнет пустую ячейку в массиве, если на этой позиции уже есть элемент.
 * 8.+	Метод delete(T obj), который удалит заданный объект из массива
 * 9.+	Метод который возвратит размер массива ЗАПОЛНЕНОГО
 * <p>
 * Примечание:
 * нужно всегда хранить индекс ячейки массива, который указывает на позицию следующую после последнего элемента.
 * Изначально это 0 так как массив пуст, после добавления первого элемента индекс указывает на 1 и т.д.
 * не забывайте что переменная index (get(int index), update(int index, T obj), delete(int index) )
 * должна всегда попадать в рамки 0 - индекс последнего элемента.
 */
public class App {

    public static void main(String[] args) {
        GenericStorage<String> genericStorage = new GenericStorage();   // 1.в конструкторе(по умолчанию) инициализируется массив длиной 10.
        genericStorage.add("1");                                        // Метод add(T obj), который добавит новый элемент в хранилище в конец
        genericStorage.add("2");
        genericStorage.add("3");
        genericStorage.add("4");
        genericStorage.add("5");
        genericStorage.add("6");
        genericStorage.add("7");
        genericStorage.add("8");
        genericStorage.add("9");
        genericStorage.add("10");
        GenericStorage genericStorage2 = new GenericStorage(2);           // 2.в конструкторе(с параметром) инициализируется массив длиной 2.
        genericStorage2.add("11");                                        // Метод add(T obj), который добавит новый элемент в хранилище в конец
        genericStorage2.add("12");

        System.out.println("По индексу 4 у нас лежит --> " + genericStorage.get(4));                                           // возвратит элемент по индексу в масиве

        System.out.println("Всего массив состоит из таких элементов --> " + Arrays.toString(genericStorage.getAll()));         //Метод T[] getAll(), который вернет массив элементов.

        genericStorage.update(1, "100");
        System.out.println("После замены элемента под индексом 1 массив выглядит вот так --> "
                + Arrays.toString(genericStorage.getAll()));        //Метод update(int index, T obj), который подменит объект по заданной позиции только,
        // если на этой позиции уже есть элемент.

        genericStorage.delete("100");                                                                                           //Метод delete(T obj), который удалит заданный объект из массива
        System.out.println("После удаления элемента со значением \"100\"" +
                " массив выглядит вот так --> " + Arrays.toString(genericStorage.getAll()));

        System.out.println("Размер массива --> " + genericStorage.arrSize());     //Метод который возвратит размер массива ЗАПОЛНЕНОГО
    }

}
