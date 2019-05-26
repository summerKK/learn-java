package com.summer.service;

import com.summer.domain.Account;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 替换Junit runner
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit 用xml还是注解方式加载容器
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private ApplicationContext application;

    @Test
    public void TestFindAll() {
        IAccountService accountService = application.getBean("accountService", IAccountService.class);
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void TestFindOne() {
        IAccountService accountService = application.getBean("accountService", IAccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void TestUpdate() {
        IAccountService accountService = application.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setMoney(12.11f);
        account.setName("Summer");
        accountService.updateAccount(account);

        Account account1 = accountService.findById(1);
        System.out.println(account1);

    }
}
