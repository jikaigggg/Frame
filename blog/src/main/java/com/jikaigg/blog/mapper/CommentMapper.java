package com.jikaigg.blog.mapper;

import com.jikaigg.blog.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    /**
     * 插入评论
     * @param comment
     */
    @Insert("insert into comment(parent_id,content,type,commentator,create_time,modified_time,like_count) " +
            " values(#{parentId},#{content},#{type},#{commentator},#{createTime},#{modifiedTime},#{likeCount})")
    void insert(Comment comment);

    /**
     * 根据问题id查询评论
     * @param parentId
     * @return
     */
    @Select("select * from comment where parent_id = #{parentId}")
    Comment selectCommentById(@Param("parentId") Long parentId);
}
