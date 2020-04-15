package com.jikaigg.blog.pojo;

import lombok.Data;

/**
 * 个人持有的基金的对象
 */
@Data
public class UserFund {
    private Integer id;
    //持有份数
    private Integer fundNum;
    //持有时间
    private Long createTime;

    private Fund fund;
}
