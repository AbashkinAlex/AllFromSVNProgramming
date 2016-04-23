package PZ;

import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Abashkin Aleksandr on 21.03.2016.
 */
public class StudentUtilsTest {
    List<Student> students = new ArrayList<Student>();
    @Before
    public void setUp() throws Exception {
        students.add(new Student("Misha", "Petrov", 3));
        students.add(new Student("Petya", "Petrov", 1));
        students.add(new Student("Sasha", "Petrov", 3));
        students.add(new Student("Kolya", "Petrov", 2));
    }

    @org.junit.Test
    public void testSortStudent() throws Exception {
        List<Student> std = new ArrayList<>();
        std.add(new Student("Kolya", "Petrov", 2));
        std.add(new Student("Misha", "Petrov", 3));
        std.add(new Student("Petya", "Petrov", 1));
        std.add(new Student("Sasha", "Petrov", 3));
        assertEquals("sort student: ", std, StudentUtils.sortStudent(students));
    }

}