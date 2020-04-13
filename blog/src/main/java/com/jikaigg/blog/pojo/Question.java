package com.jikaigg.blog.pojo;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long createTime;
    private Long modifiedTime;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
