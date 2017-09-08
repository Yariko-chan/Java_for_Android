package com.example.diana.androidclasswork;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Diana on 08.09.2017.
 */

public class ThisApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
