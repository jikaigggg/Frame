package com.jikaigg.blog.service;

import com.jikaigg.blog.dto.PageDTO;
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

    public PageDTO selectList(Integer page, Integer size) {
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        PageDTO pageDTO = new PageDTO();
        //获取到数据库中question记录数
        Integer totalCount = questionMapper.counts();
        pageDTO.setPagination(totalCount,page,size);

        //只能选择已有页数
        if (page<1){
            page=1;
        }
        if (page>pageDTO.getTotalPage()){
            page = pageDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.selectList(offset, size);

        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        //将遍历出来的问题列表存到pageDTO中
        pageDTO.setQuestions(questionDTOS);

        return pageDTO;
    }
}
