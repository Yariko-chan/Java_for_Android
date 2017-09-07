package com.gmail.ganeeva.d.homework.lesson14.presenation;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.gmail.ganeeva.d.homework.base.BaseViewModel;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Country;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Lesson15Frankenstein;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.User;
import com.gmail.ganeeva.d.homework.lesson14.domain.interactions.GetCountriesListUseCase;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.AssetCountry;
import com.gmail.ganeeva.d.homework.lesson14.domain.interactions.GetUsersUseCase;
import com.gmail.ganeeva.d.homework.lesson14.domain.interactions.SaveUserUseCase;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Diana on 05.09.2017 at 12:31.
 */

public class Lesson14ViewModel implements BaseViewModel, AdapterView.OnItemSelectedListener {

    private static final String SELECTED_COUNTRY_PREFS = "SELECTED_COUNTRY_PREFS";
    private static final String SAVED_COUNTRY_KEY = "SAVED_TEXT";
    private static final String SAVED_USER_NAME = "SAVED_USER_NAME";
    private static final String SAVED_USER_AGE = "SAVED_USER_AGE";

    private final Context context;
    private final ArrayList<AssetCountry> countryList;

    public Lesson14CountrySpinnerAdapter adapter;

    public ObservableField<String> userName = new ObservableField<>();
    public ObservableInt userAge = new ObservableInt();
    public int countryListSelectedPosition = 0;

    public Lesson14ViewModel(Context context) {
        this.context = context;

        // get countries
        GetCountriesListUseCase useCase = new GetCountriesListUseCase();
        this.countryList = useCase.execute(this.context);

        // setup adapter
        adapter = new Lesson14CountrySpinnerAdapter();
        adapter.setCountryList(countryList);
        adapter.notifyDataSetChanged();

        // setup default countryListSelectedPosition for spinner
        SharedPreferences sPref =
            context.getSharedPreferences(SELECTED_COUNTRY_PREFS, Context.MODE_PRIVATE);
        String countryCode = sPref.getString(SAVED_COUNTRY_KEY, "");
        countryListSelectedPosition = findCountryIndexByCode(countryCode);
        userName.set(sPref.getString(SAVED_USER_NAME, ""));
        userAge.set(sPref.getInt(SAVED_USER_AGE, 0));
    }

    @Override
    public void init() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        SharedPreferences sPref =
            context.getSharedPreferences(SELECTED_COUNTRY_PREFS, Context.MODE_PRIVATE);
        sPref.edit()
            .putString(SAVED_USER_NAME, userName.get())
            .putInt(SAVED_USER_AGE, userAge.get())
            .putString(SAVED_COUNTRY_KEY, countryList.get(countryListSelectedPosition).getCode())
            .commit();

    }

    @Override
    public void release() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        countryListSelectedPosition = position;
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

    public void saveUserToDB() {
//        User user = new User();
//        user.setName(userName.get());
//        user.setAge(userAge.get());
//        user.setCountry(new Country(countryList.get(countryListSelectedPosition).getName()));
//
//        SaveUserUseCase useCase = new SaveUserUseCase();
//        Lesson15Frankenstein franky = new Lesson15Frankenstein(context, user);
//        useCase.execute(franky, new DisposableObserver<Integer>() {
//            @Override
//            public void onNext(@NonNull Integer aVoid) {
//                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        new GetUsersUseCase().execute(context, new DisposableObserver<ArrayList<User>>() {
            @Override
            public void onNext(@NonNull ArrayList<User> users) {
                Log.d("", "");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
