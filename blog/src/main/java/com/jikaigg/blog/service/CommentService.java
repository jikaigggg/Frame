package com.jikaigg.blog.service;

import com.jikaigg.blog.dto.CommentDTO;
import com.jikaigg.blog.enums.CommentTypeEnum;
import com.jikaigg.blog.exception.CustomizeErrorCode;
import com.jikaigg.blog.exception.CustomizeException;
import com.jikaigg.blog.mapper.CommentMapper;
import com.jikaigg.blog.mapper.QuestionMapper;
import com.jikaigg.blog.pojo.Comment;
import com.jikaigg.blog.pojo.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    QuestionMapper questionMapper;

    /**
     * 接受网络传输的commentDTO
     * 处理后调用Mapper插入数据库
     *
     * @param commentDTO
     */
    @Transactional
    public void insertComment(CommentDTO commentDTO) {
        //新建一个comment的pojo用来映射数据库
        Comment comment = new Comment();
        //将commentDTO中的字段赋值到comment实体类上
        BeanUtils.copyProperties(commentDTO, comment);
        //添加创建时间
        comment.setCreateTime(System.currentTimeMillis());
        //判断是否选择了要评论的文章id，没有的话返回
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        //判断恢复类型是否存在
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPR_PARAM_NOT_FOUND);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectCommentById(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            //调用mapper插入数据库
            commentMapper.insert(comment);
        } else {
            //回复问题
            commentMapper.insert(comment);
            System.out.println(comment.getParentId().intValue());
            //给问题添加完以及评论之后需要更新question表中的comment_count字段加一
            questionMapper.updateQuestionCommentCount(comment.getParentId().intValue());
        }
    }

    ;
}
