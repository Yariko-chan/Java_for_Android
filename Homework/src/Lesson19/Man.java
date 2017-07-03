package Lesson19;

/**
 * Created by user on 30.06.2017.
 */
public class Man {
    private String name;
    private int age;
    private boolean gender; // true = male

    public Man(String name) {
        this.name = name;
    }

    public Man(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
