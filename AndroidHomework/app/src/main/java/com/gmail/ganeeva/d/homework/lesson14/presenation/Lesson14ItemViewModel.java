package com.gmail.ganeeva.d.homework.lesson14.presenation;

import android.databinding.ObservableField;

import com.gmail.ganeeva.d.homework.lesson14.domain.entity.AssetCountry;

/**
 * Created by Diana on 06.09.2017 at 10:59.
 */

public class Lesson14ItemViewModel {
    public ObservableField<AssetCountry> country = new ObservableField<>();

    public Lesson14ItemViewModel(AssetCountry country) {
        this.country.set(country);
    }

    public void setCountry(AssetCountry country) {
        this.country.set(country);
    }
}
