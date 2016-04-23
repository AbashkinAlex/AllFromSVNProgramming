package ua.org.oa.metalfan0991;

/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */
public enum DayOfWeek {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THUSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    // Метод возвращает значение дня недели

    public static DayOfWeek valueOf(int index) throws UnresolvedDayOfWeekIndex {

        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getDayIndex() == index) {
                return day;
            }
        }

        throw new UnresolvedDayOfWeekIndex();
    }

    private int dayIndex = 0; // Индекс текущего дня недели

    //  Конструктор ~

    // dayIndex - объект дня недели

    DayOfWeek(int dayIndex) {
        setDayIndex(dayIndex);
    }

    //  Геттер

    // Возвращает индекс дня недели

    public int getDayIndex() {
        return dayIndex;
    }

    //  Сеттер ~~

    private void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }
}