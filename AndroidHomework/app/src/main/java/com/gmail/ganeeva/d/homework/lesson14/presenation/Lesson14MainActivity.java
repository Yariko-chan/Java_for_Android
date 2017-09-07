package com.gmail.ganeeva.d.homework.lesson14.presenation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson14MainBinding;
import com.gmail.ganeeva.d.homework.base.BaseActivity;

public class Lesson14MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Lesson14ViewModel viewModel = new Lesson14ViewModel(this);
        this.setViewModel(viewModel);
        ActivityLesson14MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson14_main);
        binding.setViewModel(viewModel);
        binding.spinner.setAdapter(viewModel.adapter);
        binding.spinner.setOnItemSelectedListener(viewModel);
        binding.spinner.setSelection(viewModel.countryListSelectedPosition);
        super.onCreate(savedInstanceState);
    }
}
