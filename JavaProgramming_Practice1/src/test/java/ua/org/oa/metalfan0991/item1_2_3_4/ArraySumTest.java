package ua.org.oa.metalfan0991.item1_2_3_4;

import org.junit.Before;
import org.junit.Test;
import ua.org.oa.metalfan0991.item1_2_3_4.ArraySum;
import ua.org.oa.metalfan0991.item1_2_3_4.MyException;

import static org.junit.Assert.*;

/**
 * Created by Aleksandr Abashkin on 07.11.2015.
 */

//1. Установка JUnit. Одиночные тесты
//
//        Установите JUnit на локальный компьютер. Проверьте установку
//
//        JUnit.
//
//        Спроектируйте класс суммирования элементов массива ArraySum,
//
//        содержащий статический метод Sum(), принимающий массив в качестве
//
//        параметра.
//
//        Разработайте класс ArraySumTest для тестирования ArraySum.
//
//        Реализуйте класс ArraySum. Добейтесь корректного выполнения
//
//        тестов.
//
//        2. JUnit: тесты над общими наборами объектов (fixtures)
//
//        Расширьте класс ArraySum, запланировав в нем конструктор и метод
//
//        экземпляра Sum(), суммирующий массив, заданный в конструкторе.
//
//        Расширьте класс ArraySumTest, превратив его в fixture (тест,
//
//        использующий общий набор объектов). В качестве общего объекта должен
//
//        выступать массив для суммирования.
//
//        Реализуйте дополнительную функциональность в классе ArraySum.
//
//        Добейтесь корректного выполнения тестов.
//
//        3. JUnit: тестирование исключений
//
//        Добавьте в класс ArraySumTest метод, тестирующий поведение
//
//        класса ArraySum при передаче в его статический метод Sum() значения null.
//
//        Оцените результат выполнения теста и добейтесь его корректного
//
//        выполнения.
//
//        Откорректируйте тестирующий метод так, чтобы он ожидал
//
//        генерации исключения и выдавал ошибку в случае, если исключение не
//
//        возникает. Добейтесь корректного выполнения теста.
//
//        4. JUnit: группы тестов (test suites)
//
//        Добавьте в проект новый класс ArrayProd, реализующий
//
//        произведение элементов массива и соответствующий тестовый класс
//
//        ArrayProdTest.
//
//        Объедините ArraySumTest и ArrayProdTest в рамках группы тестов
//
//        AllTests.
//
//        Выполните группу тестов за один раз.
//
//        5. Разработка, основанная на тестах
//
//        Разработайте на основе тестов один из следующих классов.
//
//        Разработать класс, представляющий студента. Студент характеризуется
//
//        именем, фамилией, группой и набором экзаменов, которые он сдавал.
//
//        Экзамен характеризуется названием предмета, оценкой студента по нему и
//
//        датой сдачи (год, семестр). Группа характеризуется курсом и факультетом.
//
//        Необходимые операции таковы:
//
//        узнать наивысшую оценку среди всех экзаменов по данному
//
//        предмету
//
//        добавить ему оценку по экзамену
//
//        удалить для него оценку по экзамену;
//
//        если он такой экзамен не сдавал - сгенерировать исключение
//
//        узнать число экзаменов, которые он сдал с указанной оценкой
//
//        узнать его средний балл за указанный семестр;


public class ArraySumTest {
    static int[] arrayTest = {1, 3, 5, 6};
    static int[] empty = {};
    static int exspectedSum = 15;

    @Before
    public void createArraySum() throws Exception {
//        ArraySum arraySum = new ArraySum(1);
//        return;
    }

    @Test
    public void testArrayEmpty() throws Exception {
        int expected = 0;
        int actual = ArraySum.sum(empty);
        assertEquals(expected, actual);
    }


    @Test
    public void testArrayExist() throws Exception {
        int expected = exspectedSum;
        int actual = ArraySum.sum(arrayTest);
        assertEquals(expected, actual);
    }

    @Test(expected = MyException.class)
    public void testArrayNull() throws Exception {
        ArraySum.sum(null);
    }


}