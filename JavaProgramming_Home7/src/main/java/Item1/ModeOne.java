package Item1;
import Item2.ThreadInteraction;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by Abashkin Aleksandr on 02.03.2016.
 */

/**
 * 1. Создать поток, который печатал бы текущее время каждую секунду.
 * Сделать это двумя способами - при помощи расширения класса Thread и при помощи реализации интерфейса Runnable.
 * Предусмотреть возможность его завершения путем ввода любого символа с клавиатуры.
 */
public class ModeOne {

    public void TimePrint()
    {
        class PrintingThread extends Thread //первый вариант, расширяя класс Thread
        {
            private boolean terminated = false;

            public void terminate()
            {
                terminated = true;
                interrupt();
            }

            @Override
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
        t.start();
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(ThreadInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.terminate();
    }

}
