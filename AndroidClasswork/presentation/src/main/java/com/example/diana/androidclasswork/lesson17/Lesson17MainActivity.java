package com.example.diana.androidclasswork.lesson17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diana.androidclasswork.R;

public class Lesson17MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson17_main);

        Ui ui = new Ui();
        ui.testUseCase1();
    }
}
