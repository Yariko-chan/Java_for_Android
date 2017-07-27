package com.gmail.ganeeva.d.homework.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.ganeeva.d.homework.R;

public class Lesson1MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView upperTv;
    private TextView downTV;
    private Button exchButton;

    private View.OnClickListener exchanger = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String upper = upperTv.getText().toString();
            String down = downTV.getText().toString();
            upperTv.setText(down);
            downTV.setText(upper);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_main);

        upperTv = (TextView) findViewById(R.id.upperTextview);
        downTV = (TextView) findViewById(R.id.downTextview);
        exchButton = (Button) findViewById(R.id.exchangeButton);
        upperTv.setOnClickListener(this);
        downTV.setOnClickListener(exchanger);
        exchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upper = upperTv.getText().toString();
                String down = downTV.getText().toString();
                upperTv.setText(down);
                downTV.setText(upper);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String upper = upperTv.getText().toString();
        String down = downTV.getText().toString();
        upperTv.setText(down);
        downTV.setText(upper);
    }
}
