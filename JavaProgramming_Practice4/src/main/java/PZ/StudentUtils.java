package PZ;

import java.util.*;

/**
 * Created by Abashkin Alexandr on 28.11.2015.
 */
public class StudentUtils {

    /**
     * 2. Написать метод static Map<String, Student>
     createMapFromList(List<Student> students) в классе StudentUtils, который из
     входящего параметра List<Student> students создает Map, где ключ это ИМЯ
     + ФАМИЛИЯ, а значение объект Student.
     * @param students
     * @return
     */
    static Map<String, Student> createMapFromList(List<Student> students) {
        Map<String, Student> studentMap = new HashMap<String, Student>();
        for (Student std : students) {
            studentMap.put(std.firstName.concat(std.lastName), std);
        }
        return studentMap;
    }


    /**
     * 3. Напишите метод static void printStudents(List<Student> students, int course) в
     классе StudentUtils, который печатает в консоль имена тех студентов из
     списка, которые обучаются на данном курсе. Для обхода списка в этом
     методе используйте итератор.
     * @param students
     * @param course
     */
    static void printStudents(List<Student> students, int course) {
        for (Student std : students) {
            if ((std.course) == (course)) {
                System.out.println(std);
            }
        }
    }

    /**
     *  4. Написать метод в классе StudentUtils, который сортирует студентов по
     имени List<Student> sortStudent(List students).
     * @param students
     * @return
     */
    static List<Student> sortStudent(List students) {
        List<Student> std = new ArrayList<>(students);
        //Arrays.sort(students);
        Collections.sort(std, new SortedByName());
        return std;
    }
}



