package com.jikaigg.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/select1")
    public List<Map<String, Object>> select1(){
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @GetMapping("/insert1/{name}/{money}")
    public String insert1(@PathVariable("name")String name,
                          @PathVariable("money")Float money){
        String sql="insert into account(name,money) value(?,?)";
        int update = jdbcTemplate.update(sql,name,money);
        if (update == 1){
            return "成功";
        }
        return "失败";
    }

}
