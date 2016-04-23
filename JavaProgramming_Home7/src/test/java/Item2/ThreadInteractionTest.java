package Item2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Abashkin Aleksandr on 07.03.2016.
 */
public class ThreadInteractionTest {
    ThreadInteraction threadInteraction = new ThreadInteraction();
    @Test
    public void testDeadlockExample() throws Exception {
        assertEquals(threadInteraction.DeadlockExample(),"After 5 seconds threads are:\n" +
                "WAITING, WAITING");
    }
}