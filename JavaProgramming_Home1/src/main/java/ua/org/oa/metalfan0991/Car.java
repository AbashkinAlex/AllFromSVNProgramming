package ua.org.oa.metalfan0991;

import static java.lang.System.out;

/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */
/*Анонимные классы.
Создайте класс автомобиль.
Создайте 2 объекта этого класса.
При создании каждого из объектов класса автомобиль переопределите методы toString() и equals()
c помощью анонимных классов, что б вывод toString() был различным для каждого из объектов.
Продемонстрируйте, работу переопределенных методов.
*/

public class Car {
    // -------Переменные---------
    private Color color;
    private Body type;
    private String model;
    //-------Конструктор------------
    public Car(Color color, Body type, String model) {
        this.color = color;
        this.type = type;
        this.model = model;
    }

    // Константы цвета
    public enum Color {
        UNDEFINED, RED, GREEN, PURPLE, WHITE, BLACK, BLUE, EGGPLANT
    }

    // Константы типа кузова
    public enum Body {
        HATCHBACK, COUPE, PICKUP, SEDAN, WAGON, CABRIOLET
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (color != car.color) return false;
        if (type != car.type) return false;
        return model.equals(car.model);

    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color=" + color +
                ", type=" + type +
                ", model='" + model + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Объект базового класса
        Car regularCar = new Car(Color.BLUE, Body.SEDAN, "ВАЗ 2101");

        // Объект №1  с переопределенным методом toString
        Car car1 = new Car(Color.BLACK, Body.PICKUP, "Toyota Tundra") {

            @Override
            public String toString() {
                return "Черная Тойота Тундра ";
            }
        };

        // Объект №2 с переопределенным toString
        Car car2 = new Car(Color.GREEN, Body.SEDAN, "Volkswagen Juke") {
            @Override
            public String toString() {
                return "Зелённый Фольцваген Жук";
            }
        };



        // Форматированный вывод
        String template = "Класс: \"%-30s\" toString: \"%s\"\n";

        out.printf(template, regularCar.getClass().getName(), regularCar);
        out.printf(template, car1.getClass().getName(), car1);
        out.printf(template, car2.getClass().getName(), car2);

    }
}
