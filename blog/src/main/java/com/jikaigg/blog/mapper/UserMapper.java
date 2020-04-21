package com.jikaigg.blog.mapper;

import com.jikaigg.blog.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /**
     * 插入用户
     *
     * @param user
     */
    @Insert("insert into user(account_id,name,token,create_time,modified_time,avatar_url) " +
            "values(#{accountId},#{name},#{token},#{createTime},#{modifiedTime},#{avatarUrl})")
    void inserUser(User user);

    /**
     * 根据token查询用户
     *
     * @param token
     * @return
     */
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    /**
     * 根据accountId查询用户
     *
     * @param accountId
     * @return
     */
    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set name = #{name},token = #{token},modified_time = #{modifiedTime},avatar_url = #{avatarUrl} " +
            "where id = #{id}")
    void updateUser(User user);
}
