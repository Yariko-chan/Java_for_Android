package com.gmail.ganeeva.d.homework.main;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Diana on 31.07.2017 at 12:41.
 */

public class HomeworkApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
