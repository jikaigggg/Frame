package com.jikaigg.controller;

import com.jikaigg.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("/testparam")
    public String testParam(String username){
        System.out.println("执行了");
        return username;
    }

    /**
     * 请求参数绑定，把数据封装到javabean
     * @param account
     * @return
     */
    @RequestMapping("/saveaccount")
    public String testParam1(Account account){
        System.out.println(account);
        return account.getUsername();
    }

}
