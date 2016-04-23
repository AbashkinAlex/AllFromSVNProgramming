package Item1; /**
 * Created by Abashkin Aleksandr on 25.01.2016.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * ЗАДАНИЕ
 * ﻿Задание на I/O Stream
 * 1. Необходимо создать класс Item1.Book с полями
 * title - строковое
 * author - строковое
 * year - целочисленое
 * Необходимо создать файл со структурой
 * author1;title1;year1
 * author2;title2;year2
 * author2;title2;year2
 * Необходимо создать приложение которое прочитает файл и заполнит даными из него, колекцию обьектов Item1.Book. *В дополнение реализовать метод для добавления обьекта Item1.Book в файл.
 * **Возможно использовать сериализацию.
 * 2. Написать приложение мини-файловый редактор.
 * Реализовать команды, создания файла, удаления файла, перейменования, для папки отображение списка файлов внутри.
 * В комнадной строке передавать название файла и команду
 */
public class App {

    static String fileName = "src\\main\\resources\\item1\\File"; //откуда мы все читаем

    public static void main(String[] args) {


        //Читаем из файла
        try {
            System.out.println("ТО ЧТО ПРОЧИТАЛИ ИЗ ФАЙЛА : ");
            System.out.println(read(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Book> arrayList = new ArrayList<Book>();
        String[] words = new String[3];
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();                                                    // только записываем в стрингу строку из файла(построчно читаем текст)
                StringTokenizer stringTokenizer = new StringTokenizer(s, ";");           // а здесь строчку делим на куски используя разделитель ";"
                while (stringTokenizer.hasMoreTokens()) {                                // в цикле перебираем эти слова
                    for (int i = 0; i < 3; i++) {
                        words[i] = stringTokenizer.nextToken();
                    }

                    int year = Integer.parseInt(words[2]);
                    Book book = new Book(words[1], words[0], year);
                    arrayList.add(book);

                }

            }

        }
        System.out.println("ArrayList = " + arrayList);

    }


    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }


    //Метод принимает в качестве аргумента имя файла, а возвращает прочитанную строку

    public static String read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {

                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
