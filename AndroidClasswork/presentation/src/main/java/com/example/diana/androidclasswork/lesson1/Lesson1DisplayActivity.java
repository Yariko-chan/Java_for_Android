package com.example.diana.androidclasswork.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.diana.androidclasswork.R;


/**
 * Created by user on 26.07.2017.
 */
public class Lesson1DisplayActivity extends Activity {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_display_account);

        Intent intent = getIntent();
        TextView emailTV = (TextView) findViewById(R.id.emailTextView);
        TextView passwordTV = (TextView) findViewById(R.id.passwordTextView);
        emailTV.setText(intent.getStringExtra(EMAIL));
        passwordTV.setText(intent.getStringExtra(PASSWORD));
    }
}
