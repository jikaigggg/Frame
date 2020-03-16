package com.jikaigg.pojo;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private Integer deptId;
}
