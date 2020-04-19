package com.jikaigg.blog.pojo;

import lombok.Data;

/**
 * comment的pojo
 */
@Data
public class Comment {
    /**
     * 父类ID
     */
    private Long parentId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 评论人ID
     */
    private Integer commentator;
    /**
     * 评论创建时间
     */
    private Long createTime;
    /**
     * 评论修改时间
     */
    private Long modifiedTime;
    /**
     * 评论的点赞数
     */
    private Long likeCount;
}
