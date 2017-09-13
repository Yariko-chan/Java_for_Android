package com.example.diana.androidclasswork.lesson18;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.diana.androidclasswork.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Lesson18MainActivity extends AppCompatActivity {
    @BindView(R.id.button1) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.grayView) View grayView;
    @BindView(R.id.root) View rootView;
    @BindView(R.id.toolBar) Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson18_main);
        ButterKnife.bind(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.setZ(button2, 50000);
                ViewCompat.setZ(grayView, 40000);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.setZ(button1, 50000);
                ViewCompat.setZ(grayView, 40000);
            }
        });

        // ------------------------------------------

        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
//        toolBar.setNavigationOnClickListener();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lesson18_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
