package com.example.diana.androidclasswork.lesson12;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.diana.androidclasswork.R;
import com.example.diana.androidclasswork.base.BaseActivity;
import com.example.diana.androidclasswork.databinding.ActivityLesson12MainBinding;

public class Lesson12MainActivity extends  BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Lesson12ViewModel model = new Lesson12ViewModel(this);
        this.viewModel = model;

        ActivityLesson12MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson12_main);
        binding.setModel(model);
        binding.recyclerView.setAdapter(model.adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //adapter
        //layoutmanager

        super.onCreate(savedInstanceState);
    }
}
