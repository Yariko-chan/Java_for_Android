package com.gmail.ganeeva.d.homework.lesson11.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 18.08.2017 at 15:32.
 */

public class DataProfile {
    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
}
