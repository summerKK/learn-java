package com.summer.service;

import com.summer.pojo.User;

public interface IUserService {

    User queryById(Integer id);

    void insertUser(User user);
}
