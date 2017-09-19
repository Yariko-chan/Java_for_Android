package com.example.diana.androidclasswork.lesson21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.diana.androidclasswork.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Lesson21MainActivity extends AppCompatActivity implements RegisterView{
    @BindView(R.id.buttonRegister) Button buttonRegister;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    private RegisterBasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson21_main);
        ButterKnife.bind(this);

        presenter = new RegisterPresenter(this);
        presenter.init();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegisterButtonClick("username", "password");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.release();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToMainActivity() {

    }
}
