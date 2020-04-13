package com.jikaigg.blog.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long createTime;
    private Long modifiedTime;
    private String avatarUrl;

}
