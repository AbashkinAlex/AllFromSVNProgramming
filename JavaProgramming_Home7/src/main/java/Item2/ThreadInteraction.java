package Item2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Abashkin Aleksandr on 02.03.2016.
 */
public class ThreadInteraction {
    /**
     * 1. Разработать пример взаимной блокировки 2х потоков, в котором
     * используются только два объекта - потоки.
     */
    public String DeadlockExample() {
        StringBuilder sb = new StringBuilder();

        class DeadlockedThread extends Thread {
            private Thread otherThead;

            public void setOtherThread(Thread otherThead) {
                this.otherThead = otherThead;
            }

            @Override
            public void run() {
                try {
                    otherThead.join();
                } catch (InterruptedException ex) {

                }
            }
        }

        DeadlockedThread t1 = new DeadlockedThread();
        DeadlockedThread t2 = new DeadlockedThread();

        t1.setOtherThread(t2);
        t2.setOtherThread(t1);
        t1.start();
        t2.start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }

        sb.append("After 5 seconds threads are:\n");
        sb.append(t1.getState() + ", " + t2.getState());
        t1.interrupt();
        t2.interrupt();
        return sb.toString();
    }

}
