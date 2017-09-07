package com.gmail.ganeeva.d.homework.lesson14.domain.interactions;

import android.content.Context;
import android.content.res.AssetManager;

import com.gmail.ganeeva.d.homework.lesson14.domain.entity.AssetCountry;
import com.gmail.ganeeva.d.homework.lesson9.domain.UseCase;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Diana on 05.09.2017 at 12:50.
 */

public class GetCountriesListUseCase extends UseCase<Context, ArrayList<AssetCountry>> {

    public static final String FILE_NAME = "countries.json";

    @Override
    public ArrayList<AssetCountry> buildUseCase(Context context) {
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
        AssetCountry[] countries = gson.fromJson(jsonString, AssetCountry[].class);
        return new ArrayList<AssetCountry>(Arrays.asList(countries));
    }
}
