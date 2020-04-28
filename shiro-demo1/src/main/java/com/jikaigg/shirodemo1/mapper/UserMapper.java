package com.jikaigg.shirodemo1.mapper;

import com.jikaigg.shirodemo1.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User queryUserByName(@Param("username") String username);
}
