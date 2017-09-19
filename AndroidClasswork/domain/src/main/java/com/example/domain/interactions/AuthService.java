package com.example.domain.interactions;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.domain.entity.AuthState;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Diana on 19.09.2017.
 */

@Singleton
public class AuthService {
    public static final String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN";
    public static final String SHARED_PREFS_NAME = "SHARED_PREFS_NAME";
    private Context context; // get through dagger

    // saves last state of authorization
    // when some activity wants to observe this, it subscribes
    // and receives last state
    private BehaviorSubject<AuthState> state =
            BehaviorSubject.createDefault(new AuthState(false));

    @Inject
    public AuthService(Context context) {
        restoreAccessToken();
        this.context = context;
    }

    private void restoreAccessToken() {
        SharedPreferences prefs =
                context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        String token = prefs.getString(KEY_ACCESS_TOKEN, null);
        if (TextUtils.isEmpty(token)) {
            state.onNext(new AuthState(false));
        } else {
            state.onNext(new AuthState(true));
        }
    }

    void saveAccessToken(String token) {
        // save token locally
        SharedPreferences prefs =
                context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit()
                .putString(KEY_ACCESS_TOKEN, token)
                .apply();
        // notification to all listeners
        state.onNext(new AuthState(true));
    }

    void removeAccessToken() {    // things concerning ShPrefs should be in separate class,
        SharedPreferences prefs = // because rest also needs token
                context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit()
                .remove(KEY_ACCESS_TOKEN)
                .apply();
        // notification to all listeners
        state.onNext(new AuthState(false));

    }

    public Observable<AuthState> observeState() {
        return state;
    }
}
