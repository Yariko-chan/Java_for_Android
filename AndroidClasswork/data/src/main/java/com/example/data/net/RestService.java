package com.example.data.net;

import com.example.data.entity.DataModel;
import com.example.data.entity.DataProfile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diana on 16.08.2017.
 */

public class RestService {
    public static final String BASE_URL = "https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/";
    private static RestService instance = new RestService();

    private RestAPI restAPI;

    private RestService() {
        init();
    }

    public static RestService getInstance() {
        return instance;
    }

    /**
     * settings for retrofit
     */
    public void init() {
        // замена HttpConnection с плюшками. низкоуровневое взаимодействие с интернетом. Тут можно логирование и ввсякие настройки
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS) // ограничение чтобы польхователь не ждал полчаса
                .connectTimeout(10, TimeUnit.SECONDS) // если сервер недоступен или ещё что-то не так
                .addInterceptor(logging) // logging
                .build();

        Gson gson = new GsonBuilder() // настройки парсинга json
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // базовая ссылка, домен + параметры
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // исп-е rx
                .addConverterFactory(GsonConverterFactory.create(gson)) // как парсить данные
                .client(okHttpClient) // как получать доступ к интернету; по умолчанию использует стандартное, okHttp даёт возможность настроить
                .build();

        restAPI = retrofit.create(RestAPI.class);
    }

    public Observable<List<DataProfile>> getProfiles() {
        return restAPI.getProfiles();
    }

    public Observable<Void> saveProfile(DataProfile profile) {
        return restAPI.saveProfile(profile);
    }
}
