package com.example.diana.androidclasswork.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.diana.androidclasswork.R;


/**
 * Created by user on 24.07.2017.
 */
public class Lesson1MainActivity extends Activity implements View.OnClickListener{
    private static final String TAG = Lesson1MainActivity.class.getSimpleName();
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    private EditText emailField;
    private EditText passwordField;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_lesson1);

        Button okButton = (Button) findViewById(R.id.loginButton);
        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        okButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Lesson1MainActivity.this, Lesson1DisplayActivity.class);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        intent.putExtra(EMAIL, email);
        intent.putExtra(PASSWORD, password);
        startActivity(intent);
    }
}
