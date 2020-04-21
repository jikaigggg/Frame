package com.jikaigg.shiro.service.impl;

import com.jikaigg.shiro.dao.UserInfoDao;
import com.jikaigg.shiro.entity.UserInfo;
import com.jikaigg.shiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
