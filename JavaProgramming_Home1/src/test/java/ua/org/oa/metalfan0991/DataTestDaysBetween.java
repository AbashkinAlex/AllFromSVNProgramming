package ua.org.oa.metalfan0991;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */

public class DataTestDaysBetween {
    static Date startLeapDate = new Date(2000, 1, 1);
    int expected = 0;

    @Test
    public void testBetweenSame() throws Exception {

        expected = 0;
        Date end = new Date();
        end.setDate(startLeapDate);
        assertEquals(expected, startLeapDate.daysBetween(end));
    }
    @Test
    public void testBetweenSomeDays() throws Exception {

        expected = 30;
        Date end = new Date(2000, 1, 31);
        assertEquals(expected, startLeapDate.daysBetween(end));
    }

}
