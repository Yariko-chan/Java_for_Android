package com.gmail.ganeeva.d.homework.lesson14.domain.interactions;

import com.gmail.ganeeva.d.homework.lesson14.data.db.DBManager;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Country;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Lesson15Frankenstein;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.User;
import com.gmail.ganeeva.d.homework.base.interactions.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Diana on 06.09.2017.
 */

public class SaveUserUseCase extends UseCase<Lesson15Frankenstein, Integer> {
    @Override
    public Observable<Integer> buildUseCase(final Lesson15Frankenstein user) {

        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {

                DBManager manager = new DBManager(user.getContext());
                manager.openDB(true);
                manager.insertUser(convert(user.getUser()));
                manager.closeDB();

            }
        }).just(new Integer(0));
    }

    private com.gmail.ganeeva.d.homework.lesson14.data.db_entity.User convert(User user) {
        com.gmail.ganeeva.d.homework.lesson14.data.db_entity.User dbUser =
            new com.gmail.ganeeva.d.homework.lesson14.data.db_entity.User();
        dbUser.setId(user.getId());
        dbUser.setAge(user.getAge());
        dbUser.setName(user.getName());
        dbUser.setCountry(convert(user.getCountry()));
        return dbUser;
    }

    private com.gmail.ganeeva.d.homework.lesson14.data.db_entity.Country convert(Country country) {
        com.gmail.ganeeva.d.homework.lesson14.data.db_entity.Country dbCountry =
                new com.gmail.ganeeva.d.homework.lesson14.data.db_entity.Country(country.getId(), country.getName());
        return dbCountry;
    }
}
