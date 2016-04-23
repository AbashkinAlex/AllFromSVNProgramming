import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class Group implements Serializable {
    @SerializedName("Groups name")
    private String name;
    static List<Student> studentList = new ArrayList<Student>();

    public Group(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public static boolean addStudent(Student student){
        return studentList.add(student);
    }
    public static String printStudent(){
        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
             sb.append(student.toString());
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                "Students= " + printStudent() + "}";
    }
}
