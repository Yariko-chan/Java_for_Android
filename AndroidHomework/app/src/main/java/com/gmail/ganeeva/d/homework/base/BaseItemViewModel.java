package com.gmail.ganeeva.d.homework.base;

import com.gmail.ganeeva.d.homework.base.BaseViewModel;

/**
 * Created by Diana on 19.08.2017 at 14:23.
 */

public abstract class BaseItemViewModel<Model> implements BaseViewModel {

    public abstract void setItem(Model model);

    @Override
    public void init() {

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
