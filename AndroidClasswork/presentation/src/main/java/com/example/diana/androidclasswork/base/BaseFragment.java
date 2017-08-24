package com.example.diana.androidclasswork.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Diana on 24.08.2017 at 17:07.
 */

public abstract class BaseFragment extends Fragment {

    protected BaseViewModel viewModel; // protected to make it visible for childs

    public void setViewModel(BaseViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.init();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }

}
