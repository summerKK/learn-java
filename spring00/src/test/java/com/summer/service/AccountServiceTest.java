package com.summer.service;

import com.summer.domain.Account;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AccountServiceTest {

    private ApplicationContext application = null;

    @Before
    public void init() {
        this.application = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    }

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
