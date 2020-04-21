package com.jikaigg.shiro.dao;

import com.jikaigg.shiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    /** 通过username查找用户信息*/
    UserInfo findByUsername(String username);
}