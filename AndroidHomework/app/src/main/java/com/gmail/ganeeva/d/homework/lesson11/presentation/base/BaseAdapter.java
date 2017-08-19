package com.gmail.ganeeva.d.homework.lesson11.presentation.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diana on 19.08.2017 at 14:22.
 */

public abstract class BaseAdapter
    <Model, ViewModel extends BaseItemViewModel<Model>>
    extends RecyclerView.Adapter<BaseItemHolder<Model, ViewModel, ?>> {

    private List<Model> items = new ArrayList<>();
    public void setItems(List<Model> items) {
        this.items = items;
    }

    @Override
    public void onBindViewHolder(BaseItemHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
