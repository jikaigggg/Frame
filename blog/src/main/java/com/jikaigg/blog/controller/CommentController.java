package com.jikaigg.blog.controller;

import com.jikaigg.blog.dto.CommentDTO;
import com.jikaigg.blog.exception.CustomizeErrorCode;
import com.jikaigg.blog.pojo.ResultDTO;
import com.jikaigg.blog.pojo.User;
import com.jikaigg.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论控制器
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public ResultDTO post(@RequestBody CommentDTO commentDTO,
                          HttpServletRequest request){
        //从request中获取user
        User user = (User) request.getSession().getAttribute("user");
        //通过判断是否存在user，判断用户是否登录，如果没有登录，进行异常处理，提示用户登录
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
//        System.out.println(commentDTO);
        //设置commentDTO的commontator是user的id
        commentDTO.setCommentator(user.getId());
        commentService.insertComment(commentDTO);
        return ResultDTO.okOf();
    }
}
