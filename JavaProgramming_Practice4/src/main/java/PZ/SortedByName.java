package PZ;

import java.util.Comparator;

/**
 * Created by Abashkin Alexandr on 28.11.2015.
 */
public class SortedByName implements Comparator<Student> {

    public int compare(Student obj1, Student obj2) {

        String str1 = obj1.getFirstName();
        String str2 = obj2.getFirstName();

        return str1.compareTo(str2);
    }
}

