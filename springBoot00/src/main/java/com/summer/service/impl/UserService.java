package com.summer.service.impl;

import com.summer.mapper.UserMapper;
import com.summer.pojo.User;
import com.summer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
