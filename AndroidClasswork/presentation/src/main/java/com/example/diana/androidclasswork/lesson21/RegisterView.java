package com.example.diana.androidclasswork.lesson21;

/**
 * Created by Diana on 19.09.2017.
 */

public interface RegisterView {

    public void showProgress();
    public void dismissProgress();
    public void showError(String text);
    public void goToMainActivity();
}
