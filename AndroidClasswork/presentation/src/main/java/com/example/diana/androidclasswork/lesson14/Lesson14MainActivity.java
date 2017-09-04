package com.example.diana.androidclasswork.lesson14;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.diana.androidclasswork.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Lesson14MainActivity extends AppCompatActivity {
    public static final String EDITTEXT_STRING_KEY = "EDITTEXT_STRING_KEY";
    @BindView(R.id.button) Button button;
    @BindView(R.id.editText) EditText editText;

    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "MySharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson14_main);

        ButterKnife.bind(this);

        // save text in edittext

        // getDir()//save little data here

        // getExternalCacheDir() // where to save data, like photos and music
        // may create assert directory in src/main of project.
        // Here are files for application. You can't put there inside app, but can read from there
        // also bd, shrifts here

        // shared pref - save to file, but simple interface
        // save by key
        // simpla data
        preferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        // able to have several shPrefs


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // thi  s may be in onResume
                String fromEditText = editText.getText().toString();
                if (fromEditText != null) {
                    preferences.edit().putString(EDITTEXT_STRING_KEY, fromEditText)
                            // here might be several savings
                            .apply(); // commit
                }
            }
        });

        if (preferences.contains(EDITTEXT_STRING_KEY)) {
            String s = preferences.getString(EDITTEXT_STRING_KEY, "no value");
            editText.setText(s);
        }
    }
}
