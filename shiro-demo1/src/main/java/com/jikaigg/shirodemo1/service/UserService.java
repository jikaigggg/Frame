package com.jikaigg.shirodemo1.service;

import com.jikaigg.shirodemo1.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User queryUserByName(String username);
}
