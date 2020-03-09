package com.jikaigg.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    //不是数据库中的字段，不持久化到数据库中
    @Transient
    private String email;
}
