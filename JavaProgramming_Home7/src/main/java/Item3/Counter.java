package Item3;

/**
 * Created by Администратор on 02.03.2016.
 */

/**
 * 3. Создать класс с двумя отдельными счетчиками и объект этого класса.
 * Создать несколько одинаковых потоков, каждый из которых повторяет следующее:
 * сравнивает значение счетчиков и печатает результат сравнения, увеличивает первый счетчик, засыпает на 10 мсек,
 * а затем увеличивает второй счетчик. Сравнить работу программы при условии, что упомянутый блок
 * кода синхронизирован и не синхронизирован.
 */
public class Counter implements Runnable {
    int i1 = 0;
    int i2 = 0;

    public int count1() {
        return i1++;
    }

    public int count2() {
        return i2++;
    }

    @Override
    public void run() {

        /**
         * Т.к. только один поток может получить блокировку и выполнить команды из
         "критической секции" блока кода, счетчик увеличивается только одним потоком в
         каждый момент времени, в результате, программа выводит значения от 0 до 30
         правильно (без проблемы гонки).
         */

        synchronized (Counter.this) {
            while ((i1|i2)<=30) {
                System.out.println(" i1 == i2 ? " + (i1 == i2));
                System.out.println("Count1 = " + count1());
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Count2 = " + count2());
            }
        }
    }
}
