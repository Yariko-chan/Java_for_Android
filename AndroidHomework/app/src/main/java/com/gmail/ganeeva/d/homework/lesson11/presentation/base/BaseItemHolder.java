package com.gmail.ganeeva.d.homework.lesson11.presentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Diana on 19.08.2017 at 14:23.
 */

public abstract class BaseItemHolder
    <Model,
    ViewModel extends BaseItemViewModel<Model>,
    DataBinding extends ViewDataBinding> extends RecyclerView.ViewHolder {

    DataBinding dataBinding;
    ViewModel viewModel;

    public BaseItemHolder(DataBinding dataBinding, ViewModel viewModel) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        this.viewModel = viewModel;
        viewModel.init();
    }

    public void bind(Model model) {
        viewModel.setItem(model);
        dataBinding.executePendingBindings(); // refresh layout
    }

    public void release() {
        viewModel.release();
    }
}
