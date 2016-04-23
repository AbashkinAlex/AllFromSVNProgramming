package ua.org.oa.metalfan0991;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 **/


public class Date {

    //  Переменные из класса Date

    private static final int DAYS_IN_YEAR = 365;  // кол-во дней в году
    private static final int MIN_DATE_YEAR = 1583;  // минимальное значение года
    private static final int MIN_MONTH = 1;    // минимальное значение месяца
    private static final int MAX_MONTH = 12;   // максимальное значение месяца
    private static final int FEBRUARY_INDEX = 1;  // индекс февраля
    private static final int[] MOTHS_MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // кол-во дней в месяцах

    //  Метод возрващает кол-во дней в месяце

    private static int maxDaysFor(int monthNumber, boolean isLeap) {

        int monthIndex = (monthNumber - 1);

        //  Если февраль высокостный

        if (monthIndex == FEBRUARY_INDEX && isLeap) {
            return (MOTHS_MAX_DAYS[monthIndex] + 1);
        }
        //  Если февраль невысокостный
        return MOTHS_MAX_DAYS[monthIndex];
    }

    //  Проверка Высокостный ли год

    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    //Переменные

    private Date.Year year;   // год
    private Date.Month month;  // месяц
    private Date.Day day;   // день месяца

    //  Конструктор создаст дату такую же как текущая системная дата

    public Date() {
        Calendar c = Calendar.getInstance();
        setDate(c.get(YEAR), (c.get(MONTH) + 1), c.get(DATE));
    }

    // Расширенный конструктор

    public Date(int year, int month, int day) {
        setDate(year, month, day);
    }

    //  Метод-фабрика

    //Возвращает объект класса Day

    private Date.Day dayInstance(Date.Year year, Date.Month month, int day) {
        int maxDays = maxDaysFor(month.value(), year.isLeap());
        if (day > maxDays) {
            throw new IllegalArgumentException("В текущем месяце не может быть более" + maxDays + "дней");
        }
        return new Date.Day(day);
    }


    //-----Установит новую дату, на основе значений параметра date---

    public void setDate(Date date) {
        setDate( date.getYear().value(), date.getMonth().value(), date.getDay().value());
    }

    // Установит новую дату

    public void setDate(int year, int month, int day) {
        this.year = new Year(year);
        this.month = new Month(month);
        this.day = dayInstance(this.year, this.month, day);
    }

    //----------Геттеры------------

    public Date.Year getYear() {
        return year;
    }

    public Date.Month getMonth() {
        return month;
    }

    public Date.Day getDay() {
        return day;
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Расчет дня недели на основе даты.
    // UnresolvedDayOfWeekIndex - выбрасывается если не удалось найти подходящий
    //         элемент для дня недели, по индексу

    public DayOfWeek getDayOfWeek() throws UnresolvedDayOfWeekIndex {

        int day = getDay().value();
        int month = getMonth().value();
        int year = getYear().value();

        Calendar newCal = new GregorianCalendar(year, month-1,  day);

        int dayOfWeek = newCal.get(Calendar.DAY_OF_WEEK);

        return DayOfWeek.valueOf(dayOfWeek);
    }

    /**
     * Расчитает разницу в днях между двумя датами.
     *
     * Принимает : дату, до которой необходимо расчитать кол-во дней
     * Вернет:  кол-во дней между датами. При этом значение будет
     * отрицательным, если объект в параметре date меньше (раньше) вызывающей,
     * в противном случае возвращаемое значение будет положительным.
     */

    public int daysBetween(Date date) {

        LocalDate start
                = LocalDate.of(this.getYear().value(), this.getMonth().value(), this.getDay().value());

        LocalDate end
                = LocalDate.of(date.getYear().value(), date.getMonth().value(), date.getDay().value());

        return (int) ChronoUnit.DAYS.between(start, end);
    }

    //  ------------- Inner classes----------------
    //Вложенный класс Year
    public class Year {

        //  Переменные вложенного класса Year

        private int year;   // год
        private boolean isLeap;  // высокосный ли год
        private int totalDays;  // кол-во дней в году

        // -------------- Конструктор---------------

        private Year(int year) {
            setYear(year);
            this.isLeap = Date.isLeap(year);
            totalDays = DAYS_IN_YEAR;

            if (this.isLeap) {
                ++totalDays;
            }
        }

        public boolean isLeap() {
            return isLeap;
        }

        public int value() {
            return year;
        }

        public void setYear(int year) {
            if (year <= MIN_DATE_YEAR) {
                throw new IllegalArgumentException("Year must be > " + MIN_DATE_YEAR + "  but year = " + year);
            }
            this.year = year;
        }

        public void setIsLeap(boolean isLeap) {
            this.isLeap = isLeap;
        }
    }

    //Вложенный класс Month

    public class Month {

        //  Переменные вложенного класса Month

        private int month;         // номер месяца
        private int totalDays;  // кол-во дней в месяце

        //  Конструктор вложенного класса Month

        private Month(int month) {


            if (month < MIN_MONTH || MAX_MONTH < month) {
                throw new IllegalArgumentException("Значение месяца должно быть от " + MIN_MONTH + " до " + MAX_MONTH);
            }


            this.month = month;
            this.totalDays = Date.maxDaysFor(month, getYear().isLeap());
        }

        public int value() {
            return month;
        }

        public int getTotalDays() {
            return totalDays;
        }
    }

    //Вложенный класс Day

    public class Day {

        //  Переменные вложенного класса Day

        private int day;

        //  Конструктор вложенного класса Day

        private Day(int day) {
            this.day = day;
        }

        public int value() {
            return day;
        }
    }
}

