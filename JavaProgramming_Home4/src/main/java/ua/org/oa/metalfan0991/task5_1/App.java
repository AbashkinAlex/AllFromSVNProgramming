package ua.org.oa.metalfan0991.task5_1;

import java.util.Arrays;

/**
 * Created by Администратор on 06.01.2016.
 */
public class App {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];
        Car[] cars = new Car[3];

        // заполним объект Computer содержимым
        computers[0] = new Computer(240, "black", "intel");
        computers[1] = new Computer(134, "white", "AMD");
        computers[2] = new Computer(90, "blue", "intel");

        // заполним объект Car содержимым
        cars[0] = new Car("Lada", "Баклажан", 100);
        cars[1] = new Car("Lada", "Баклажан", 100);
        cars[2] = new Car("Lada", "Баклажан", 100);


        // выведем данные без сортировки
        System.out.println("============ no sorted ==============");

        for (Computer i : computers) {
            System.out.println("Color: " + i.getColor() +
                    " HDD: " + i.getSizeHDD() +
                    " Processor: " + i.getNameProcessor());
        }


        // отсортируем объекты Computer и выведем данные
        System.out.println("========== sorted ===========");

        Arrays.sort(computers, new Computer());
        for (Computer i : computers) {
            System.out.println("Color: " + i.getColor() +
                    " HDD: " + i.getSizeHDD() +
                    " Processor: " + i.getNameProcessor());
        }

        // отсортируем объекты Cars и выведем данные по названию(Как и ожидалось, выбрасывает ошибку,
        // т.к. наш Компаратор обобщен только обектами класса Computer!)

//        System.out.println("========== sorted Cars by name  ===========");
//
//        Arrays.sort(cars, new Computer());
//        for (Car i : cars) {
//            System.out.println("Color: " + i.getColor() +
//                    " HDD: " + i.getSpeed() +
//                    " Processor: " + i.getBrand());
//        }


    }
}