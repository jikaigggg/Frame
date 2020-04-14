package com.jikaigg.blog.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面对象，包含页面中的数据展示，和分页信息
 */
@Data
public class PageDTO {
    //question列表
    private List<QuestionDTO> questions;
    //是否有上一页
    private Boolean showPrevious;
    //是否有返回首页
    private Boolean showFirstPage;
    //是否有下一页
    private Boolean showNext;
    //是否有跳转尾页
    private Boolean showEndPage;
    //当前页
    private Integer currentPage;
    //页面列表
    private List<Integer> pages = new ArrayList<Integer>();
    //总页数
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        //只能选择已有页数
        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page = totalPage;
        }
        currentPage = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0,page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }

        }
        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示第一页
        if (pages.contains(1)) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }


    }
}
