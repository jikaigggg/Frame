package com.jikaigg.blog.pojo;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Data
public class Question implements Serializable {
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
