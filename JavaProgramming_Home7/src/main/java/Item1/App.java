package Item1; /**
 * Created by Abashkin Aleksandr on 25.01.2016.
 */


import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ЗАДАНИЕ
 * <p/>
 * ﻿Задание на Threads
 * <p/>
 * 1. Создать поток, который печатал бы текущее время каждую секунду.
 * Сделать это двумя способами - при помощи расширения класса Thread и при помощи реализации интерфейса Runnable.
 * Предусмотреть возможность его завершения путем ввода любого символа с клавиатуры.
 * <p/>
 * 2. Разработать пример взаимной блокировки двух потоков.
 * <p/>
 * <p/>
 * 3. Создать класс с двумя отдельными счетчиками и объект этого класса.
 * Создать несколько одинаковых потоков, каждый из которых повторяет следующее:
 * сравнивает значение счетчиков и печатает результат сравнения, увеличивает первый счетчик, засыпает на 10 мсек,
 * а затем увеличивает второй счетчик. Сравнить работу программы при условии, что упомянутый блок
 * кода синхронизирован и не синхронизирован.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Для выбора режима 1 введите \"1\"");
        System.out.println("Для выбора режима 2 введите \"2\"");
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        int mode = sc.nextInt();
        switch (mode) {
            case 1:
                System.out.println("Режим первый - создаем поток , расширяя класс Thread(Mode One)");
                ModeOne modeOne = new ModeOne();
                modeOne.TimePrint();


            case 2:
                System.out.println("Режим второй - создаем поток , реализуя интерфейс Runnable(Mode Two)");
                ModeTwo modeTwo = new ModeTwo();
                modeTwo.TimePrint();
                break;
        }
    }
}
