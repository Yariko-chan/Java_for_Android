package com.example.diana.androidclasswork.lesson12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.diana.androidclasswork.base.BaseAdapter;
import com.example.diana.androidclasswork.base.BaseItemViewHolder;
import com.example.domain.entity.DomainProfile;

/**
 * Created by Diana on 18.08.2017.
 */

public class Lesson12Adapter extends BaseAdapter
        <DomainProfile, Lesson12ItemViewModel> {

    @Override
    public BaseItemViewHolder<DomainProfile, Lesson12ItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {
        Lesson12ItemViewModel itemViewModel = new Lesson12ItemViewModel();
        return Lesson12ItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
