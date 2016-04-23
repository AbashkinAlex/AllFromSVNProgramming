package ua.org.oa.metalfan0991.task5_1;

import java.util.Comparator;

/**
 * Created by Администратор on 06.01.2016.
 */
public class Computer implements Comparator<Computer> {

    private int sizeHDD ;
    private String color;
    private String nameProcessor;

    public Computer(int sizeHDD, String color, String nameProcessor) {
        setColor(color);
        setNameProcessor(nameProcessor);
        setSizeHDD(sizeHDD);
    }
    public Computer() {

    }

    public int getSizeHDD() {
        return sizeHDD;
    }

    public void setSizeHDD(int sizeHDD) {
        this.sizeHDD = sizeHDD;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNameProcessor() {
        return nameProcessor;
    }

    public void setNameProcessor(String nameProcessor) {
        this.nameProcessor = nameProcessor;
    }
// Метод сравнения по имени цвета компьютеров(раскомментить когда надо будет)
//    public int compare(Computer o1, Computer o2) {
//        String str1 = o1.getColor();
//        String str2 = o2.getColor();
//
//        return str1.compareTo(str2);
//    }


    // Метод сравнения по размеру HDD компьютеров
    public int compare(Computer o1, Computer o2) {
        int sizeHDD1 = o1.getSizeHDD();
        int sizeHDD2 = o2.getSizeHDD();

        if(sizeHDD1 > sizeHDD2) {
            return 1;
        }
        else if(sizeHDD1 < sizeHDD2) {
            return -1;
        }
        else {
            return 0;
        }
    }




}
