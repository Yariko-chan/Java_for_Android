package com.example.domain.interactions;

import android.content.Context;

import com.example.data.db.DBManager;
import com.example.domain.entity.Country;
import com.example.domain.entity.Lesson15Frankenstein;
import com.example.domain.entity.User;
import com.example.domain.interactions.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Diana on 06.09.2017.
 */

public class SaveUserUseCase extends UseCase<Lesson15Frankenstein, Void> {
    @Override
    public Observable<Void> buildUseCase(final Lesson15Frankenstein user) {

        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {

                DBManager manager = new DBManager(user.getContext());
                manager.openDB(true);
                manager.insertUser(convert(user.getUser()));
                manager.closeDB();

            }
        }).just(null);
    }

    private com.example.data.db_entity.User convert(User user) {
        com.example.data.db_entity.User dbUser = new com.example.data.db_entity.User();
        dbUser.setId(user.getId());
        dbUser.setAge(user.getAge());
        dbUser.setName(user.getName());
        dbUser.setCountry(convert(user.getCountry()));
        return dbUser;
    }

    private com.example.data.db_entity.Country convert(Country country) {
        com.example.data.db_entity.Country dbCountry =
                new com.example.data.db_entity.Country(country.getId(), country.getName());
        return dbCountry;
    }
}
