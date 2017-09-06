package com.gmail.ganeeva.d.homework.lesson14.domain.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 05.09.2017 at 12:20.
 */

public class Country {
    @SerializedName("name") private String name;
    @SerializedName("code") private String code;

    public Country(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
