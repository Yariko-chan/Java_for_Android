package com.gmail.ganeeva.d.homework.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.lesson1.Lesson1MainActivity;
import com.gmail.ganeeva.d.homework.lesson2.Lesson2MainActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);

        addButton(1, Lesson1MainActivity.class);
        addButton(2, Lesson2MainActivity.class);
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
