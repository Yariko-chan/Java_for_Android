package com.example.diana.androidclasswork.lesson19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.diana.androidclasswork.BuildConfig;
import com.example.diana.androidclasswork.R;

public class Lesson19MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson19_main);

        Log.d("", BuildConfig.API_REST);
    }
}
