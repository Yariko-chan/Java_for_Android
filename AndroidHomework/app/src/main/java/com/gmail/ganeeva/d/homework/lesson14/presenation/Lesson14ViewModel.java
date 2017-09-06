package com.gmail.ganeeva.d.homework.lesson14.presenation;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.gmail.ganeeva.d.homework.base.BaseViewModel;
import com.gmail.ganeeva.d.homework.lesson14.domain.GetCountriesListUseCase;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Country;

import java.util.ArrayList;

/**
 * Created by Diana on 05.09.2017 at 12:31.
 */

public class Lesson14ViewModel implements BaseViewModel, AdapterView.OnItemSelectedListener {

    private static final String SELECTED_COUNTRY_PREFS = "SELECTED_COUNTRY_PREFS";
    private static final String SAVED_COUNTRY_KEY = "SAVED_TEXT";

    private final Context context;
    private final ArrayList<Country> countryList;

    public Lesson14CountrySpinnerAdapter adapter;
    public int selection = 0;

    public Lesson14ViewModel(Context context) {
        this.context = context;

        // get countries
        GetCountriesListUseCase useCase = new GetCountriesListUseCase();
        this.countryList = useCase.execute(this.context);

        // setup adapter
        adapter = new Lesson14CountrySpinnerAdapter();
        adapter.setCountryList(countryList);
        adapter.notifyDataSetChanged();

        // setup default selection for spinner
        SharedPreferences sPref =
            context.getSharedPreferences(SELECTED_COUNTRY_PREFS, Context.MODE_PRIVATE);
        String countryCode = sPref.getString(SAVED_COUNTRY_KEY, "");
        selection = findCountryIndexByCode(countryCode);
    }

    @Override
    public void init() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void release() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SharedPreferences sPref =
            context.getSharedPreferences(SELECTED_COUNTRY_PREFS, Context.MODE_PRIVATE);
        sPref.edit()
            .putString(SAVED_COUNTRY_KEY, countryList.get(position).getCode())
            .commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int findCountryIndexByCode(String code) {
        if (null == code) return 0;
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return 0;
    }
}
