package Task2.model;

/**
 * Created by Администратор on 10.03.2016.
 */
public class MyGroup {
    private int id;
    private int number;
    private String department;

    public MyGroup(){

    }

    public MyGroup(int number, String department) {
        setNumber(number);
        setDepartment(department);
    }

    public MyGroup(int id, int number, String department) {
        setId(id);
        setNumber(number);
        setDepartment(department);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "MyGroup{" +
                "id=" + id +
                ", number=" + number +
                ", department='" + department + '\'' +
                '}';
    }
}
