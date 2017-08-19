package com.gmail.ganeeva.d.homework.lesson11.presentation;

import android.databinding.ObservableField;

import com.gmail.ganeeva.d.homework.lesson11.domain.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.presentation.base.BaseItemViewModel;

/**
 * Created by Diana on 19.08.2017 at 15:01.
 */

public class Lesson11ItemViewModel extends BaseItemViewModel<DomainProfile> {
    public ObservableField<String> profileNameSurname = new ObservableField<>("");

    @Override
    public void setItem(DomainProfile domainProfile) {
        profileNameSurname.set(domainProfile.getName() + " " + domainProfile.getSurname());
    }
}
