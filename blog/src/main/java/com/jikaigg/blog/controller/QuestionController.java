package com.jikaigg.blog.controller;

import com.jikaigg.blog.dto.CommentDTO;
import com.jikaigg.blog.dto.QuestionDTO;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.service.CommentService;
import com.jikaigg.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 处理问题的controller
 */

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model) {
        questionService.flushViewCount(id);
        QuestionDTO questionDTO = questionService.getQuestionById(id);
        List<CommentDTO> commentDTOs = commentService.listByQuestionId(id);
        for (CommentDTO commentDTO : commentDTOs) {
            commentDTO.setUser(userMapper.findById(commentDTO.getCommentator()));
        }
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments",commentDTOs);
        return "question";
    }
}
