package com.gmail.ganeeva.d.homework.lesson11.presentation.base;

/**
 * Created by Diana on 19.08.2017 at 14:18.
 */

public interface BaseViewModel {

    public void init();
    public void resume();
    public void pause();
    public void release(); // destroy
}
