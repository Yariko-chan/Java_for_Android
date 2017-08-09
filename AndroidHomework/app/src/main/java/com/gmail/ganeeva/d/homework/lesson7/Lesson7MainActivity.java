package com.gmail.ganeeva.d.homework.lesson7;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson7MainBinding;

public class Lesson7MainActivity extends AppCompatActivity {
    public Lesson7User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createRandomUser();

        ActivityLesson7MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson7_main);
        binding.setUser(user);
    }

    private void createRandomUser() {
        user = new Lesson7User("Oleh", 30, true);
        user.surname = "Alexeev";
        user.patronymic = "Sergeyevich";
        user.imageUrl = "http://img10.deviantart.net/32d6/i/2015/109/0/5/random_man_by_taeef-d6swsj3.jpg";
    }

}
