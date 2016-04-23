package ua.org.oa.metalfan0991;

/**
 * Created by Aleksandr Abashkin on 12/6/2015.
 */
public class App {
    public static void main(String[] args) throws UnresolvedDayOfWeekIndex {
        Date date1= new Date(2015,12,6);
        Date date2= new Date(2016,12,6);

        System.out.println("В указанной дате, день недели : " + date1.getDayOfWeek()+".");

        System.out.println("Между указанными датами " + date1.daysBetween(date2) + " день(-ей).");

    }
}
