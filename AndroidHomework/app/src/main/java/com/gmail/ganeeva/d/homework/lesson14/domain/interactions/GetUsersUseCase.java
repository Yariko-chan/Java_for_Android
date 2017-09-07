package com.gmail.ganeeva.d.homework.lesson14.domain.interactions;


import android.content.Context;

import com.gmail.ganeeva.d.homework.base.interactions.UseCase;
import com.gmail.ganeeva.d.homework.lesson14.data.db.DBManager;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.Country;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Diana on 07.09.2017 at 11:53.
 */

public class GetUsersUseCase extends UseCase<Context, ArrayList<User>> {
    @Override
    public Observable<ArrayList<User>> buildUseCase(final Context context) {
        DBManager manager = new DBManager(context);
        manager.openDB(true);
        ArrayList<com.gmail.ganeeva.d.homework.lesson14.data.db_entity.User> dbUserList =
            manager.getUsers();
        ArrayList<User> userList = new ArrayList<>();
        for (com.gmail.ganeeva.d.homework.lesson14.data.db_entity.User user: dbUserList) {
            User domainUser = convert(user);
            userList.add(domainUser);
        }
        manager.closeDB();
        return Observable.just(userList);
    }

    private User convert(com.gmail.ganeeva.d.homework.lesson14.data.db_entity.User dbUser) {
        User user = new User();
        user.setName(dbUser.getName());
        user.setAge(dbUser.getAge());
        user.setCountry(new Country(dbUser.getCountry().getId(), dbUser.getCountry().getName()));
        return user;
    }
}
