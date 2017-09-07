package com.gmail.ganeeva.d.homework.lesson14.domain.entity;

import android.content.Context;

/**
 * Created by Diana on 06.09.2017.
 */

public class Lesson15Frankenstein {
    private Context context;
    private User user;

    public Lesson15Frankenstein(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
