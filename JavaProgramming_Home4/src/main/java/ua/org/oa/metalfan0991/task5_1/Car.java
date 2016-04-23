package ua.org.oa.metalfan0991.task5_1;

/**
 * Created by Администратор on 06.01.2016.
 */
public class Car {
    private String brand;
    private String color;
    private int speed;

    public Car(String brand, String color, int speed) {
        setBrand(brand);
        setColor(color);
        setSpeed(speed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
