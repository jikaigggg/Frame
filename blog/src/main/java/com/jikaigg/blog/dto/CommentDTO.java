package com.jikaigg.blog.dto;

import lombok.Data;

/**
 * comment的DTO
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
    private Integer commentator;
}
