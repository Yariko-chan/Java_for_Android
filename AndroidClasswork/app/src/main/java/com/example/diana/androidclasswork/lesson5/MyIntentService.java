package com.example.diana.androidclasswork.lesson5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by Diana on 02.08.2017.
 */

public class MyIntentService extends IntentService {
    public static final String TAG = MyIntentService.class.getSimpleName();

    public static final String KEY_ACTION = "KEY_ACTION";
    public static final String MY_ACTION = "com.example.diana.androidclasswork.lesson5.MY_ACTION"; // name of event in BR

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getStringExtra(KEY_ACTION);

//        Log.d(TAG, "onHandleIntent " + action);

        // generate message to BR and catch it in Interface
        Intent intent1 = new Intent(MY_ACTION); // equals to setAction, but shorter
        sendBroadcast(intent1); // uses global BR, which used among all apps in system

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // local broadcast for your own app
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        // register unegister the same, all work the same
    }

}
