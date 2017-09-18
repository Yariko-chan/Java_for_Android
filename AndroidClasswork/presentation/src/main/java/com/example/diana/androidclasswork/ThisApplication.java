package com.example.diana.androidclasswork;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.diana.androidclasswork.di.AppComponent;
import com.example.diana.androidclasswork.di.AppModule;
import com.example.diana.androidclasswork.di.DaggerAppComponent;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;

/**
 * Created by Diana on 08.09.2017.
 */

public class ThisApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        Realm.init(this);
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }
}
