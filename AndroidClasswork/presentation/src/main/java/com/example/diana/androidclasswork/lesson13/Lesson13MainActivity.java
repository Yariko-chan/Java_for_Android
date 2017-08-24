package com.example.diana.androidclasswork.lesson13;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.diana.androidclasswork.R;

public class Lesson13MainActivity extends FragmentActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (null == savedInstanceState) { // if no fragment saved after pause or orientation change
            showFragment(getSupportFragmentManager(), Lesson13Fragment.newInstance(fragmentManager, "123"));
        }

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), Lesson13Fragment.newInstance(fragmentManager, "234"));
            }
        });


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fragmentManager, new Lesson13FragmentSecond());
            }
        });


    }

    private void showFragment(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // here pass animations
        fragmentTransaction.replace(R.id.conteiner_down, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
