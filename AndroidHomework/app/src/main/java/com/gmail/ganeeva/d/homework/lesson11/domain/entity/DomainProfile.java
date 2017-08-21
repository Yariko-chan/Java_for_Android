package com.gmail.ganeeva.d.homework.lesson11.domain.entity;

/**
 * Created by Diana on 18.08.2017 at 15:56.
 */

public class DomainProfile {
    private String name;
    private String surname;
    private int age;
    private DomainProfileId id = new DomainProfileId("");

    public DomainProfileId getId() {
        return id;
    }

    public void setId(String id) {
        this.id.setString(id);
    }

    public void setId(DomainProfileId id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
