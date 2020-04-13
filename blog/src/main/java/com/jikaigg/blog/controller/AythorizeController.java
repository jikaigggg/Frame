package com.jikaigg.blog.controller;

import com.jikaigg.blog.dto.AccessTokenDTO;
import com.jikaigg.blog.dto.GithubUser;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.pojo.User;
import com.jikaigg.blog.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AythorizeController {
    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;

    //value注解取yml文件中配置的属性
    @Value("${github.client_id}")
    private String client_id;

    @Value("${github.setClient_secret}")
    private String setClient_secret;

    @Value("${github.setRedirect_uri}")
    private String setRedirect_uri;

    @GetMapping("callback")
    public String callback(@RequestParam("code")String code,
                           @RequestParam("state")String state,
                           HttpServletResponse response){
        //DTO网络传输时的对象
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(setClient_secret);
        accessTokenDTO.setRedirect_uri(setRedirect_uri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        //判断是否有用户，有的话进行操作，将信息存入数据库
        if (githubUser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setCreateTime(System.currentTimeMillis());
            user.setCreateTime(user.getCreateTime());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userMapper.inserUser(user);
            response.addCookie(new Cookie("token",token));
            //重定向到首页
            return "redirect:/";
        }else {
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
}
