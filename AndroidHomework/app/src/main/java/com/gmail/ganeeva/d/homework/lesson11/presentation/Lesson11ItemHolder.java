package com.gmail.ganeeva.d.homework.lesson11.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.ganeeva.d.homework.databinding.ItemLesson11Binding;
import com.gmail.ganeeva.d.homework.lesson11.domain.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.presentation.base.BaseItemHolder;

/**
 * Created by Diana on 19.08.2017 at 15:04.
 */

public class Lesson11ItemHolder extends BaseItemHolder<DomainProfile, Lesson11ItemViewModel, ItemLesson11Binding> {

    public Lesson11ItemHolder(ItemLesson11Binding dataBinding, Lesson11ItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setUser(viewModel);
    }

    public static Lesson11ItemHolder create(LayoutInflater inflater, ViewGroup parent,
                                                Lesson11ItemViewModel viewModel) {
        ItemLesson11Binding binding = ItemLesson11Binding.inflate(inflater, parent, false);
        return new Lesson11ItemHolder(binding, viewModel);
    }
}
