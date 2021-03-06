package com.summer.mapper;

import com.summer.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void queryTest() {
        User user = userMapper.selectByPrimaryKey(41);
        System.out.println("user = " + user);

        List<User> users = userMapper.selectAll();
        for (User user1 : users) {
            System.out.println("user1 = " + user1);
        }
    }
}