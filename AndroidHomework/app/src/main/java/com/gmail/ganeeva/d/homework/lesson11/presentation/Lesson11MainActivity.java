package com.gmail.ganeeva.d.homework.lesson11.presentation;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson11MainBinding;
import com.gmail.ganeeva.d.homework.lesson11.presentation.base.BaseActivity;

public class Lesson11MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityLesson11MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson11_main);

        Lesson11ViewModel viewModel = new Lesson11ViewModel();
        this.setViewModel(viewModel);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);
    }
}
