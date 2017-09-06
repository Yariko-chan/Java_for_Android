package com.gmail.ganeeva.d.homework.lesson14.domain;

import android.content.Context;
import android.content.res.AssetManager;

import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Country;
import com.gmail.ganeeva.d.homework.lesson9.domain.UseCase;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Diana on 05.09.2017 at 12:50.
 */

public class GetCountriesListUseCase extends UseCase<Context, ArrayList<Country>> {

    public static final String FILE_NAME = "countries.json";

    @Override
    public ArrayList<Country> buildUseCase(Context context) {
        AssetManager am = context.getAssets();
        InputStream is = null;
        byte[] buffer = null;
        try {
            is = am.open(FILE_NAME);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = new String(buffer);
        Gson gson = new Gson();
        Country[] countries = gson.fromJson(jsonString, Country[].class);
        return new ArrayList<Country>(Arrays.asList(countries));
    }
}
