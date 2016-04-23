package Item1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abashkin Aleksandr on 29.01.2016.
 */
public class AppTest {
    static String fileName = "src\\main\\resources\\item1\\File";

    @Test
    public void testRead() throws Exception {

        assertEquals("method read() ",
                "author1;title1;1999\n" +
                "author2;title2;1994\n" +
                "author3;title5;1995\n", App.read(fileName));
    }
}