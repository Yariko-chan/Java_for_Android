package com.example.diana.androidclasswork.lesson7;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diana.androidclasswork.R;
import com.example.diana.androidclasswork.databinding.ActivityLesson7MainBinding;

public class Lesson7MainActivity extends AppCompatActivity {
    public ObservableField<String> myText = new ObservableField<>("Some text");

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this class is part of xml for binding
        ActivityLesson7MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson7_main);
        binding.setActivity(this); // setter for activity var in xml
//        binding.textView.setText("");// but unneccessary
    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    final int a = i;
                    try {
                        Thread.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myText.set("Something " + a);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }
}
