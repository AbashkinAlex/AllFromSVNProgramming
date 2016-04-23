package Task2.model;

/**
 * Created by Администратор on 09.03.2016.
 */
public class Student {

    private int id;
    private String name;
    private String surname;
    private String enrolment_date;
    private int MyGroup_id;

    public Student() {
    }

    public Student(int id, String name, String surname, String enrolment_date, int myGroup_id) {
        setId(id);
        setName(name);
        setSurname(surname);
        setEnrolment_date(enrolment_date);
        setMyGroup_id(myGroup_id);
    }

    public Student(String name, String surname, String enrolment_date, int myGroup_id) {

        setName(name);
        setSurname(surname);
        setEnrolment_date(enrolment_date);
        setMyGroup_id(myGroup_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEnrolment_date() {
        return enrolment_date;
    }

    public void setEnrolment_date(String enrolment_date) {
        this.enrolment_date = enrolment_date;
    }

    public int getMyGroup_id() {
        return MyGroup_id;
    }

    public void setMyGroup_id(int myGroup_id) {
        MyGroup_id = myGroup_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", enrolment_date='" + enrolment_date + '\'' +
                ", MyGroup_id=" + MyGroup_id +
                '}';
    }
}
