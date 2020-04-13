package com.jikaigg.blog.controller;

import com.jikaigg.blog.mapper.QuestionMapper;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.pojo.Question;
import com.jikaigg.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublicshController {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String dopublish(@RequestParam(value = "title" , required = false)String title,
                            @RequestParam(value = "description", required = false)String description,
                            @RequestParam(value = "tag", required = false)String tag,
                            HttpServletRequest request,
                            Model model){
        //先判断用户输入的是否为空
        if (title == null || title == ""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (description == null || description == ""){
            model.addAttribute("error","描述不能为空");
            return "publish";
        }
        if (tag == null || tag == ""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        //先判断用户是否登陆
        Cookie[] cookies = request.getCookies();
        User user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                //根据token查询数据库中是否有记录，有记录代表用户有信息，不用再次登陆
                user = userMapper.findByToken(token);
                if (user!=null){
                    //将查询出来的用户name存入session，前段可以直接取出来
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        //用户未登录，写入错误信息
        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setCreateTime(System.currentTimeMillis());
        question.setModifiedTime(question.getCreateTime());
        System.out.println(question);
        questionMapper.createQuestion(question);
        return "redirect:/";
    }
}
