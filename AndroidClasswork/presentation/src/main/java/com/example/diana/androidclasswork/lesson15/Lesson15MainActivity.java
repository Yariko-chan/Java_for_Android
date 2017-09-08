package com.example.diana.androidclasswork.lesson15;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diana.androidclasswork.R;
import com.example.diana.androidclasswork.base.BaseActivity;
import com.example.diana.androidclasswork.databinding.ActivityLesson15MainBinding;

public class Lesson15MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lesson15ViewModel viewModel = new Lesson15ViewModel(this);
        this.viewModel = viewModel;
        ActivityLesson15MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson15_main);
        binding.setViewModel(viewModel);
    }
}
