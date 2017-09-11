package com.example.diana.androidclasswork.lesson17;

import com.example.diana.androidclasswork.ThisApplication;

import javax.inject.Inject;

/**
 * Created by Diana on 11.09.2017.
 */

public class Ui {
    @Inject
    UseCase1 useCase1;

    public Ui() {
        ThisApplication.appComponent.inject(this);
        // this  string better to use in ui classes because Application class connected with ui
    }

    public void testUseCase1() {
        useCase1.getRestData();
    }
}
