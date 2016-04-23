package ua.org.oa.metalfan0991;

import org.junit.Test;

/**
 * Created by Aleksandr Abashkin on 06.12.2015.
 */

import static org.junit.Assert.assertEquals;

public class DataTestDaysInMonth {
    @Test
    public void testDaysInMonth1() throws Exception {
        int expected = 31;
        Date d = new Date(2000, 1, 1);
        int actual = d.getMonth().getTotalDays();

        assertEquals(expected, actual);
    }
}
