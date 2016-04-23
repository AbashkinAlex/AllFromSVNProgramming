package ua.org.oa.metalfan0991.item1_2_3_4;

import org.junit.Test;
import ua.org.oa.metalfan0991.item1_2_3_4.ArrayProd;
import ua.org.oa.metalfan0991.item1_2_3_4.MyException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abashkin on 11/8/2015.
 */
public class ArrayProdTest {
    static int[] arrayTestProd = {1, 3, 5, 6};
    static int[] empty = {};
    static int exspectedProd = 90;

    @Test
    public void testArrayEmpty() throws Exception {
        int expected = 0;
        int actual = ArrayProd.prod(empty);
        assertEquals(expected, actual);
    }


    @Test
    public void testArrayExist() throws Exception {
        int expected = exspectedProd;
        int actual = ArrayProd.prod(arrayTestProd);
        assertEquals(expected, actual);
    }

    @Test(expected = MyException.class)
    public void testArrayNull() throws Exception {
        ArrayProd.prod(null);
    }


}