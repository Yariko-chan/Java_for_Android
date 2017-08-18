package com.example.diana.androidclasswork.lesson12;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.diana.androidclasswork.base.BaseItemViewHolder;
import com.example.diana.androidclasswork.base.BaseItemViewModel;
import com.example.diana.androidclasswork.databinding.ItemLesson12Binding;
import com.example.domain.entity.DomainProfile;

/**
 * Created by Diana on 18.08.2017.
 */

public class Lesson12ItemViewHolder
        extends BaseItemViewHolder
        <DomainProfile,
                Lesson12ItemViewModel,
                ItemLesson12Binding> {

    public Lesson12ItemViewHolder(ItemLesson12Binding dataBinding, Lesson12ItemViewModel viewModel) {
        super(dataBinding, viewModel);
    }

    public Lesson12ItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                         Lesson12ItemViewModel viewModel) {
        ItemLesson12Binding binding = ItemLesson12Binding.inflate(inflater, parent, false);
        return new Lesson12ItemViewHolder(binding, viewModel);
    }
}
