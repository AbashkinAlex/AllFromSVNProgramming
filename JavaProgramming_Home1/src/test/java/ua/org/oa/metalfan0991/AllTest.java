package ua.org.oa.metalfan0991;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataTest.class,
        DataTestDayOfWeek.class,
        DataTestDaysBetween.class,
        DataTestDaysInMonth.class,
        DataTestIsLeap.class

})

public class AllTest {

}