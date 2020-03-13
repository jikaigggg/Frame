package com.jikaigg.domain;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer deptId;
    private String deptLeader;
    private String deptName;
    private List<Employee> employee;
}
