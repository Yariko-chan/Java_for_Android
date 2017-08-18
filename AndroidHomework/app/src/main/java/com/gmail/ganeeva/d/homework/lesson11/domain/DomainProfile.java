package com.gmail.ganeeva.d.homework.lesson11.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 18.08.2017 at 15:56.
 */

public class DomainProfile {
    private String name;
    private String surname;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
