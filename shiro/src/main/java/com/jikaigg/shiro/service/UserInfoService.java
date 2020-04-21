package com.jikaigg.shiro.service;

import com.jikaigg.shiro.entity.UserInfo;

public interface UserInfoService {
    /** 通过username查找用户信息；*/
    UserInfo findByUsername(String username);
}
