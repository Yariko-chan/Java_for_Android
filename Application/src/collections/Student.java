package collections;

import java.util.HashMap;

/**
 * Created by user on 14.06.2017.
 */
public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private boolean gender;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Student s) {
        return this.getName().compareTo(s.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();

        map.put("en", new Student("Andrew", 20));
        map.put("ru", new Student("Sergei", 19));
        map.put("by", new Student("Ruslana", 21));

        for (String s: map.keySet() /* array of keys */) {
            System.out.println(s + " " + map.get(s).getName() + " " + map.get(s).getAge());
        }
    }
}
