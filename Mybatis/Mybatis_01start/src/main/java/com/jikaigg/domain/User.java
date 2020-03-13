package com.jikaigg.domain;


public class User {
    private Integer emp_id;
    private String uname;
    private Integer age;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + emp_id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }
}
