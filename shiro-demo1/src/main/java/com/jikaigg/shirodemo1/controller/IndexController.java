package com.jikaigg.shirodemo1.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
import javax.xml.ws.RespectBinding;

@Controller
@Slf4j
public class IndexController {
    @RequestMapping(value = {"/","index"})
    public String toIndex(Model model){
        log.info("hello");
        model.addAttribute("msg","yaojikai");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        log.info("go to login");
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(String username,String password,Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //执行登陆的方法
        try {
            subject.login(token);
            log.info("try username id {} , password is {} ",token.getUsername(),token.getPassword());
            return "index";
        } catch (UnknownAccountException e) {
            log.info("one username id {} , password is {} ",token.getUsername(),token.getPassword());
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            log.info("two username id {} , password is {} ",token.getUsername(),token.getPassword());
            model.addAttribute("msg","密码错误");
            return "login";
        } catch (AuthenticationException e) {
            log.info("three username id {} , password is {} ",token.getUsername(),token.getPassword());
            model.addAttribute("msg","其他问题");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noauth(){
        return "未授权";
    }
}
