package com.gmail.ganeeva.d.homework.lesson11.presentation.profiles_list.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ganeeva.d.homework.databinding.ItemLesson11Binding;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.presentation.ClickHandler;
import com.gmail.ganeeva.d.homework.base.BaseItemHolder;

/**
 * Created by Diana on 19.08.2017 at 15:04.
 */

public class Lesson11ItemHolder extends BaseItemHolder<DomainProfile, Lesson11ItemViewModel, ItemLesson11Binding> {

    public Lesson11ItemHolder(ItemLesson11Binding dataBinding, Lesson11ItemViewModel viewModel, ClickHandler clickHandler) {
        super(dataBinding, viewModel);
        dataBinding.setProfile(viewModel);
        dataBinding.setHandler(clickHandler);
    }

    public static Lesson11ItemHolder create(LayoutInflater inflater, ViewGroup parent,
                                                Lesson11ItemViewModel viewModel) {
        ItemLesson11Binding binding = ItemLesson11Binding.inflate(inflater, parent, false);
        return new Lesson11ItemHolder(binding, viewModel, new ClickHandler(parent.getContext()));
    }
}
