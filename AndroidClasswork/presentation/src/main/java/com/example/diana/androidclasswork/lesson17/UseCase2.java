package com.example.diana.androidclasswork.lesson17;

/**
 * Created by Diana on 11.09.2017.
 */

public class UseCase2 {

    private Rest rest;

    public UseCase2() {
        rest = new Rest(new Gson(), new OkHttp());
    }

    public String getRestData() {
        return "UseCase2 restdata";
    }
}
