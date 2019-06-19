package com.summer.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user")
public class User {
    // 主键
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
