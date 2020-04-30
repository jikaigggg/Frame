package com.jikaigg.shirodemo1.controller;

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
public class IndexController {
    @RequestMapping(value = {"/","index"})
    public String toIndex(Model model){
        model.addAttribute("msg","yaojikai");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
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
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "login";
        } catch (AuthenticationException e) {
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
