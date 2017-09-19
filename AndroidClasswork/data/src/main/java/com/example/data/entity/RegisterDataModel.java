package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 19.09.2017.
 */

public class RegisterDataModel implements DataModel {
    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;

    public RegisterDataModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
