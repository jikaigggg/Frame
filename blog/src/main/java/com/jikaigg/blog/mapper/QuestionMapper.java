package com.jikaigg.blog.mapper;

import com.jikaigg.blog.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,create_time,modified_time,creator,tag) " +
            "values(#{title},#{description},#{createTime},#{modifiedTime},#{creator},#{tag})")
    void createQuestion(Question question);

    @Select("select * from question")
    List<Question> selectAll();
}
