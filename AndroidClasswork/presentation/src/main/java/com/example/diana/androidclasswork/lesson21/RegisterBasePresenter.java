package com.example.diana.androidclasswork.lesson21;

/**
 * Created by Diana on 19.09.2017.
 */

public interface RegisterBasePresenter {

    public void init();
    public void resume();
    public void pause();
    public void release();

    public void onRegisterButtonClick(String username, String password);
}
