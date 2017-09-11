package com.example.diana.androidclasswork.lesson17;

/**
 * Created by Diana on 11.09.2017.
 */

public class UseCase1 {

    private Rest rest;
    private SharedPrefs prefs;

    public UseCase1(Rest rest, SharedPrefs prefs) {
        this.rest = rest;
        this.prefs = prefs;
    }

    public String getRestData() {
        return "UseCase1 restdata";
    }
}
