package com.example.diana.androidclasswork.lesson17;

/**
 * Created by Diana on 11.09.2017.
 */

public class Rest {

    private Gson gson;
    private OkHttp okHttp;

    public Rest(Gson gson, OkHttp okHttp) {
        this.gson = gson;
        this.okHttp = okHttp;
    }
}
