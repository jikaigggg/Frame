package com.jikaigg.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 账户类
 * 账户类中除基本数据类型外还有一个User类的实体类参数
 */
public class Account implements Serializable {
    private String username;
    private String password;
    private Double money;

    private List<User> luser;
    private Map<String, User> muser;


    public List<User> getLuser() {
        return luser;
    }

    public void setLuser(List<User> luser) {
        this.luser = luser;
    }

    public Map<String, User> getMuser() {
        return muser;
    }

    public void setMuser(Map<String, User> muser) {
        this.muser = muser;
    }
/*    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", luser=" + luser +
                ", muser=" + muser +
                '}';
    }
}
