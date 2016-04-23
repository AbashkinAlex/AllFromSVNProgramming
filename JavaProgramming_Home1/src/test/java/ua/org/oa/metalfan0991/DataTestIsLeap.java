package ua.org.oa.metalfan0991;

import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Agios on 06.12.2015.
 */

public class DataTestIsLeap {
    static int[] leapYears = {992, 1600, 1832, 1996, 2000, 2008, 2016};
    static int[] notLeapYears = { 1100, 1300, 1400, 1500, 1700, 1800, 1900, 2015, 1999};

    /**
     * Проверка высокостных годов
     */
    @Test
    public void testIsLeapTrue() throws Exception {
        for (int year : leapYears) {
            assertTrue(Date.isLeap(year));
        }
    }

    @Test
    public void testIsLeapFalse() throws Exception {
        for (int year : notLeapYears) {
            assertFalse(Date.isLeap(year));
        }
    }
}
