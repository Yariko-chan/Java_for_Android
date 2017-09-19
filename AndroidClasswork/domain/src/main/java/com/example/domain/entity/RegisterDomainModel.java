package com.example.domain.entity;

/**
 * Created by Diana on 19.09.2017.
 */

public class RegisterDomainModel implements DomainModel {
    private String userName;
    private String password;

    public RegisterDomainModel(String username, String password) {
        this.userName = username;
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
