package PZ;

/**
 * Created by Abashkin Alexandr on 28.11.2015.
 */
public class Student {
    String firstName;
    String lastName;
    int course;

    public Student(String firstName, String lastName, int course) {
        setFirstName(firstName);
        setLastName(lastName);
        setCourse(course);

    }

    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + course  ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (course != student.course) return false;
        if (!firstName.equals(student.firstName)) return false;
        return lastName.equals(student.lastName);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + course;
        return result;
    }
}
