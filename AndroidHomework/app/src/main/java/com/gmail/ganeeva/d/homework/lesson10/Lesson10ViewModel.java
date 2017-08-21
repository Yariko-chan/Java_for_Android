package com.gmail.ganeeva.d.homework.lesson10;

import android.databinding.ObservableField;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;

public class Lesson10ViewModel {
    private Disposable disposable;

    public ObservableField<String> text = new ObservableField<>("default");

    public void resume() {

        disposable = Observable.interval(1, TimeUnit.SECONDS)
            .filter(new Predicate<Long>() {
                @Override
                public boolean test(@NonNull Long aLong) throws Exception {
                    return aLong %2 == 0;
                }
            })
            .map(new Function<Long, String>() {
                @Override
                public String apply(@NonNull Long l) throws Exception {
                    return String.valueOf(l);
                }
            })
            .subscribeWith(new DisposableObserver<String>() {
                @Override
                public void onNext(@NonNull String s) {
                    text.set(s);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    text.set(e.getMessage());
                }

                @Override
                public void onComplete() {
                    text.set("completed");
                }
            });
    }

    public void pause() {
        if (!disposable.isDisposed()) disposable.dispose();
    }

}
