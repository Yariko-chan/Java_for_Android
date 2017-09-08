package com.example.diana.androidclasswork.lesson15;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.example.diana.androidclasswork.base.BaseViewModel;
import com.example.domain.entity.Lesson15Frankenstein;
import com.example.domain.entity.User;
import com.example.domain.interactions.SaveUserUseCase;

/**
 * Created by Diana on 06.09.2017.
 */

public class Lesson15ViewModel implements BaseViewModel{
    private ObservableField<String> userName = new ObservableField<>();
    private ObservableInt userAge = new ObservableInt();
    private ObservableField<String> countryName = new ObservableField<>();
    private Context context;

    public Lesson15ViewModel(Context context) {
        this.context = context;
    }

    @Override
    public void init() {
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        SaveUserUseCase useCase = new SaveUserUseCase();
        User user = new User();
        user.setName(userName.get());
        user.setAge(userAge.get());
        Lesson15Frankenstein franky = new Lesson15Frankenstein(context, user);
//        useCase.execute();
    }
}
