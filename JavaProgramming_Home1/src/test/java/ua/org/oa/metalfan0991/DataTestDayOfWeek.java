package ua.org.oa.metalfan0991;

import org.junit.Test;


import static org.junit.Assert.assertEquals;


/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */

public class DataTestDayOfWeek {
    Date d;
    DayOfWeek expect;
    DayOfWeek actual;

    @Test
    public void testDayOfWeek1() throws Exception, UnresolvedDayOfWeekIndex {
        d = new Date(2015, 11, 22);
        expect = DayOfWeek.SUNDAY;
        actual = d.getDayOfWeek();

        assertEquals(" Test DayOfWeek1", expect, actual);
    }

    @Test
    public void testDayOfWeek2() throws Exception, UnresolvedDayOfWeekIndex {
        d = new Date(2015, 11, 19);
        expect = DayOfWeek.THUSDAY;
        actual = d.getDayOfWeek();
        assertEquals(" Test DayOfWeek1", expect, actual);
    }


}
