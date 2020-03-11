package com.jikaigg.dao;

import com.jikaigg.domain.User;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在mybatis中针对CRUD有四个注解
 * @Select  @Delete  @Insert  @Update
 */
public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "address",column = "address"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.jikaigg.dao.AccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 根据用户名称模糊查询用户信息
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);
}
