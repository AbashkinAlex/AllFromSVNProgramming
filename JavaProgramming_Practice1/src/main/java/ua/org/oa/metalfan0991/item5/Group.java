package ua.org.oa.metalfan0991.item5;

/**
 * Created by Abashkin Alexandr on 3/12/2016.
 */
public class Group {
    private String name;
    private String course;
    private String department;

    public Group(String name, String course, String department) {
        setName(name);
        setCourse(course);
        setDepartment(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
