package com.gmail.ganeeva.d.homework.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.lesson1.Lesson1MainActivity;
import com.gmail.ganeeva.d.homework.lesson11.presentation.profiles_list.Lesson11MainActivity;
import com.gmail.ganeeva.d.homework.lesson2.Lesson2MainActivity;
import com.gmail.ganeeva.d.homework.lesson3.Lesson3MainActivity;
import com.gmail.ganeeva.d.homework.lesson4.Lesson4MainActivity;
import com.gmail.ganeeva.d.homework.lesson5.Lesson5MainActivity;
import com.gmail.ganeeva.d.homework.lesson6.Lesson6MainActivity;
import com.gmail.ganeeva.d.homework.lesson7.Lesson7MainActivity;
import com.gmail.ganeeva.d.homework.lesson10.Lesson10MainActivity;
import com.gmail.ganeeva.d.homework.lesson9.presentation.Lesson9MainActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);

        addButton(1, Lesson1MainActivity.class);
        addButton(2, Lesson2MainActivity.class);
        addButton(3, Lesson3MainActivity.class);
        addButton(4, Lesson4MainActivity.class);
        addButton(5, Lesson5MainActivity.class);
        addButton(6, Lesson6MainActivity.class);
        addButton(7, Lesson7MainActivity.class);
        addButton(9, Lesson9MainActivity.class);
        addButton(10, Lesson10MainActivity.class);
        addButton(11, Lesson11MainActivity.class);
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
