package com.jikaigg.mapper;

import com.jikaigg.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User selectOne(Integer emp_id);

    /**
     * 更新用户
     * @param map
     * @return
     */
    int updateOne(Map map);

    int insertOne(User user);

    List<User> selectIn(Map map);

}
