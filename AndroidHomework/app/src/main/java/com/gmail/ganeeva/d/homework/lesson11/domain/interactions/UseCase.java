package com.gmail.ganeeva.d.homework.lesson11.domain.interactions;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Diana on 11.08.2017.
 */

public abstract class UseCase<InParam, OutParam> {

    private Disposable disposable;

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) { // subscribes @disposableObserver to result of buildUseCase (Observable), disposable neeeded to insubscribe later
        disposable = buildUseCase(param) // will form Observable, but not implemented until someone subscribed to it
                .observeOn(AndroidSchedulers.mainThread()) // в каком потоке ждём результат here answer (on interface) handled, implemented in main thread
                .subscribeOn(Schedulers.newThread()) // в каком потоке выполняется сам код here code(from buildUseCase) implemented, other thread
                .subscribeWith(disposableObserver); // забирает результат
        // DisposableObserver - interface
        //  here it subscribes to result of buildUseCase()
}

    public abstract Observable<OutParam> buildUseCase(InParam param); // gets data from Data layer

    public void dispose() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
