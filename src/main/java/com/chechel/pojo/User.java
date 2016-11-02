package com.chechel.pojo;

/**
 * Created by vitaliy on 01.11.16.
 */
public class User {
    private final String name;
    private final STATE state;

    public String getName() {
        return name;
    }

    public STATE getState() {
        return state;
    }

    public User(String name, STATE state) {
        this.name = name;
        this.state = state;
    }
}
