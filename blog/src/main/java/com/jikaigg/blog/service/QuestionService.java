package com.jikaigg.blog.service;

import com.jikaigg.blog.dto.QuestionDTO;
import com.jikaigg.blog.mapper.QuestionMapper;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.pojo.Question;
import com.jikaigg.blog.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    public List<QuestionDTO> selectAll() {
        List<Question> questionList = questionMapper.selectAll();
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
