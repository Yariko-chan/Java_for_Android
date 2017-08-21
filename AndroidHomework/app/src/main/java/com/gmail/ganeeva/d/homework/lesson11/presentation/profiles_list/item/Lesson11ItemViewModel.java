package com.gmail.ganeeva.d.homework.lesson11.presentation.profiles_list.item;

import android.databinding.ObservableField;

import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfileId;
import com.gmail.ganeeva.d.homework.lesson11.presentation.base.BaseItemViewModel;

/**
 * Created by Diana on 19.08.2017 at 15:01.
 */

public class Lesson11ItemViewModel extends BaseItemViewModel<DomainProfile> {
    public ObservableField<String> profileNameSurname = new ObservableField<>("");
    public ObservableField<DomainProfileId> id = new ObservableField<>();

    @Override
    public void setItem(DomainProfile domainProfile) {
        profileNameSurname.set(domainProfile.getName() + " " + domainProfile.getSurname());
        id.set(domainProfile.getId());
    }
}
