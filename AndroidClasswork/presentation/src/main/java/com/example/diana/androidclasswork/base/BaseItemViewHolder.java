package com.example.diana.androidclasswork.base;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Diana on 18.08.2017.
 */

public abstract class BaseItemViewHolder
        <Model,
        ViewModel extends BaseItemViewModel,
        DataBinding extends ViewDataBinding>

        extends RecyclerView.ViewHolder {

    private DataBinding dataBinding;
    private ViewModel viewModel;

    public BaseItemViewHolder(DataBinding dataBinding, ViewModel viewModel) {
        super(dataBinding.getRoot());

        this.dataBinding = dataBinding;
        this.viewModel = viewModel;

        viewModel.init();
    }

    public void bindTo(Model item, int position){
        viewModel.setItem(item, position);
        dataBinding.executePendingBindings();
    }

    public void release() {
        viewModel.release();
    }
}
