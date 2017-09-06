package com.gmail.ganeeva.d.homework.lesson11.presentation.profiles_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;
import com.gmail.ganeeva.d.homework.base.BaseAdapter;
import com.gmail.ganeeva.d.homework.base.BaseItemHolder;
import com.gmail.ganeeva.d.homework.lesson11.presentation.profiles_list.item.Lesson11ItemHolder;
import com.gmail.ganeeva.d.homework.lesson11.presentation.profiles_list.item.Lesson11ItemViewModel;

/**
 * Created by Diana on 19.08.2017 at 14:54.
 */

class Lesson11ProfilesListAdapter
    <Holder extends Lesson11ItemHolder>
    extends BaseAdapter<DomainProfile, Lesson11ItemViewModel> {

    public Lesson11ProfilesListAdapter() {
    }

    @Override
    public BaseItemHolder<DomainProfile, Lesson11ItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {
        Lesson11ItemViewModel itemViewModel = new Lesson11ItemViewModel();
        Lesson11ItemHolder holder = Holder.create(LayoutInflater.from(parent.getContext()), parent, itemViewModel);
        return holder;
    }


}
