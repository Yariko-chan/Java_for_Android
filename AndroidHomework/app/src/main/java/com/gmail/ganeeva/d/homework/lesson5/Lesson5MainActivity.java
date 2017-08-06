package com.gmail.ganeeva.d.homework.lesson5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.ganeeva.d.homework.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.gmail.ganeeva.d.homework.lesson5.Lesson5Service.WIFI_STATE;
import static com.gmail.ganeeva.d.homework.lesson5.Lesson5Service.WIFI_STATE_ACTION;

public class Lesson5MainActivity extends AppCompatActivity {
    private static final String TAG = Lesson5Service.class.getSimpleName();
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_main);
        layout = (LinearLayout) findViewById(R.id.layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
        startService(new Intent(Lesson5MainActivity.this, Lesson5Service.class));

        IntentFilter filter = new IntentFilter();
        filter.addAction(WIFI_STATE_ACTION);
        registerReceiver(getMyActionReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
        stopService(new Intent(Lesson5MainActivity.this, Lesson5Service.class));
        unregisterReceiver(getMyActionReceiver);
    }

    private void addTextView(String message) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(
            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.TOP);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String log = sdf.format(new Date()) + " " + message;
        textView.setText(log);

        layout.addView(textView);
    }

    BroadcastReceiver getMyActionReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(WIFI_STATE_ACTION)) {
                addTextView(intent.getStringExtra(WIFI_STATE));
            }
        }
    };

}
