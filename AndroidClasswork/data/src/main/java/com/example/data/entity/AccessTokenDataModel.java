package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 19.09.2017.
 */

public class AccessTokenDataModel implements DataModel {
    @SerializedName("access-token")
    private String token;

    public AccessTokenDataModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
