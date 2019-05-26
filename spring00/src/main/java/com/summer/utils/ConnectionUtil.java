package com.summer.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;

@Service("connectionUtil")
public class ConnectionUtil {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource datasource;

    public Connection getThreadConnection() {
        try {
            // 1. 先从threadLocal上面获取
            Connection connection = threadLocal.get();
            if (connection == null) {
                // 从数据库连接池获取连接
                connection = datasource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数据库连接池的连接已放回连接池,已经失效.把线程和连接解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }
}
