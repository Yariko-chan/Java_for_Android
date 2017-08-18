package com.example.diana.androidclasswork.lesson12;

import android.databinding.ObservableField;

import com.example.diana.androidclasswork.base.BaseItemViewModel;
import com.example.domain.entity.DomainProfile;

/**
 * Created by Diana on 18.08.2017.
 */

public class Lesson12ItemViewModel extends BaseItemViewModel<DomainProfile> {
    public ObservableField<String> name = new ObservableField<>("");
    @Override
    public void setItem(DomainProfile item, int position) {
        name.set(item.getName());
    }
}
