package com.example.diana.androidclasswork.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * Created by Diana on 09.08.2017.
 */

public abstract class BaseActivity extends Activity {
    // как минимум должна знать когда активити открыта-закрыта, жизненный цикл

    protected BaseViewModel viewModel; // protected to make it visible for childs

    public void setViewModel(BaseViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        viewModel.init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}
