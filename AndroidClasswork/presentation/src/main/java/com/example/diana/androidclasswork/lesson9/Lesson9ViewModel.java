package com.example.diana.androidclasswork.lesson9;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.example.diana.androidclasswork.base.BaseViewModel;
import com.example.domain.entity.Profile;
import com.example.domain.entity.ProfileId;
import com.example.domain.interactions.ProfileUseCase;

/**
 * Created by Diana on 11.08.2017.
 */

public class Lesson9ViewModel implements BaseViewModel {
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> patronymic = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableBoolean gender = new ObservableBoolean();

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private ProfileUseCase useCase = new ProfileUseCase();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        ProfileId id = new ProfileId();
        id.setId("123");

        Profile profile = useCase.execute(id);

        name.set(profile.getName());
        surname.set(profile.getSurname());
        patronymic.set(profile.getPatronymic());
        age.set(profile.getAge());
        gender.set(profile.getGender());

        state.set(STATE.DATA);
    }

    @Override
    public void pause() {

    }
}
