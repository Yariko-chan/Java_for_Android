package com.gmail.ganeeva.d.homework.lesson14.data.db_entity;

/**
 * Created by Diana on 04.09.2017.
 */

public class User {

    private int id;
    private String name;
    private int age;
    private Country country;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Country getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
