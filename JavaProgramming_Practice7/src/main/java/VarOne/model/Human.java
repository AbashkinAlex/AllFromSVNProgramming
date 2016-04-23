package VarOne.model;

/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class Human {
    private int id;
    private String name;
    private int age;
    public Human(){
    }
    public Human(String name, int age){
        setName(name);
        setAge(age);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
