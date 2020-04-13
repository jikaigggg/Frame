package com.jikaigg.blog.dto;

import com.jikaigg.blog.pojo.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionDTO implements Serializable {
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
    private User user;
}
