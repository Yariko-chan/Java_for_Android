package com.example.diana.androidclasswork.lesson9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diana.androidclasswork.R;
import com.example.diana.androidclasswork.base.BaseActivity;
import com.example.diana.androidclasswork.databinding.ActivityLesson9MainBinding;

public class Lesson9MainActivity extends BaseActivity {

    /**
     * method to open this activity from any other activity
     * @param activity
     */
    static void show(Activity activity) {
        Intent intent = new Intent(activity, Lesson9MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Lesson9ViewModel user = new Lesson9ViewModel();
        this.viewModel = user;

        ActivityLesson9MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson9_main);
        binding.setUser(user);

        super.onCreate(savedInstanceState);
    }
}
