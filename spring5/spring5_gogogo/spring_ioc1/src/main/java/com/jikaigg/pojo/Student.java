package com.jikaigg.pojo;

/**
 * 一个实体类，仅有有参构造方法
 */
public class Student {
    private String name;

    public Student(String name){
        this.name = name;
        System.out.println("有参构造方法运行："+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name"+name);
    }
}
