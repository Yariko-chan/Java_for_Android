package com.gmail.ganeeva.d.homework.lesson11.presentation;

import com.gmail.ganeeva.d.homework.lesson11.domain.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.domain.interactions.GetProfilesUseCase;
import com.gmail.ganeeva.d.homework.lesson11.presentation.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Diana on 19.08.2017 at 15:17.
 */

public class Lesson11ViewModel implements BaseViewModel {
//    public List<DomainProfile> profilesList = new ArrayList<>();
    public Lesson11ProfilesListAdapter<Lesson11ItemHolder> adapter = new Lesson11ProfilesListAdapter<>();

    public enum STATE{VOID, GOT}
    public STATE state = STATE.VOID;

    private GetProfilesUseCase useCase = new GetProfilesUseCase();


    @Override
    public void init() {
        useCase.execute("", new DisposableObserver<List<DomainProfile>>() {
            @Override
            public void onNext(@NonNull List<DomainProfile> domainProfiles) {
//                profilesList = domainProfiles;
                state = STATE.GOT;
                adapter.setItems(domainProfiles);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void release() {

    }
}
