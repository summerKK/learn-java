package com.summer.dao.impl;

import com.summer.dao.IAccountDao;
import com.summer.domain.Account;
import com.summer.utils.ConnectionUtil;
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

    @Autowired
    private ConnectionUtil connectionUtil;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtil.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Account findById(Integer id) {
        try {
            return runner.query(connectionUtil.getThreadConnection(), "select * from account where id= ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(), "insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(), "update account set name= ?,money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delAccount(Integer id) {
        try {
            runner.update(connectionUtil.getThreadConnection(), "delete from account where id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Account findByName(String name) {
        try {
            List<Account> accountList = runner.query(connectionUtil.getThreadConnection(), "select * from account where name= ?", new BeanListHandler<Account>(Account.class), name);
            if (accountList == null || accountList.size() == 0) {
                throw new RuntimeException("用户不存在");
            }
            if (accountList.size() > 1) {
                throw new RuntimeException("用户姓名不唯一");
            }
            return accountList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
