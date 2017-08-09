package com.example.diana.androidclasswork.lesson8;

import android.app.Activity;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.example.diana.androidclasswork.base.BaseViewModel;

/**
 * Created by Diana on 09.08.2017.
 */

public class Lesson8ViewModel implements BaseViewModel {
    private Activity activity; // givs lot of opportunities (resourses, work with intent, etc

    private static final String TAG = Lesson8ViewModel.class.getSimpleName();
    public ObservableField<String> stringField = new ObservableField<>("Some text");

    public Lesson8ViewModel(Activity activity) {
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

    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick() {
        Log.d(TAG, "Click");
    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, String> {
        // to start create new Instance then .start on it

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // before doInBack
            // first after start

            // here can be progressBar implemented
        }

        @Override
        protected void onProgressUpdate(Integer ... values) {
            super.onProgressUpdate(values);

            // pass some progress from here to interface
            // works in main thread, but should be invoked from doInBack
        }

        @Override
        protected String doInBackground(Void... params) { // in other thread
            // void params - array of parameters, use params[0] etc
            return ""; // result of method passed to post-exec, third arg in <>
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            //exec in main thread, so here result from other thread(doInBack) to interface
        }
    }
}
