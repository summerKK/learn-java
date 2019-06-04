package com.summer.controller;

import com.summer.domain.Info;
import com.summer.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes(value = {"msg"})
public class HelloController {

    @RequestMapping(path = "/say-hello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "success";
    }

    @RequestMapping(path = "/params", method = {RequestMethod.POST})
    public String getParams(Info info) {
        System.out.println(info);
        return "success";
    }

    @RequestMapping(path = "/user")
    public String getUser(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping(path = "/session-attirbutes")
    public String sessionAttributes(Model model, User user) {
        model.addAttribute("msg", "Summer");
        System.out.println(user);
        return "success";
    }

    /**
     * 先与{sessionAttributes,getUser}方法之前执行
     *
     * @return
     */
    @ModelAttribute
    public User modelAttribute() {
        User user = new User();
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("Summer");
        return user;
    }
}
