package com.gmail.ganeeva.d.homework.lesson4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gmail.ganeeva.d.homework.R;

public class Lesson4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_main);

        Button magicButton = (Button) findViewById(R.id.magicButton);
        magicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson4MainActivity.this, Lesson4ClockActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.sensation,R.anim.disappering);
            }
        });

        Button regularButton = (Button) findViewById(R.id.regularButton);
        regularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson4MainActivity.this, Lesson4ClockActivity.class);
                startActivity(intent);
            }
        });
    }
}
