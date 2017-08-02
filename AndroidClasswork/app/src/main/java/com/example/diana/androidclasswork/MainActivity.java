package com.example.diana.androidclasswork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.diana.androidclasswork.lesson1.Lesson1MainActivity;
import com.example.diana.androidclasswork.lesson3.Lesson3MainActivity;
import com.example.diana.androidclasswork.lesson4.Lesson4MainActivity;
import com.example.diana.androidclasswork.lesson5.Lesson5MainActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);

        addButton(1, Lesson1MainActivity.class);
        addButton(3, Lesson3MainActivity.class);
        addButton(4, Lesson4MainActivity.class);
        addButton(5, Lesson5MainActivity.class);
    }

    private void addButton(int number, final Class mainActivity) {
        Button hw1Button = new Button(this);
        hw1Button.setText("Homework " + number);
        hw1Button.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        hw1Button.setGravity(Gravity.TOP);

        hw1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mainActivity);
                startActivity(intent);
            }
        });
        layout.addView(hw1Button);
    }

}
