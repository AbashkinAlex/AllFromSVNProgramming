package ua.org.oa.metalfan0991;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 04.01.2016.
 */
public class GenericStorageTest {
    /*Field for testing */
    GenericStorage<String> myGen;

    @Before
    public void setUp() throws Exception {
        myGen = new GenericStorage<String>();
        myGen.add("11");
        myGen.add("12");
        myGen.add("13");
        myGen.add("14");

    }
    /**
     * Тест конструкторов
     *
     * @throws Exception
     */
    @Test
    public void testConstructorDef() throws Exception {
        myGen = new GenericStorage<String>();
        assertEquals("Size default ", 10, myGen.arrSize());
    }

    @Test
    public void testConstructor() throws Exception {
        myGen = new GenericStorage<String>(15);
        assertEquals("Size default(constuctor with parameter) ", 15, myGen.arrSize());
    }
    /**
     * Добавить элемент
     */
    @Test
    public void testAdd() throws Exception {
        myGen = new GenericStorage<String>(15);
        myGen.add("1");
    }
    /**
     * Получит по индексу объект
     */
    @Test
    public void testGet() throws Exception {
        assertEquals("Wrong element", "14", myGen.get(3));
    }
    /**
     * Удаляем объект
     */
    @Test
    public void testDeleteObj() throws Exception {
        myGen.delete("11");
        assertEquals("After delete element", "13", myGen.get(1));
    }
    /**
     * Удаляем по индексу
     */
    @Test
    public void testDeleteIndex() throws Exception {
        myGen.remove(0);
        assertEquals("After delete element", "12", myGen.get(0));
    }

    /**
     * Заменить элемент
     */
    @Test
    public void testUpdate() throws Exception {
        myGen.update(1, "newString");
        assertEquals("Update element", "newString", myGen.get(1));
    }

}