import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class Student implements Serializable {
    @SerializedName("Students name")
    private String name;
    private int age;
    private Group group;
    public Student(String name, int age , Group group) {
        setName(name);
        setAge(age);
        group.addStudent(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
