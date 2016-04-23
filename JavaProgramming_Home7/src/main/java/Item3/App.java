package Item3;

/**
 * Created by Abashkin Aleksandr on 29.01.2016.
 */

/**
 * 3. Создать класс с двумя отдельными счетчиками и объект этого класса.
 * Создать несколько одинаковых потоков, каждый из которых повторяет следующее:
 * сравнивает значение счетчиков и печатает результат сравнения, увеличивает первый счетчик, засыпает на 10 мсек,
 * а затем увеличивает второй счетчик. Сравнить работу программы при условии, что упомянутый блок
 * кода синхронизирован и не синхронизирован.
 */


public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();
        // Подготовка потоков
        Thread t[] = new Thread[3];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(counter,
                    "Thread " + i);
        }
        // Запуск потоков
        for (int i = 0; i < t.length; i++) {
            t[i].start();
            System.out.println(t[i].getName() +
                    " started");

        }
    }
}
