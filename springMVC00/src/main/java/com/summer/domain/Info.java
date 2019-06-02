package com.summer.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Info implements Serializable {

    private User user;

    private Integer id;

    private List<User> list;

    private Map<String, User> map;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Info{" +
                "user=" + user +
                ", id=" + id +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
