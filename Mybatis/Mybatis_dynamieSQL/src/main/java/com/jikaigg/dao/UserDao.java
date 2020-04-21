package com.jikaigg.dao;

import com.jikaigg.domain.QueryVo;
import com.jikaigg.domain.User;

import java.util.List;

/**
 * @author jikaigg
 * <p>
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     *
     * @return
     */
    List<User> findAll();


    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据QueryVo中的条件查询用户
     *
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件查询用户
     *
     * @param user 可能有用户名，也有可能有性别，也有可能是地址
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合，查询用户信息
     *
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
