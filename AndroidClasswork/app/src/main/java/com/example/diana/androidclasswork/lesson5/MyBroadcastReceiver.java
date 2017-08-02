package com.example.diana.androidclasswork.lesson5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * Created by Diana on 02.08.2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = MyBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        // here all events arrive
        Log.d(TAG, "onReceive");

        // here can't be doune any hard works. here should services or others be invoked and then onReceived closes
        // because this works in UI thread

        // here can be notifications invoked

    }
}
