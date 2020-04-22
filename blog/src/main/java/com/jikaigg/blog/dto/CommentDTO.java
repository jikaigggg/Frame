package com.jikaigg.blog.dto;

import com.jikaigg.blog.pojo.User;
import lombok.Data;

import java.io.Serializable;

/**
 * comment的DTO
 */
@Data
public class CommentDTO implements Serializable {
    private Long parentId;
    private String content;
    private Integer type;
    private Integer commentator;
    private User user;
}
