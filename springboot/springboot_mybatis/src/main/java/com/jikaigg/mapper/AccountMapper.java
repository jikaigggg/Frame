package com.jikaigg.mapper;

import com.jikaigg.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    public List<Account> queryAccountList();
}
