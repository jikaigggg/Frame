package com.jikaigg.blog.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long createTime;
    private Long modifiedTime;

}
