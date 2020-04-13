package com.jikaigg.blog.mapper;

import com.jikaigg.blog.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(account_id,name,token,create_time,modified_time,avatar_url) values(#{accountId},#{name},#{token},#{createTime},#{modifiedTime},#{avatarUrl})")
    void inserUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
