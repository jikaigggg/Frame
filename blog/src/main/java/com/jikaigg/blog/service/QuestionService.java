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

    /**
     * 首页分页展示问题列表
     *
     * @param page
     * @param size
     * @return
     */
    public PageDTO selectList(Integer page, Integer size) {
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        Integer totalPage;
        PageDTO pageDTO = new PageDTO();
        //获取到数据库中question记录数
        Integer totalCount = questionMapper.counts();

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        //只能选择已有页数
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        //        System.out.println(totalCount);
        pageDTO.setPagination(totalPage, page);

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
//        System.out.println(pageDTO);

        return pageDTO;
    }

    /**
     * 指定作者id查找问题列表
     *
     * @param userId
     * @param page
     * @param size
     */
    public PageDTO selectList(Integer userId, Integer page, Integer size) {
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        Integer totalPage;
        PageDTO pageDTO = new PageDTO();
        //获取到数据库中question记录数
        Integer totalCount = questionMapper.userCounts(userId);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        //只能选择已有页数
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        //        System.out.println(totalCount);
        pageDTO.setPagination(totalPage, page);

        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.selectUserList(userId, offset, size);

        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        //将遍历出来的问题列表存到pageDTO中
        pageDTO.setQuestions(questionDTOS);
//        System.out.println(pageDTO);


        return pageDTO;
    }

    /**
     * 根据问题id查询问题对象
     *
     * @param id
     * @return
     */
    public QuestionDTO getQuestionById(Integer id) {
        Question question = questionMapper.getQuestionById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(userMapper.findById(question.getCreator()));
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        Question questionById = questionMapper.getQuestionById(question.getId());
        if (questionById != null) {
            question.setModifiedTime(System.currentTimeMillis());
            questionMapper.updateQuestion(question);
        } else {
            questionMapper.createQuestion(question);
        }
    }

    public void flushViewCount(Integer id) {
        questionMapper.flushViewCount(id);
    }
}
