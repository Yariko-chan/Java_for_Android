package com.example.diana.androidclasswork.di;

import com.example.diana.androidclasswork.lesson17.Gson;
import com.example.diana.androidclasswork.lesson17.OkHttp;
import com.example.diana.androidclasswork.lesson17.Rest;
import com.example.diana.androidclasswork.lesson17.SharedPrefs;
import com.example.diana.androidclasswork.lesson17.UseCase1;
import com.example.domain.interactions.ProfileUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 11.09.2017.
 */

@Module
public class AppModule {
    // how to create objects
    // complex dependencies

    // methods for creating objects
    @Provides
//    @Singleton эта аннотация говорит даггеру держать объект и всегда отдавать именно его. единственный объект
    public UseCase1 provideUseCase1(Rest rest, SharedPrefs prefs) {
        return new UseCase1(rest, prefs);
    }

    @Provides
    public Rest provideRest(Gson gson, OkHttp okHttp) {
        return new Rest(gson, okHttp);
    }

    @Provides
    public SharedPrefs providePrefs() {
        return new SharedPrefs();
    }

    @Provides
    public OkHttp provideOkHttp() {
        return new OkHttp();
    }

    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    public ProfileUseCase provideProfileUseCase() {
        return new ProfileUseCase();
    }
}
