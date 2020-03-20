package com.jikaigg.mapper;


import com.jikaigg.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select id,name,gender,age,address,email from user")
    List<User> findAll();
    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);
}
