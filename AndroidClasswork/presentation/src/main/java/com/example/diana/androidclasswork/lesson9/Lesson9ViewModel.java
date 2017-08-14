package com.example.diana.androidclasswork.lesson9;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.diana.androidclasswork.base.BaseViewModel;
import com.example.diana.androidclasswork.lesson8.Lesson8ViewModel;
import com.example.domain.entity.DomainProfile;
import com.example.domain.entity.ProfileId;
import com.example.domain.interactions.ProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Diana on 11.08.2017.
 */

public class Lesson9ViewModel implements BaseViewModel {
    private static final String TAG = Lesson8ViewModel.class.getSimpleName();
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

        useCase.execute(id, new DisposableObserver<DomainProfile>() { // subscribe for result information
            @Override
            public void onNext(@NonNull DomainProfile profile) { // if ok, result - profile
                name.set(profile.getName());
                surname.set(profile.getSurname());
                patronymic.set(profile.getPatronymic());
                age.set(profile.getAge());
                gender.set(profile.getGender());

                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) { // here handle errors
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void pause() {
        useCase.dispose();
    }
}
