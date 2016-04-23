package ua.org.oa.metalfan0991;

import org.junit.Test;


/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */
public class DataTest {
    static int[][] validDates = {
            {2015, 1, 1}, {2015, 2, 28}, {2015, 12, 31},
            {2012, 1, 1}, {2012, 2, 28}, {2012, 12, 31},
            {2000, 1, 1}, {2000, 2, 28}, {2000, 2, 29}, {2000, 12, 31},
            {1612, 1, 1}, {1612, 2, 28}, {1612, 2, 29}, {1612, 1, 1},
            {1592, 1, 1}, {1592, 2, 28}, {1592, 2, 29}, {1592, 1, 1},
            {1695, 1, 1}, {1695, 2, 28}, {1695, 1, 1}
    };

    /**
     * ѕроверит конструктор по умолчанию
     *
     * @throws Exception
     */
    @Test
    public void testDateInstantiationCurrentDate() throws Exception {
        new Date();
    }
    /**
     * ѕроверит конструктор на выброс исключени€
     * с нулевым значением года
     *
     * @throws Exception не используетс€
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear2() throws Exception {
        new Date(0, 1, 1);
    }
}
