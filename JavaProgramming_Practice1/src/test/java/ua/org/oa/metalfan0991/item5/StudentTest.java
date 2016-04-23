package ua.org.oa.metalfan0991.item5;

import org.junit.Before;
import org.junit.Test;
import ua.org.oa.metalfan0991.item1_2_3_4.ArrayProd;

import static org.junit.Assert.*;

/**
 * Created by Abashkin Alexandr on 13.03.2016.
 */
public class StudentTest {
    //Создаем студента
    Student vasya = new Student("Вася", "Пупкин");

    @Before
    public void someMethod() throws NoSuchSubjectOrDateException {
        //Создаем группу
        Group someGroup = new Group("Гр-1", "Прикладная математика", "ЭМСфак");

        //Создаем экзамены
        Exam EnglishExam1 = new Exam("English", "JANUARY 4 2016", 1);
        Exam EnglishExam2 = new Exam("English", "JANUARY 5 2016", 1);
        Exam EnglishExam3 = new Exam("English", "JANUARY 6 2016", 1);
        Exam EnglishExam4 = new Exam("English", "JANUARY 7 2016", 1);
        //добавить студента в группу
        vasya.setGroup(someGroup);
        //добавить экзамены что он сдавал
        vasya.addExam(EnglishExam1);
        vasya.addExam(EnglishExam2);
        vasya.addExam(EnglishExam3);
        vasya.addExam(EnglishExam4);
        //Выставляем оценки студенту
        vasya.addAssessment("JANUARY 4 2016", "English", 5);
        vasya.addAssessment("JANUARY 5 2016", "English", 8);
        vasya.addAssessment("JANUARY 6 2016", "English", 8);
        vasya.addAssessment("JANUARY 7 2016", "English", 12);
    }

    @Test
    public void testGetMaxAssessment() throws Exception {
        int expected = 12;
        int actual = vasya.getMaxAssessment("English");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAssessment() throws Exception {

        boolean expected = true;
        boolean actual = vasya.addAssessment("JANUARY 4 2016", "English", 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteAssessment() throws Exception {

        boolean expected = true;
        boolean actual = vasya.deleteAssessment("JANUARY 7 2016", "English");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfExam() throws Exception {

        int expected = 2;
        int actual = vasya.getNumberOfExam(8);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageAssessment() throws Exception {

        Double expected = 8.25;
        Double actual = vasya.getAverageAssessment(1);
        assertEquals(expected, actual);
    }
}