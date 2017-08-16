package com.example.diana.androidclasswork.lesson10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.diana.androidclasswork.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Lesson10MainActivity extends AppCompatActivity {
    private static final String TAG = Lesson10MainActivity.class.getSimpleName();

    // subject is obesravble and at the same time disposablle

    public PublishSubject<String> publishSubject = PublishSubject.create(); // sends to observators events after subscribing
    public BehaviorSubject<String> behaviorSubject = BehaviorSubject.create(); // saves to cash one object and sets it to observators
    public ReplaySubject<String> replaySubject = ReplaySubject.create(); // saves all the history, send all history to observators

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10_main);

        // ones send data, others get data by observable interface

//        classwork();
        testObservables();
    }

    private void testObservables() {
        Observable<String> values = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("one");
                e.onNext("two");
                e.onError(new Exception("Error"));
                e.onNext("two");
                e.onComplete();
            }
        });
        Disposable disposable = values.subscribeWith(
            new DisposableObserver<String>() {
                @Override
                public void onNext(@NonNull String s) {
                    Log.d(TAG, "Received: " + s);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.e(TAG, "Error: " + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "Completed");
                }
            }
        );
    }

    private void classwork() {
        replaySubject.onNext("One");
        replaySubject.onNext("Two");
        replaySubject.onNext("Three");
        replaySubject.onNext("Four");
        replaySubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
        Disposable disposable = replaySubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Done");
            }
        });
        replaySubject.onNext("Five");
        replaySubject.onComplete();
        replaySubject.onNext("Six");
        disposable.dispose();
        replaySubject.onNext("Seven");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
