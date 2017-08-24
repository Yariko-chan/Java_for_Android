package com.gmail.ganeeva.d.homework.lesson13;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson7MainBinding;
import com.gmail.ganeeva.d.homework.databinding.FragmentLesson13Binding;
import com.gmail.ganeeva.d.homework.lesson7.Lesson7User;

public class Lesson13MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        showFragment(getSupportFragmentManager(), Lesson13Fragment.newInstance());
    }

    private void showFragment(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // here pass animations
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
