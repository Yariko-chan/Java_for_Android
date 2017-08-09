package com.example.diana.androidclasswork.lesson8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diana.androidclasswork.R;
import com.example.diana.androidclasswork.base.BaseActivity;
import com.example.diana.androidclasswork.databinding.ActivityLesson8MainBinding;

public class Lesson8MainActivity extends BaseActivity {


    /**
     * method to open this activity from any other activity
     * @param activity
     */
    static void show(Activity activity) {
        Intent intent = new Intent(activity, Lesson8MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Lesson8ViewModel viewModel = new Lesson8ViewModel(this); // general object for use here with parent methods and in model
        this.viewModel = viewModel; // general object to parent class field for use here with parent methods

        ActivityLesson8MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson8_main);
        binding.setViewModel(viewModel); // general object to xml(view)

        super.onCreate(savedInstanceState); // at the end because in superclass onCreate viewModel used
    }
}
