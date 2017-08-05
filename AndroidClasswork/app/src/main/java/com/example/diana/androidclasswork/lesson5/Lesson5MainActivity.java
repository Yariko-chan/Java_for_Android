package com.example.diana.androidclasswork.lesson5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diana.androidclasswork.R;

public class Lesson5MainActivity extends AppCompatActivity {
    public static final String TAG = Lesson5MainActivity.class.getSimpleName();

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_main);

        tv = (TextView) findViewById(R.id.textView);

        startService(new Intent(this, MyService.class)); // as an activity
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(Lesson5MainActivity.this, MyService.class));
            }
        });

        ////////////////
        // Должно выполняться по очереди с разницей в 5 сек
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACTION, "Task 0");
        startService(intent);

        Intent intent1 = new Intent(this, MyIntentService.class);
        intent1.putExtra(MyIntentService.KEY_ACTION, "Task 1");
        startService(intent1);

        Intent intent2 = new Intent(this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION, "Task 2");
        startService(intent2);

    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        //filter.addAction(MyIntentService.MY_ACTION); // my own event in global BR

        registerReceiver(receiver, filter);

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, BIND_AUTO_CREATE); // flags - how to launch service depending on launched already or not
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);

        unbindService(conn);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected");
        }
    };

    // в онстарт подписаться, в онстоп отписаться, иначе утечка памяти
    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive");

            tv.setText("onReceive");

//            if (intent.getAction().equals())

            Bundle extras = intent.getExtras();

            NetworkInfo info = (NetworkInfo) extras
                    .getParcelable("networkInfo");

            NetworkInfo.State state = info.getState();
            Log.d("TEST Internet", info.toString() + " "
                    + state.toString());

            if (state == NetworkInfo.State.CONNECTED) {
                Toast.makeText(getApplicationContext(), "Internet connection is on", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getApplicationContext(), "Internet connection is Off", Toast.LENGTH_LONG).show();
            }

            // here alsp MY_ACTION events received, catch them with if (intent.getAction().equals())
        }

        // the most common use because it's able now to access fields
    };
}
