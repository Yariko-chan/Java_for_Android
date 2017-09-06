package com.gmail.ganeeva.d.homework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.ganeeva.d.homework.base.BaseViewModel;

/**
 * Created by Diana on 19.08.2017 at 14:18.
 */

public class BaseActivity extends Activity{
    private BaseViewModel viewModel;

    public void setViewModel(BaseViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}
