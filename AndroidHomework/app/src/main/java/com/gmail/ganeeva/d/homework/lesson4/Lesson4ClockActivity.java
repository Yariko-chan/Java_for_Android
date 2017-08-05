package com.gmail.ganeeva.d.homework.lesson4;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.gmail.ganeeva.d.homework.R;

public class Lesson4ClockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_clock);

        ImageView owlImage = (ImageView) findViewById(R.id.owl_image);
        AnimationDrawable owlAnimation = (AnimationDrawable) owlImage.getBackground();
        owlAnimation.start();
    }
}