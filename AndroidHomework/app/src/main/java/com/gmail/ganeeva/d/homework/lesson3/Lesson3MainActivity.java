package com.gmail.ganeeva.d.homework.lesson3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.request.RequestOptions;
import com.gmail.ganeeva.d.homework.BuildConfig;
import com.gmail.ganeeva.d.homework.R;

public class Lesson3MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText urlEditText;
    private Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        urlEditText = (EditText) findViewById(R.id.url);
        downloadButton = (Button) findViewById(R.id.downloadButton);

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();
                Glide.with(Lesson3MainActivity.this)
                    .load(url)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageView);
            }
        });

        TextView buildConfigVarTV = (TextView) findViewById(R.id.buildConfigVarTextView);
        buildConfigVarTV.setText(BuildConfig.API_ENDPOINT);
    }
}
