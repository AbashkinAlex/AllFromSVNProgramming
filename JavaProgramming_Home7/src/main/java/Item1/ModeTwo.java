package Item1;

import Item2.ThreadInteraction;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Администратор on 02.03.2016.
 */
public class ModeTwo {

    public void TimePrint() {
        class PrintingThread implements Runnable {     //второй вариант, реализация интерфейса Runnable
            Thread t;

            public PrintingThread() {
                t = new Thread(this);
                t.start();

            }

            private boolean terminated = false;

            public void terminate() {
                terminated = true;
                t.interrupt();
            }

            public void run() {
                while (!terminated) {
                    Date currentDate = new Date();
                    System.out.println(DateFormat.getDateTimeInstance(
                            DateFormat.LONG, DateFormat.LONG).format(currentDate));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }


        }

        PrintingThread t = new PrintingThread();
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(ThreadInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.terminate();
    }


}
