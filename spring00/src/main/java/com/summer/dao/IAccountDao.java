package com.summer.dao;

import com.summer.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void delAccount(Integer id);

    Account findByName(String name);
}
