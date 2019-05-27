package com.summer.service.impl;

import com.summer.service.IPerson;

public class PersonImpl implements IPerson {

    public void sleep(int minutes) {
        System.out.println("睡觉:" + minutes + "分钟");
    }

    public void work() {
        System.out.println("工作");
    }

    public void eat() {
        System.out.println("吃饭");
    }
}
