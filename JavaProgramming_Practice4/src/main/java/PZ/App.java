package PZ;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.regex.*;
/**
 * Created by Abashkin Alexandr on 28.11.2015.
 */


/**
 * +++ 1. Напишите класс Student. С полями ИМЯ(firstName), ФАМИЛИЯ
 * (lastName), НОМЕР КУРСА(course)
 * <p/>
 * +++2. Написать метод static Map<String, Student>
 * createMapFromList(List<Student> students) в классе StudentUtils, который из
 * входящего параметра List<Student> students создает Map, где ключ это ИМЯ
 * + ФАМИЛИЯ, а значение объект Student.
 * <p/>
 * +++3. Напишите метод static void printStudents(List<Student> students, int course) в
 * классе StudentUtils, который печатает в консоль имена тех студентов из
 * списка, которые обучаются на данном курсе. Для обхода списка в этом
 * методе используйте итератор.
 * <p/>
 * +++4. Написать метод в классе StudentUtils, который сортирует студентов по
 * имени List<Student> sortStudent(List students).
 * <p/>
 * 5. Задан текст на английском языке. Выделить все различные слова. Для
 * каждого слова подсчитать частоту его встречаемости. Слова, отличающиеся
 * регистром букв, считать различными. Использовать класс HashMap. Текст
 * считать из файла.
 * <p/>
 * 6. Перегрузить метод из пятого задания с возвратом отсортированного Map,
 * по чем сортировать и в каком направлении указывать через enum
 * константы.
 */

public class App {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Misha", "Petrov", 3));
        students.add(new Student("Petya", "Petrov", 1));
        students.add(new Student("Sasha", "Petrov", 3));
        students.add(new Student("Kolya", "Petrov", 2));
        System.out.println("~~~~~~~~~~~~~~~~~Print students from ArrayList~~~~~~~~~~~~~~~~~~");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("~~~~~~~~~~~~~~~~~StudentUtils.createMapFromList(students)~~~~~~~~~~~~~~~~~~");
        StudentUtils.createMapFromList(students);
        System.out.println(students);

        System.out.println("~~~~~~~~~~~~~~~~~StudentUtils.printStudents(students, 3)~~~~~~~~~~~~~~~~~~");
        StudentUtils.printStudents(students, 3);

        System.out.println("~~~~~~~~~~~~~~~~~StudentUtils.sortStudent(students)~~~~~~~~~~~~~~~~~~");
        System.out.println(StudentUtils.sortStudent(students));
        System.out.println("~~~~~~~~~~~~~~~~~Sorted map~~~~~~~~~~~~~~~~~~");
        File file = new File("D:/Oracle/JavaProgramming_Practice4/src/main/resources/Romeo.txt");
        Map<String, Integer> sortedMap = Task5.sortWord(Task5.toMap(Task5.listFromFile(file)));
        for (final Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(String.format("%s = %s", entry.getKey(), entry.getValue()));
        }
    }
}
