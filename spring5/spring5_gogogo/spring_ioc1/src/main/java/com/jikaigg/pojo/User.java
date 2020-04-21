package com.jikaigg.pojo;

/**
 * 一个实体类，有无参构造方法
 */
public class User {
    private String name;

    public User() {
        System.out.println("无参构造方法运行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name" + name);
    }
}
