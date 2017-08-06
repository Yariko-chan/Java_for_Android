package com.gmail.ganeeva.d.homework.lesson5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Diana on 06.08.2017 at 19:49.
 */

public class Lesson5Service extends Service {
    private static final String TAG = Lesson5Service.class.getSimpleName();
    public static final String WIFI_STATE_ACTION = "com.gmail.ganeeva.d.homework.lesson5.Lesson5Service.WIFI_STATE_ACTION";
    public static final String WIFI_STATE = "WIFI_STATE";

    public Lesson5Service() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "Service started");

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(getWifiStateReceiver, filter);
        Log.d(TAG, "BroadcastReceiver registered");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Service destroyed");

        unregisterReceiver(getWifiStateReceiver);
        Log.d(TAG, "BroadcastReceiver unregistered");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    BroadcastReceiver getWifiStateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
                NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                Log.d(TAG, "wifiState = " + info.getState());

                Intent i = new Intent(WIFI_STATE_ACTION);
                i.putExtra(WIFI_STATE, info.getState().toString());
                sendBroadcast(i);
            }

        }
    };
}
