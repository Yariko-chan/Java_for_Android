package com.example.diana.androidclasswork.lesson12;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.diana.androidclasswork.base.BaseViewModel;
import com.example.domain.entity.DomainProfile;
import com.example.domain.interactions.Lesson12GetProfilesUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Diana on 18.08.2017.
 */

public class Lesson12ViewModel implements BaseViewModel{

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Lesson12GetProfilesUseCase profilesUseCase = new Lesson12GetProfilesUseCase();

    private Activity activity;

    public Lesson12ViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        profilesUseCase.execute(null, new DisposableObserver<List<? extends DomainProfile>>(){

            @Override
            public void onNext(List<? extends DomainProfile> profileModels) {

                Log.e("AAAA items = " + profileModels.size(), "");
                state.set(STATE.DATA);

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void pause() {

    }
}
