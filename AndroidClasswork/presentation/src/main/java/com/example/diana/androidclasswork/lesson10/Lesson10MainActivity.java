package com.example.diana.androidclasswork.lesson10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.diana.androidclasswork.R;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Lesson10MainActivity extends AppCompatActivity {
    private static final String TAG = Lesson10MainActivity.class.getSimpleName();

    // subject is obesravble and at the same time disposablle

    public PublishSubject<String> publishSubject = PublishSubject.create(); // sends to observators events after subscribing
    public BehaviorSubject<String> behaviorSubject = BehaviorSubject.create(); // saves history, saves to cash one object and sets it to observators
    public ReplaySubject<String> replaySubject = ReplaySubject.create(); // saves all the history, send all history to observators

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10_main);

        // ones send data, others get data by observable interface

        replaySubject.onNext("One");
        replaySubject.onNext("Two");
        replaySubject.onNext("Three");
        replaySubject.onNext("Four");
        replaySubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        replaySubject.onNext("Five");
        replaySubject.onNext("Six");
        replaySubject.onNext("Seven");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
