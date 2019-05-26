package com.summer.dao.impl;

import com.summer.dao.IAccountDao;
import com.summer.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public List<Account> findAll() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Account findById(Integer id) {
        try {
            return runner.query("select * from account where id= ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name= ?,money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delAccount(Integer id) {
        try {
            runner.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
