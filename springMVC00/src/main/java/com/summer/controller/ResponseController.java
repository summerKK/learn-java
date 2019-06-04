package com.summer.controller;

import com.summer.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {

    @RequestMapping("/json")
    public @ResponseBody
    User json(@RequestBody User user) {
        user.setUsername("Summer111");
        return user;
    }
}
