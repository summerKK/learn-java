package com.summer.domain;

import java.io.Serializable;

public class Info implements Serializable {

    private User user;

    private String id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Info{" +
                "user=" + user +
                ", id='" + id + '\'' +
                '}';
    }
}
