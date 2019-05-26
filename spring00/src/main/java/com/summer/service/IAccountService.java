package com.summer.service;

import com.summer.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);

    Account findByName(String name);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void delAccount(Integer id);

    void transfer(String sourceName, String targetName, Float money);
}
