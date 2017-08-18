package com.gmail.ganeeva.d.homework.lesson9.domain;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Diana on 11.08.2017.
 */

public abstract class UseCase<InParam, OutParam> {

    public OutParam execute(InParam param) {
        return buildUseCase(param);
    }

    public abstract OutParam buildUseCase(InParam param);
}
