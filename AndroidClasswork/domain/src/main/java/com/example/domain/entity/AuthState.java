package com.example.domain.entity;

/**
 * Created by Diana on 19.09.2017.
 */

public class AuthState {

    private boolean isAuthorized;

    public AuthState(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
}
