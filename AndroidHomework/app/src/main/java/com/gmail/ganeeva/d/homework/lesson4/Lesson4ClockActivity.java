package com.gmail.ganeeva.d.homework.lesson4;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.gmail.ganeeva.d.homework.R;

public class Lesson4ClockActivity extends AppCompatActivity {
    private AnimationDrawable owlAnimation;
    private ImageView owlImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_clock);

        owlImage = (ImageView) findViewById(R.id.owl_image);
    }

    @Override
    protected void onResume() {
        super.onResume();
        owlAnimation = (AnimationDrawable) owlImage.getBackground();
        owlAnimation.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        owlAnimation.stop();
    }
}
