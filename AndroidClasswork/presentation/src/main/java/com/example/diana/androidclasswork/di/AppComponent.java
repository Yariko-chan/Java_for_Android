package com.example.diana.androidclasswork.di;

import com.example.diana.androidclasswork.lesson17.Ui;
import com.example.diana.androidclasswork.lesson21.RegisterPresenter;
import com.example.diana.androidclasswork.lesson9.Lesson9ViewModel;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Diana on 11.09.2017.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    // connect dagger and your classes
    // all classes where you want to use dagger

    public void inject(Ui ui);

    public void inject(Lesson9ViewModel model);

    public void inject(RegisterPresenter registerPresenter);
}
