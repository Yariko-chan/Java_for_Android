package com.gmail.ganeeva.d.homework.lesson14.presenation;

import android.databinding.ObservableField;
import android.view.View;

import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Country;

/**
 * Created by Diana on 06.09.2017 at 10:59.
 */

public class Lesson14ItemViewModel {
    public ObservableField<Country> country = new ObservableField<>();

    public Lesson14ItemViewModel(Country country) {
        this.country.set(country);
    }

    public void setCountry(Country country) {
        this.country.set(country);
    }
}
