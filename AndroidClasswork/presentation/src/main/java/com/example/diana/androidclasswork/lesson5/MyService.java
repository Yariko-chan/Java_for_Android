package com.example.diana.androidclasswork.lesson5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Diana on 02.08.2017.
 */

public class MyService extends Service {
    public static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        // You must always implement this method;
        // however, if you don't want to allow binding, you should return null.

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
        // on every startservice (there may by several starts for single service)
        // one service one time
        // but there are may be several different intents in startservice

        // it is your responsibility to stop the service when its work is complete
        // by calling stopSelf() or stopService().
        // If you only want to provide binding, you don't need to implement this method.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // implement this to clean up any resources
        // such as threads, registered listeners, or receivers.
        // This is the last call that the service receives.
    }
}
