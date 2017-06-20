package Lesson13;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Diana on 19.06.2017.
 */
public class People {
    private long id;
    private String name;
    private String surname;
    private long age;

    @JsonProperty("is_degree")
    private boolean isDegree;

    public People() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", isDegree=" + isDegree +
                '}';
    }
}
