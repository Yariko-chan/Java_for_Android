package com.gmail.ganeeva.d.homework.lesson10;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson10MainBinding;

public class Lesson10MainActivity extends AppCompatActivity {
    Lesson10ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new Lesson10ViewModel();

        ActivityLesson10MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson10_main);
        binding.setModel(viewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }
}
