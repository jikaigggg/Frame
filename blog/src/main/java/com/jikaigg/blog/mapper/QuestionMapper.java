package com.jikaigg.blog.mapper;

import com.jikaigg.blog.dto.QuestionDTO;
import com.jikaigg.blog.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    /**
     * 提问的时候插入数据库问题数据
     * @param question
     */
    @Insert("insert into question(title,description,create_time,modified_time,creator,tag) " +
            "values(#{title},#{description},#{createTime},#{modifiedTime},#{creator},#{tag})")
    void createQuestion(Question question);

    /**
     * 首页查询问题，并进行分页处理
     * @param offset
     * @param size
     * @return
     */
    @Select("select * from question limit #{offset},#{size}")
    List<Question> selectList(@Param("offset") Integer offset, @Param("size") Integer size);

    /**
     * 首页查询数据库中所有问题数量
     * @return
     */
    @Select("select count(*) from question")
    Integer counts();

    /**
     * 查询单个用户的问题数量
     * @param userId
     * @return
     */
    @Select("select count(*) from question where creator = #{userId}")
    Integer userCounts(@Param("userId")Integer userId);

    /**
     * 根据用户id查询问题列表，并处理分页问题
     * @param userId
     * @param offset
     * @param size
     * @return
     */
    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> selectUserList(@Param("userId") Integer userId, @Param("offset") Integer offset, @Param("size") Integer size);

    /**
     * 根据用户id获取问题对象
     * @param id
     * @return
     */
    @Select("select * from question where id = #{id}")
    Question getQuestionById(@Param("id") Integer id);

    @Update("update question set title = #{title},description = #{description},tag = #{tag},modified_time = #{modifiedTime} where id = #{id}")
    void updateQuestion(Question question);
}
