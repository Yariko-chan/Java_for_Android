package com.gmail.ganeeva.d.homework.lesson11.presentation.profile_details;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson11ProfileBinding;
import com.gmail.ganeeva.d.homework.lesson11.presentation.ClickHandler;
import com.gmail.ganeeva.d.homework.lesson11.presentation.base.BaseActivity;

public class Lesson11ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String id = getIntent().getStringExtra("ID");
        Lesson11ProfileViewModel viewModel = new Lesson11ProfileViewModel(id);

        setViewModel(viewModel);

        ActivityLesson11ProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson11_profile);
        binding.setProfile(viewModel);
        binding.setHandler(new ClickHandler(Lesson11ProfileActivity.this));

        super.onCreate(savedInstanceState);
    }
}
